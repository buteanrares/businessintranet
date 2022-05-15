import { Component, OnInit } from '@angular/core';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';
import { TopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';
import { EmployeeBaseModel } from 'src/app/models/employee/employee-base-model';

@Component({
  selector: 'app-discussions-board',
  templateUrl: './discussions-board.component.html',
  styleUrls: ['./discussions-board.component.scss']
})
export class DiscussionsBoardComponent implements OnInit {

  messages: MessageBaseModel[] = [
    { sender: new EmployeeBaseModel, content: 'content1', topic: new TopicBaseModel, datetime: new Date() },
    { sender: new EmployeeBaseModel, content: 'content2', topic: new TopicBaseModel, datetime: new Date() },
    { sender: new EmployeeBaseModel, content: 'content3', topic: new TopicBaseModel, datetime: new Date() },
    { sender: new EmployeeBaseModel, content: 'content4', topic: new TopicBaseModel, datetime: new Date() }];

  constructor() { }

  ngOnInit(): void {
  }

}
