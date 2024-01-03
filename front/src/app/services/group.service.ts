import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HeaderUtils } from './header.utils';
import { Group } from '../interfaces/group.interface';

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  
  /***| ATTRIBUTES |***/
  
  private uri:string =`/api`;
  private url:string =`${ this.uri }/groups`;
  private headers?:HttpHeaders;
  
  
  /***| INIT |***/
  
  constructor( private http:HttpClient ) {
    this.headers = HeaderUtils.getHeaders();
  }
  

  /***| GROUP API |***/

  public get():Observable<Group[]> {
    return this.http.get<Group[]>( this.url );
  }
  public getId(id:string):Observable<Group> {
    return this.http.get<Group>( `${this.url}/${id}` );
  }
  public save(g:string):Observable<any> {
    return this.http.post<Group>( this.url, g, { headers: this.headers } );
  }
  public delete(id: number) {
    return this.http.delete<any>(`${this.url}/${id}`)
  }


  /***| CONTACT GROUP MANAGEMENT |***/

  public addContact(group:string, contacts: string[]):Observable<any> {
    return this.http.post(`${this.url}/${group}/contacts/add`, contacts)
  }

  public removeContact(group:string, contacts:string[]):Observable<any> {
    return this.http.post(`${this.url}/${group}/contacts/remove`, contacts)
  }


}
