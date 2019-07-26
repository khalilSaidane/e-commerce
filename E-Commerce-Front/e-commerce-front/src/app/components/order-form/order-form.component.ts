import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../module/Product';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {
  @Input() product: Product;
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
