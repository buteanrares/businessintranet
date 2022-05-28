import { EmployeeBaseModel } from "../employee-models/employee-base-model";
import { BoardTopicBaseModel } from "./topic-base-model";

export class MessageBaseModel {
  id?: number;
  sender?: EmployeeBaseModel;
  content?: string;
  referencedBoardTopic?: BoardTopicBaseModel;
  timeSent?: Date;
  referencedBoardTopicId?: number;
}