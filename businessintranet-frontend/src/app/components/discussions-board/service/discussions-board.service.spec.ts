import { TestBed } from '@angular/core/testing';

import { DiscussionsBoardService } from './discussions-board.service';

describe('DiscussionsBoardService', () => {
  let service: DiscussionsBoardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiscussionsBoardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
