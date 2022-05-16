import { Component, OnInit } from '@angular/core';
import { event } from 'devextreme/events';

@Component({
  selector: 'app-navigation-menu',
  templateUrl: './navigation-menu.component.html',
  styleUrls: ['./navigation-menu.component.scss']
})
export class NavigationMenuComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

  }

  onSelectTab(e: event) {
    console.log(e);
  }

}
