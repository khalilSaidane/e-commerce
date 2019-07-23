import {Product} from './Product';

export interface Supplier {
  id: number;
  name: string;
  contactName: string;
  city: string;
  state: string;
  zipCode: string;
  country: string;
  phone: number;
  Email: string;
  paymentMethods: string;
  discountType: string;
  typeGoods: string;
  products: Product[];
}
