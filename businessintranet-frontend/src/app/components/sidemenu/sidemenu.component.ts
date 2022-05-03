import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidemenu',
  templateUrl: './sidemenu.component.html',
  styleUrls: ['./sidemenu.component.scss']
})
export class SidemenuComponent implements OnInit {

  users = [1, 2, 3, 4]

  constructor() { }

  ngOnInit(): void {
  }

}
