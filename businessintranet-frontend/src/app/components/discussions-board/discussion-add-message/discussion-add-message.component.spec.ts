import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscussionAddMessageComponent } from './discussion-add-message.component';

describe('DiscussionAddMessageComponent', () => {
  let component: DiscussionAddMessageComponent;
  let fixture: ComponentFixture<DiscussionAddMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscussionAddMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscussionAddMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
