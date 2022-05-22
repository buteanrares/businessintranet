import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { routerConfig } from './configurations/router-config';
import { AuthenticationService } from './service/authentication/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'businessintranet-frontend';

  constructor(public authenticationService: AuthenticationService) { }

}
