import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscussionsBoardComponent } from './discussions-board.component';

describe('DiscussionsBoardComponent', () => {
  let component: DiscussionsBoardComponent;
  let fixture: ComponentFixture<DiscussionsBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscussionsBoardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscussionsBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
