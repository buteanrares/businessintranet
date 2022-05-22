import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
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

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  handleLogin() {
    this.authenticationService.login({ email: this.username, password: this.password }).subscribe(
      () => this.router.navigate(['/home']));
  }
}
