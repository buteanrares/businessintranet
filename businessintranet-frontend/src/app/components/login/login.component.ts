import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from "../../service/authentication/authentication.service";
import { LogInCredentialsModel } from "../../models/login-models/login-credentials-model"
import { Router } from '@angular/router';

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

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  ngOnInit(): void {
  }

  handleLogin() {
    this.authenticationService.login({ email: this.username, password: this.password }).subscribe(
      () => {
        this.router.navigate(['/home'])
      });
  }
}
