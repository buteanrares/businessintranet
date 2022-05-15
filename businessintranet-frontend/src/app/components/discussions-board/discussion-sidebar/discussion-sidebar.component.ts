import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-discussion-sidebar',
  templateUrl: './discussion-sidebar.component.html',
  styleUrls: ['./discussion-sidebar.component.scss']
})
export class DiscussionSidebarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    console.log("sidebar");
  }

}
