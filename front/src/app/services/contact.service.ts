import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from '../interfaces/contact.interface';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  
  private url='http://localhost:8082/api/contacts';
  constructor( 
    private http:HttpClient 
  ) {}


  public get():Observable<Contact[]> {
    return this.http.get<Contact[]>(this.url);
  }
  public getId(id:string):Observable<Contact> {
    return this.http.get<Contact>(`${this.url}/${id}`)
  }
  public save(c: Contact):Observable<any> {
    return this.http.post<Contact>( this.url, {} )
  }


}
