import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { TopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';

@Injectable({
  providedIn: 'root'
})
export class DiscussionsBoardService {
  selectedTopic$ = new Subject();

  constructor(private http: HttpClient) { }

  public setSelectedTopic(selectedTopic: TopicBaseModel) {
    this.selectedTopic$.next(selectedTopic);
  }

  public getSelectedTopic(): Observable<any> {
    return this.selectedTopic$.asObservable();
  }

  public getAllBoardTopics(): Observable<TopicBaseModel[]> {
    return this.http.get<TopicBaseModel[]>('http://localhost:8080/api/boardtopic/all');
  }

  public addBoardTopic(boardTopic: TopicBaseModel) {
    return this.http.post<TopicBaseModel>('http://localhost:8080/api/boardtopic/all', boardTopic);
  }

  public updateBoardTopic(boardTopic: TopicBaseModel) {
    return this.http.put<TopicBaseModel>('http://localhost:8080/api/boardtopic/update', boardTopic);
  }

  public deleteBoardTopic(id: number) {
    return this.http.delete(`http://localhost:8080/api/boardtopic/update/${id}`);
  }
}
