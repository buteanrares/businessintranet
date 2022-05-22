import { Injectable } from "@angular/core";

@Injectable()
export class EndpointConfig {
  endpoints = {
    api: '/api',
    auth: '/auth',
    signin: '/signin',
    signout: '/signout',
    employee: {
      all: '/all',
    }
  }
}