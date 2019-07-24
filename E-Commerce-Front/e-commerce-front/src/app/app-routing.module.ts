import { NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductDetailsComponent } from './components/product-details/product-details.component';
import {IndexComponent} from './components/index/index.component';


const routes: Routes = [
  {path: '' , component: IndexComponent},
  {path: 'product/:id' , component: ProductDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
