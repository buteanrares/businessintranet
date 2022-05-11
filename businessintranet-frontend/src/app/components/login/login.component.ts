import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from "../../service/authentication.service";
import { LogInCredentialsModel } from "../../models/login-models/login-credentials-model"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string = ""
  password: string = ""
  errorMessage = 'Invalid credentials.'
  successMessage: string | undefined
  invalidLogin = false
  loginSuccess = false

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  handleLogin() {
    this.authenticationService.login({ username: this.username, password: this.password }).subscribe(
      {
        next: () => { console.log("next") },        // nextHandler
        error: () => { console.log("error") },       // errorHandler
        complete: () => { console.log("complete") },    // completeHandler
      });
  }
}
