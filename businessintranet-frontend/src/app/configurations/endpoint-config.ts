import { Injectable } from "@angular/core";

@Injectable()
export class EndpointConfig {
  private readonly baseUrl = 'http://localhost:8080';
  private readonly endpoints = {
    api: '/api',
    auth: '/auth',
    login: '/signin',
    register: '/signup',
    employees: {
      employees: '/employees',
      getAllEmployees: '/all',
      getEmployeeById: '/find/',
      updateEmployee: '/update',
      deleteEmployee: '/delete/',
    }
  }
}