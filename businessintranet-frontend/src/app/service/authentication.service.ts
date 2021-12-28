import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {map} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    public username: string
    public password: string

    constructor(private httpClient: HttpClient) {
    }

    login(username: string, password: string) {
        return this.httpClient.post(environment.hostUrl + `/authenticate`,
            {headers: {authorization: this.createBasicAuthToken(username, password)}}).pipe(map((res) => {
            this.username = username;
            this.password = password;
            this.registerSuccessfulLogin(username, password);
        }));
    }

    createBasicAuthToken(username: string, password:string){
        return 'Basic ' +window.btoa(username+":"+password);
    }

    registerSuccessfulLogin(username: string, password:string){
        // TODO: save username to session
    }
}
