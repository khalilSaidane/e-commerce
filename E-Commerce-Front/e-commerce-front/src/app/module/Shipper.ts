import {Order} from './Order';

export interface Shipper {
  id: number;
  companyName: string;
  phone: string;
  order: Order;
}
