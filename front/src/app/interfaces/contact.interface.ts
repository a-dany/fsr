import { Address } from "./address.interface";
import { PhoneNumber } from "./phone-number.interface";

export interface Contact {
    firstName:string,
    lastName:string,
    address: Address,
    phoneNumbers:PhoneNumber[]
}