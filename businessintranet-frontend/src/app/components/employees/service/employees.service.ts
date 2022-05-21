import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointConfig } from 'src/app/configurations/endpoint-config';
import { EmployeeBaseModel } from 'src/app/models/employee/employee-base-model';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  constructor(private http: HttpClient, private endpointConfig: EndpointConfig) { }

  getAllEmployees() {
    const x = this.http.get<EmployeeBaseModel[]>('http://localhost:8080/api/employee/all');
    return x;
  }
}
