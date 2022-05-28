import { Component, OnInit, ViewChild } from '@angular/core';
import { DxDataGridComponent } from 'devextreme-angular';
import { EmployeeBaseModel } from 'src/app/models/employee-models/employee-base-model';
import { EmployeeModelExtended } from 'src/app/models/employee-models/employee-model-extended';
import { EnumRole } from '../../models/role-models/enum-roles';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';
import { EmployeesService } from './service/employees.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {
  @ViewChild('employeesDataGrid', { static: false }) dataGrid: DxDataGridComponent;
  employees: EmployeeBaseModel[];
  loggedInUser: EmployeeModelExtended;

  constructor(private authenticationService: AuthenticationService, private toastr: ToastrService, private employeeService: EmployeesService) { }

  ngOnInit(): void {
    this.authenticationService.getLoggedInUser().subscribe(
      rsp => {
        this.loggedInUser = rsp;
      }
    )
    this.employeeService.getAllEmployees().subscribe(
      rsp => this.employees = rsp
    );
  }

  addEmployee(event: any) {
    delete event.data.__KEY__; // Added for unknown reasons (ts things)
    event.data.roles = event.data.roles.split(', ');
    this.employeeService.addEmployee(event.data).subscribe(
      {
        next: () => this.toastr.success("Employee added"),
        error: err => this.toastr.error(err.message)
      }
    )
  }

  updateEmployee(event: { data: EmployeeModelExtended }) {
    this.employeeService.updateEmployee(event.data).subscribe(
      {
        next: () => this.toastr.success("Employee updated"),
        error: err => this.toastr.error(err.message)
      }
    );
  }

  deleteEmployee(event: { data: EmployeeModelExtended }) {
    if (this.loggedInUser.id === event.data.id) {
      this.toastr.error("Cannot delete self");
      return;
    }
    this.employeeService.deleteEmployee(event.data.id).subscribe(
      {
        next: () => this.toastr.success("Employee deleted"),
        error: err => this.toastr.error(err.message)
      }
    )
  }

  //Unused: Adding employee popup doesnt have rowdata.roles, so cannot map TODO: fix
  calculateRolesCell(rowData: any) {
    return rowData.roles.map((role: string) => " " + role.substring(5)); // Removes 'ROLE_' from roles. Adds space to format comma
  }


  hasPermissionToEditRows() {
    return this.loggedInUser.roles.some(role => [EnumRole.ROLE_CEO, EnumRole.ROLE_HRMANAGER].includes(role));
  }
}
