import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AppComponent} from './app.component';
import {ProductDetailsComponent} from './components/product-details/product-details.component';


const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'product/:id', component: ProductDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
