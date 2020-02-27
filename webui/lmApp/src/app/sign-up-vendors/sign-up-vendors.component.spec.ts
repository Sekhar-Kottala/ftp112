import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignUpVendorsComponent } from './sign-up-vendors.component';

describe('SignUpVendorsComponent', () => {
  let component: SignUpVendorsComponent;
  let fixture: ComponentFixture<SignUpVendorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignUpVendorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignUpVendorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
