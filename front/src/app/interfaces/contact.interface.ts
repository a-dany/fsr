import { Address } from "./address.interface";
import { PhoneNumber } from "./phone-number.interface";

export interface Contact {
    idContact:number,
    firstName:string,
    lastName:string,
    email:string,
    address: Address,
    phoneNumbers:PhoneNumber[]
}