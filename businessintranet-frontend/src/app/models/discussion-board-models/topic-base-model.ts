export class TopicBaseModel {
  id: number;
  title: string;
  children?: TopicBaseModel[];
}