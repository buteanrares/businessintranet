import { EmployeeBaseModel } from "../employee-models/employee-base-model";
import { TopicBaseModel } from "./topic-base-model";

export class MessageBaseModel {
  sender: EmployeeBaseModel;
  content: string;
  topic: TopicBaseModel;
  datetime: Date;
}