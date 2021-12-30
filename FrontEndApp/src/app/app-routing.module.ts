import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { CreateproductComponent } from './createproduct/createproduct.component';
import { LoginComponent } from './login/login.component';
import { AdminDetailsComponent } from './admin-details/admin-details.component';
const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "product", component: ProductsComponent },
  { path: "createproduct", component: CreateproductComponent },
  {path: "login", component: LoginComponent },
  {path: "voir", component: AdminDetailsComponent },
  
  {path: 'update-employee/:id', component: CreateproductComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
