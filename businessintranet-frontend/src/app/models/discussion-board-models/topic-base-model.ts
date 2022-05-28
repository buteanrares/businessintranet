import { MessageBaseModel } from "./message-base-model";

export class BoardTopicBaseModel {
  id: number;
  title: string;
  boardMessages: MessageBaseModel[];
}