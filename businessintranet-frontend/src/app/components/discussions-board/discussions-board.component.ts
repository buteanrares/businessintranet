import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { last, lastValueFrom } from 'rxjs';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';
import { BoardTopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';
import { EnumRole } from 'src/app/models/role-models/enum-roles';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
import { DiscussionsBoardService } from './service/discussions-board.service';

@Component({
  selector: 'app-discussions-board',
  templateUrl: './discussions-board.component.html',
  styleUrls: ['./discussions-board.component.scss']
})
export class DiscussionsBoardComponent implements OnInit {
  loggedInUser: EmployeeModelExtended;
  messages: any[] = [];
  topics: BoardTopicBaseModel[] = [];
  selectedTopic: BoardTopicBaseModel;
  selectedTopicId: number;
  postMessagePlaceholder = "Post a message..."
  messageContent: string;
  constructor(private authenticationService: AuthenticationService, private toastr: ToastrService, private discussionsBoardService: DiscussionsBoardService) { }

  async ngOnInit(): Promise<void> {
    this.authenticationService.getLoggedInUser().subscribe(
      rsp => {
        this.loggedInUser = rsp;
      }
    )
    const topics$ = await lastValueFrom(this.discussionsBoardService.getAllBoardTopics())
    topics$.forEach(topic => {
      this.topics.push(topic)
    });
    this.selectedTopic = this.topics[0];
    this.selectedTopicId = this.selectedTopic.id
    await this.refreshBoardTopicMessages(this.selectedTopicId);
  }

  async onSelectedTopicChange(selectedTopicId: number) {
    this.selectedTopicId = selectedTopicId;
    this.discussionsBoardService.getBoardTopicById(selectedTopicId).subscribe(
      rsp => this.selectedTopic = rsp
    );
    await this.refreshBoardTopicMessages(this.selectedTopicId);
  }

  private async refreshBoardTopicMessages(selectedTopicId: number) {
    this.messages = [];
    const messages$ = await lastValueFrom(this.discussionsBoardService.getAllBoardMessagesByTopicId(selectedTopicId))
    messages$.forEach(message => {
      this.messages.push(message);
    });
  }

  addBoardTopic(event: any) {
    delete event.data.__KEY__;
    this.discussionsBoardService.addBoardTopic(event.data).subscribe({
      next: () => this.toastr.success("Board topic added"),
      error: err => this.toastr.error(err.message)
    })
  }

  updateBoardTopic(event: any) {
    this.discussionsBoardService.getBoardTopicById(event.data.parentId).subscribe({
      next: rsp => {
        event.data.parentBoardTopic = rsp;
        this.discussionsBoardService.updateBoardTopic(event.data).subscribe(
          {
            next: () => this.toastr.success("Board topic updated"),
            error: err => this.toastr.error(err.message)
          }
        );
      },
      error: () => this.toastr.error("Board topic with id " + event.data.parentId + " does not exist")
    })
  }

  deleteBoardTopic(event: any) {
    this.discussionsBoardService.deleteBoardTopic(event.data.id).subscribe(
      {
        next: () => this.toastr.success("Board topic deleted"),
        error: err => this.toastr.error(err.message)
      }
    )
  }

  async postBoardMessage() {
    let boardMessage = new MessageBaseModel();
    this.mapDataToBoardMessage(boardMessage);
    this.discussionsBoardService.addBoardMessage(boardMessage).subscribe({
      next: rsp => {
        boardMessage = rsp; // gets Id attribute
        this.selectedTopic.boardMessages.push(boardMessage);
        this.discussionsBoardService.updateBoardTopic(this.selectedTopic).subscribe({
          next: () => this.toastr.success("Board message posted"),
          error: () => this.toastr.error("Error posting board message")
        })
      },
      error: () => this.toastr.error("Error posting board message")
    })
    await this.refreshBoardTopicMessages(this.selectedTopicId);
  }

  private mapDataToBoardMessage(boardMessage: MessageBaseModel) {
    boardMessage.sender = this.loggedInUser;
    boardMessage.content = this.messageContent;
    boardMessage.timeSent = new Date();
    boardMessage.referencedBoardTopicId = this.selectedTopic.id;
    return boardMessage;
  }

  hasPermissionToManage() {
    return this.loggedInUser.roles.some(role => [EnumRole.ROLE_CEO, EnumRole.ROLE_HRMANAGER].includes(role));
  }
}
