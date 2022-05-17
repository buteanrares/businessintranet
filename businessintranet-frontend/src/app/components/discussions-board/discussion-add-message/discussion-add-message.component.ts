import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-discussion-add-message',
  templateUrl: './discussion-add-message.component.html',
  styleUrls: ['./discussion-add-message.component.scss']
})
export class DiscussionAddMessageComponent implements OnInit {

  postMessagePlaceholder = "Post a message..."
  messageContent: string;

  constructor() { }

  ngOnInit(): void {
  }

}
