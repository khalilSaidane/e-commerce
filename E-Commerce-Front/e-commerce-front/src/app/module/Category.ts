import {Product} from './Product';

export interface Category {
  id: number;
  description: string;
  pictureUrl: string;
  isActive: number;
  products: Product[];
}
