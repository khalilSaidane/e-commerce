import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../module/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  productUrl = 'http://localhost:8080/product-management';
  httpOption = {
    headers: new HttpHeaders({'Content-type': 'application/json'})
  };
  constructor(private http: HttpClient) { }
  getProduct(id: number): Observable<any> {
    const url = `${this.productUrl}/${id}`;
    return this.http.get<any>(url);
  }
}
