import { Address } from "./address.interface";
import { PhoneNumber, PostPhoneNumber } from "./phone-number.interface";

export interface Contact {
    idContact:number,
    firstName:string,
    lastName:string,
    email:string,
    address: Address,
    phoneNumbers:PhoneNumber[]
}
export interface PostContact {
    firstName:string,
    lastName:string,
    email:string,
    address: Address,
    phoneNumbers:PostPhoneNumber[]
}