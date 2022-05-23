import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { lastValueFrom } from 'rxjs';
import { map, tap } from "rxjs/operators";
import { BehaviorSubject, Observable } from 'rxjs';
import { LogInCredentialsModel } from '../../models/login-models/login-credentials-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly TOKEN_NAME = 'accessToken';
  private readonly user_id = 'user_id';
  private _isLoggedIn = new BehaviorSubject<boolean>(false);
  isLoggedIn = this._isLoggedIn.asObservable();
  private loggedInUserId: number;

  constructor(private http: HttpClient) {
    this._isLoggedIn.next(!!this.token);
  }

  login(credentials: LogInCredentialsModel) {
    return this.http.post('http://localhost:8080/api/auth/signin', credentials).pipe(
      tap((response: any) => {
        localStorage.setItem(this.user_id, response.id);
        localStorage.setItem(this.TOKEN_NAME, response.accessToken);
        this._isLoggedIn.next(true);
      })
    );
  }

  get token() {
    return localStorage.getItem(this.TOKEN_NAME);
  }

  getLoggedInUser(): Observable<EmployeeModelExtended> {
    return this.http.get<EmployeeModelExtended>(`http://localhost:8080/api/employee/find/${localStorage.getItem(this.user_id)}`);
  }
}
