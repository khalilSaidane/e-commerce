import {Category} from './Category';
import {OrderDetails} from './OrderDetails';

export interface Product {
  id: number;
  name: string;
  description: string;
  categories?: Category[];
  quantityPerUnit?: number;
  unitPrice?: number;
  availableSize?: string;
  availableColors?: string;
  size?: string;
  color?: string;
  discount?: number;
  unitWeight?: number;
  unitsInStock?: number;
  unitOnOrder?: number;
  orderDetails?: OrderDetails;
}
