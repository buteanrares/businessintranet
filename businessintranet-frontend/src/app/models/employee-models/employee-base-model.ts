export class EmployeeBaseModel {
  id: number;
  firstName: string;
  lastName: string;
  phone: string;
  email: string;
  jobTitle: string;

  getFullName() {
    return this.firstName + " " + this.lastName;
  }
}