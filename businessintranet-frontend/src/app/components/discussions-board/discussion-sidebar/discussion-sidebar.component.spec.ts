import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscussionSidebarComponent } from './discussion-sidebar.component';

describe('DiscussionSidebarComponent', () => {
  let component: DiscussionSidebarComponent;
  let fixture: ComponentFixture<DiscussionSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscussionSidebarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscussionSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
