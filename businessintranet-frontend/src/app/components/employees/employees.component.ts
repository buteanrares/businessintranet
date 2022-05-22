import { Component, OnInit } from '@angular/core';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeesService } from './service/employees.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {
  employees: EmployeeBaseModel[];

  constructor(private employeeService: EmployeesService) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(
      rsp => this.employees = rsp
    );
  }

}
