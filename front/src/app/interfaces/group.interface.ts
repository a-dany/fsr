import { Contact } from "./contact.interface";

export interface Group {
    idGroup: number, 
    name: string, 
    contacts: Contact[]
}