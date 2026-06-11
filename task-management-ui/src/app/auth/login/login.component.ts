import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
}
from '@angular/forms';
import { AuthService }
from '../../services/auth.service';

import { Router }
from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html'
})
export class LoginComponent {

  loginForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
) {

    this.loginForm =
      this.fb.group({

        email: [
          '',
          [
            Validators.required
          ]
        ],

        password: [
          '',
          [
            Validators.required
          ]
        ]
      });
  }

  login() {
    console.log("hi")
  // if(this.loginForm.invalid) {
  //   return;
  // }

  this.authService
      .login(this.loginForm.value)
      .subscribe({

        next: () => {

          alert('Login Success');

        },

        error: err => {

          console.log(err);

          alert('Invalid Credentials');

        }

      });
}
}