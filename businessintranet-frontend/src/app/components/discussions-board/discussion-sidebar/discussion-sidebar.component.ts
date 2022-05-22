import { Component, OnInit } from '@angular/core';
import { TopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';

@Component({
  selector: 'app-discussion-sidebar',
  templateUrl: './discussion-sidebar.component.html',
  styleUrls: ['./discussion-sidebar.component.scss']
})
export class DiscussionSidebarComponent implements OnInit {

  topics: TopicBaseModel[] = [
    { id: 0, title: 'Timesheets', children: [{ id: 0, title: 'Timetracking' }] },
    { id: 1, title: 'Issues' },
    { id: 2, title: 'Vacations' },
    { id: 3, title: 'placeholder' },
    { id: 4, title: 'placeholder' },
    { id: 5, title: 'placeholder' },
    { id: 6, title: 'placeholder' },
    { id: 7, title: 'placeholder' },
  ];
  selectedTopic: TopicBaseModel;
  constructor() { }

  ngOnInit(): void {
    console.log("sidebar");
  }

}
