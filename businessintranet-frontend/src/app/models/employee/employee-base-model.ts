export class EmployeeBaseModel {
  id: number;
  firstName: string;
  lastName: string;
  jobTitle: string;
  email: string;
  imageUrl: string;
  department: string;

  getFullName() {
    return this.firstName + " " + this.lastName;
  }
}