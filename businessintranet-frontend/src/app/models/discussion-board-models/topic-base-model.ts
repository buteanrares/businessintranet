export class TopicBaseModel {
  id: number;
  title: string;
  parent?: TopicBaseModel;
  parentId?: number;
  children: TopicBaseModel[];
}