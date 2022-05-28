import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
import { EmployeesService } from '../employees/service/employees.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  loggedInUser: EmployeeModelExtended;

  constructor(private authenticationService: AuthenticationService, private employeesService: EmployeesService) { }

  async ngOnInit(): Promise<void> {
    const loggedInUser$ = await lastValueFrom(this.authenticationService.getLoggedInUser());
    this.loggedInUser = loggedInUser$;

    const manager$ = await lastValueFrom(this.employeesService.getEmployeeById(this.loggedInUser.managerId))
    this.loggedInUser.manager = manager$;
  }

}
