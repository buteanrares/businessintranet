import { Component, OnInit } from '@angular/core';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';
import { TopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';

@Component({
  selector: 'app-discussions-board',
  templateUrl: './discussions-board.component.html',
  styleUrls: ['./discussions-board.component.scss']
})
export class DiscussionsBoardComponent implements OnInit {

  messages: MessageBaseModel[] = [
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
    { sender: new EmployeeBaseModel, content: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', topic: new TopicBaseModel, timeSent: new Date() },
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
