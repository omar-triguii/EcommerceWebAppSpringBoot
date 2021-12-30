import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthServiceService } from '../auth-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {form: any = {
  email: null,
  password: null
};
isSuccessful = false;
isSignUpFailed = false;
errorMessage = '';

constructor(private authService: AuthServiceService) { }

ngOnInit(): void {
}

onSubmit(): void {
  const { email, password } = this.form;

  this.authService.register(email, password).subscribe(
    data => {
      console.log(data);
      this.isSuccessful = true;
      this.isSignUpFailed = false;
    },
    err => {
      this.errorMessage = err.error.message;
      this.isSignUpFailed = true;
    }
  );
}

}
