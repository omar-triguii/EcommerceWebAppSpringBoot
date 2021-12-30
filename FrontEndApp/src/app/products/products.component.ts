import { Component, OnInit } from '@angular/core';
import { Product } from '../product'
import { ProductsService } from '../products.service'
import { Router } from '@angular/router';
import { Category } from '../category';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

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
  addtopanier(panierId:number,productId:number){
    this.productService.addtopanier(panierId,productId).subscribe( data =>{
      console.log(data);
    }
    )
  }
}
