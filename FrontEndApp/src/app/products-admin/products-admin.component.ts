import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-products-admin',
  templateUrl: './products-admin.component.html',
  styleUrls: ['./products-admin.component.css']
})
export class ProductsAdminComponent implements OnInit {
  products: Product[] | undefined;
  constructor(private productService: ProductsService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.productService.getEmployeesList().subscribe(data => {
      this.products = data;
    });
  }
/*
  employeeDetails(id: number){
    this.router.navigate(['employee-details', id]);
  }*/
/*
  updateProduct(id: number){
    this.router.navigate(['update-employee', id]);
  }*/

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe( data => {
      console.log(data);
      this.getProducts();
      console.log(id);
      this.router.navigate(['home']);
    })
  }
}
