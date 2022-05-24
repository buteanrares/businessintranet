import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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

  addEmployee(employee: EmployeeModelExtended) {
    return this.http.post<EmployeeModelExtended>('http://localhost:8080/api/employee/add', employee);
  }

  updateEmployee(newEmployee: EmployeeModelExtended): Observable<EmployeeModelExtended> {
    return this.http.put<EmployeeModelExtended>('http://localhost:8080/api/employee/update', newEmployee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/employee/update/${id}`);
  }
}
