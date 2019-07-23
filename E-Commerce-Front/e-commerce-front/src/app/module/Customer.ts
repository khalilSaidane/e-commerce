import {Order} from './Order';

export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  address: string;
  city: string;
  state: string;
  zipCode: string;
  country: string;
  phone: number;
  email: string;
  password: string;
  creditCard: string;
  creditCardTypeID: string;
  cardExp: Date;
  billingAddress: string;
  billingCity: string;
  billingRegion: string;
  shippingPostalCode: string;
  shippingCountry: string;
  orders: Order[];
}
