import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment }
from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) {}

  login(data: any) {

    return this.http.post(
      `${environment.apiUrl}/auth/login`,
      data,
      {
        withCredentials: true
      }
    );
  }

  logout() {

    return this.http.post(
      `${environment.apiUrl}/auth/logout`,
      {},
      {
        withCredentials: true
      }
    );
  }

  me() {

    return this.http.get(
      `${environment.apiUrl}/auth/me`,
      {
        withCredentials: true
      }
    );
  }
}