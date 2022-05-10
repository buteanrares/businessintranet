import { Component, OnInit } from '@angular/core';
import { event } from 'devextreme/events';

@Component({
  selector: 'app-navigation-menu',
  templateUrl: './navigation-menu.component.html',
  styleUrls: ['./navigation-menu.component.scss']
})
export class NavigationMenuComponent implements OnInit {

  tabs = ['tab1', 'tab2', 'tab3', 'tab4']

  constructor() { }

  ngOnInit(): void {
  }

  onSelectTab(e: event) {
    console.log(e);
  }

  onSelectTab2(item: any): boolean {
    console.log(item);
    return true;
  }

}
