import { HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export abstract class HeaderUtils {

    constructor(){}

    public static getHeaders() {
        return new HttpHeaders().set('Content-Type', 'application/json')
    }

}