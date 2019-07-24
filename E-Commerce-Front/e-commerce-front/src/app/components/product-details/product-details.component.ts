import { Component, OnInit } from '@angular/core';
import {Product} from '../../module/Product';
import {ActivatedRoute} from '@angular/router';
import {Category} from '../../module/Category';
import {OrderDetails} from '../../module/OrderDetails';
import {Supplier} from '../../module/Supplier';
import {ProductService} from '../../services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product: Product;
  // colors and sizes are of type string to avoid additional complexity in back end
  availableColors: string[];
  availableSizes: string[];

  constructor(
    private route: ActivatedRoute,
    private  productService: ProductService
  ) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.productService.getProduct(id).subscribe((p) => {
      this.product = p;
      this.availableColors = p.availableColors.split(',');
      this.availableSizes = p.availableSize.split(',');
    });
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
