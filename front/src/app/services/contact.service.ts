import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact, PostContact } from '../interfaces/contact.interface';
import { HeaderUtils } from './header.utils';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  
  /***| ATTRIBUTES |***/
  
  private url:string =`/api/contacts`;
  private headers?:HttpHeaders;
  
  
  /***| INIT |***/
  
  constructor( private http:HttpClient ) {
    this.headers = HeaderUtils.getHeaders();
  }
  

  /***| ACCESSORS |***/

  public get():Observable<Contact[]> {
    return this.http.get<Contact[]>( this.url );
  }
  public getId(id:string):Observable<Contact> {
    return this.http.get<Contact>( `${this.url}/${id}` );
  }
  public save(c:PostContact):Observable<any> {
    return this.http.post<Contact>( this.url, c, { headers: this.headers } );
  }
  public delete(id: number) {
    return this.http.delete<any>(`${this.url}/${id}`)
  }

}
