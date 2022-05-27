import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';
import { TopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { DiscussionsBoardService } from './service/discussions-board.service';

@Component({
  selector: 'app-discussions-board',
  templateUrl: './discussions-board.component.html',
  styleUrls: ['./discussions-board.component.scss']
})
export class DiscussionsBoardComponent implements OnInit {
  messages: any[];
  topics: TopicBaseModel[];
  selectedTopic: TopicBaseModel;
  postMessagePlaceholder = "Post a message..."
  messageContent: string;
  constructor(private toastr: ToastrService, private discussionsBoardService: DiscussionsBoardService) { }

  ngOnInit(): void {
    this.discussionsBoardService.getAllBoardTopics().subscribe(
      rsp => {
        this.topics = rsp;
        this.selectedTopic = this.topics[0];
      }
    );
  }

  setSelectedTopic(event: any) {
    this.selectedTopic = event.data.id;
  }

  addDiscussionTopic(event: any) {
    delete event.data.__KEY__;
    this.discussionsBoardService.addBoardTopic(event.data).subscribe({
      next: () => this.toastr.success("Board topic added"),
      error: err => this.toastr.error(err)
    })
  }

  updateDiscussionTopic(event: any) {
    this.discussionsBoardService.updateBoardTopic(event.data).subscribe(
      {
        next: () => this.toastr.success("Board topic updated"),
        error: err => this.toastr.error(err)
      }
    );
  }

  deleteDiscussionTopic(event: any) {
    console.log(event);
    this.discussionsBoardService.deleteBoardTopic(event.data.id).subscribe(
      {
        next: () => this.toastr.success("Board topic deleted"),
        error: err => this.toastr.error(err)
      }
    )
  }
}
