import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private url='localhost:8082/api/contacts';

  constructor(
    // private http:HttpClient
  ) { }

}
