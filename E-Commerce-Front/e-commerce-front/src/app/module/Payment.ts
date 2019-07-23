import {Order} from './Order';

export class Payment {
  id: number;
  paymentType: string;
  isAllowed: number;
  order: Order;
}
