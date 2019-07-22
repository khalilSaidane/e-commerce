import {Product} from './Product';
import {Order} from './Order';

export interface OrderDetails {
  id: number;
  products: Product[];
  order: Order;
  price: number;
  quantity: number;
  discount: number;
  total: number;
  size: number;
  color: string;
  isFulfilled: number;
  shipDate: Date;
  billDate: Date;
}
