import {Component, OnInit , Input} from '@angular/core';
import {Product} from '../../module/Product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @Input() product: Product ;
  isMouseIn = false;
  constructor() { }

  ngOnInit() {
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
