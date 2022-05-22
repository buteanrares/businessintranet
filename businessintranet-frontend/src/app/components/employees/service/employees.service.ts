import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointConfig } from 'src/app/configurations/endpoint-config';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  constructor(private http: HttpClient) { }

  getAllEmployees() {
    return this.http.get<EmployeeBaseModel[]>('http://localhost:8080/api/employee/all');
  }
}
