import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../service/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string
  password: string
  errorMessage = 'Invalid credentials.'
  successMessage: string | undefined
  invalidLogin = false
  loginSuccess = false

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  handleLogin() {
    this.authenticationService.login(this.username, this.password).subscribe((result) => {
      this.invalidLogin = false
      this.loginSuccess = true
      this.successMessage = 'Login successful'
      //redirect to main page
    }, () => {
      this.invalidLogin = true
      this.loginSuccess = false
    })
  }

}
