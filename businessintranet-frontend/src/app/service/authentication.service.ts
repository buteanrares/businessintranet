import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import { map } from "rxjs/operators";
import { LogInCredentialsModel } from '../models/login-models/login-credentials-model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) {
  }

  login(employeeModel: LogInCredentialsModel) {
    console.log("login with " + employeeModel.username + " " + employeeModel.password);
    return this.httpClient.post(environment.hostUrl + `/authenticate`,
      { headers: { authorization: this.createBasicAuthToken(employeeModel.username, employeeModel.password) } }).pipe(map((res) => {
        this.registerSuccessfulLogin(employeeModel.username, employeeModel.password);
      }));
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  registerSuccessfulLogin(username: string, password: string) {
    // TODO: save username to session
  }
}
