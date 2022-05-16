import { Component, OnInit, Input } from '@angular/core';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';

@Component({
  selector: 'app-discussion-message',
  templateUrl: './discussion-message.component.html',
  styleUrls: ['./discussion-message.component.scss']
})
export class DiscussionMessageComponent implements OnInit {

  @Input() message: MessageBaseModel;

  constructor() { }

  ngOnInit(): void {
  }

}
