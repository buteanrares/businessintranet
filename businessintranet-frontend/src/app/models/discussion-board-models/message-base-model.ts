import { EmployeeBaseModel } from "../employee/employee-base-model";
import { TopicBaseModel } from "./topic-base-model";

export class MessageBaseModel {
  sender: EmployeeBaseModel;
  content: string;
  topic: TopicBaseModel;
  timeSent: Date;
}