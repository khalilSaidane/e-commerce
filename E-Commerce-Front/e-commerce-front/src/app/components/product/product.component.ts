import { Component, OnInit } from '@angular/core';
import {Product} from '../../module/Product';
import {ProductService} from '../../services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product: Product ;
  isMouseIn = false;
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProduct(1).subscribe(p => this.product = p );
  }

  setDiscountStyle() {
     const styles = {
       color: this.product.discount ? 'gray' : '',
      'text-decoration': this.product.discount ? 'line-through' : '',
      'font-size': this.product.discount ? '14px' : ''
    };
     return styles;
  }
}
