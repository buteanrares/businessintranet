import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, tap } from "rxjs/operators";
import { BehaviorSubject } from 'rxjs';
import { LogInCredentialsModel } from '../../models/login-models/login-credentials-model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly TOKEN_NAME = 'accessToken';
  private _isLoggedIn = new BehaviorSubject<boolean>(false);
  isLoggedIn = this._isLoggedIn.asObservable();

  constructor(private http: HttpClient) {
    this._isLoggedIn.next(!!this.token);
  }

  login(credentials: LogInCredentialsModel) {
    return this.http.post('http://localhost:8080/api/auth/signin', credentials).pipe(
      tap((response: any) => {
        localStorage.setItem(this.TOKEN_NAME, response.accessToken);
        this._isLoggedIn.next(true);
      })
    );
  }

  get token() {
    return localStorage.getItem(this.TOKEN_NAME);
  }
}
