import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import { GstComponent } from './gst.component';
import {HttpClientModule} from '@angular/common/http';

describe('GstComponent', () => {
  let component: GstComponent;
  let fixture: ComponentFixture<GstComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GstComponent ],
      imports: [FormsModule, HttpClientModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GstComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
