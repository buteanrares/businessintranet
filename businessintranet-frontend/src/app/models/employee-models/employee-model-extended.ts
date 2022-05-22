import { RoleModel } from "../role-models/role-model";
import { EmployeeBaseModel } from "./employee-base-model";

export class EmployeeModelExtended extends EmployeeBaseModel {
  password: string;
  imageUrl: string;
  department: string;
  emailGroups: string[];
  manager: EmployeeBaseModel;
  roles: RoleModel[];
  permissions: string[];
}