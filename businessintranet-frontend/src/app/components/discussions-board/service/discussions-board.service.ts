import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { MessageBaseModel } from 'src/app/models/discussion-board-models/message-base-model';
import { BoardTopicBaseModel } from 'src/app/models/discussion-board-models/topic-base-model';

@Injectable({
  providedIn: 'root'
})
export class DiscussionsBoardService {
  selectedTopic$ = new Subject();

  constructor(private http: HttpClient) { }

  public setSelectedTopic(selectedTopic: BoardTopicBaseModel) {
    this.selectedTopic$.next(selectedTopic);
  }

  public getSelectedTopic(): Observable<any> {
    return this.selectedTopic$.asObservable();
  }

  public getAllBoardTopics(): Observable<BoardTopicBaseModel[]> {
    return this.http.get<BoardTopicBaseModel[]>('http://localhost:8080/api/boardtopic/all');
  }

  public getBoardTopicById(boardTopicId: number): Observable<BoardTopicBaseModel> {
    return this.http.get<BoardTopicBaseModel>(`http://localhost:8080/api/boardtopic/find/${boardTopicId}`);
  }

  public addBoardTopic(boardTopic: BoardTopicBaseModel): Observable<BoardTopicBaseModel> {
    return this.http.post<BoardTopicBaseModel>('http://localhost:8080/api/boardtopic/add', boardTopic);
  }

  public updateBoardTopic(boardTopic: BoardTopicBaseModel) {
    return this.http.put<BoardTopicBaseModel>('http://localhost:8080/api/boardtopic/update', boardTopic);
  }

  public deleteBoardTopic(id: number) {
    return this.http.delete(`http://localhost:8080/api/boardtopic/delete/${id}`);
  }

  public getAllBoardMessagesByTopicId(boardTopicId: number): Observable<MessageBaseModel[]> {
    return this.http.get<MessageBaseModel[]>(`http://localhost:8080/api/boardmessage/all/${boardTopicId}`);
  }

  public addBoardMessage(boardMessage: MessageBaseModel): Observable<MessageBaseModel> {
    return this.http.post<MessageBaseModel>('http://localhost:8080/api/boardmessage/add', boardMessage);
  }
}
