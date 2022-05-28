import { EnumRole } from "../role-models/enum-roles";
import { EmployeeBaseModel } from "./employee-base-model";

export class EmployeeModelExtended extends EmployeeBaseModel {
  password: string;
  imageUrl: string;
  department: string;
  emailGroups: string[];
  manager: EmployeeBaseModel;
  managerId: number;
  roles: EnumRole[];
}