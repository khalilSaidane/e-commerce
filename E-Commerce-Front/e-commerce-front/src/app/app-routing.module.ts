import { NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductDetailsComponent } from './components/product-details/product-details.component';
import {IndexComponent} from './components/index/index.component';
import {ProductListComponent} from './components/product-list/product-list.component';


const routes: Routes = [
  {path: '' , component: IndexComponent},
  {path: 'products/product/:id' , component: ProductDetailsComponent},
  {path: 'products' , component: ProductListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
