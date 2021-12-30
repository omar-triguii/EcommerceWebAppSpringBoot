import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { textChangeRangeIsUnchanged } from 'typescript';
import { Category } from '../category';
import { Product } from '../product';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css']
})
export class CreateproductComponent implements OnInit {
  
  product: Product = new Product();

  constructor(private productService: ProductsService,
    private router: Router) { }

  ngOnInit(): void {
  }
  display = "none";
 
openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }
  saveproduct(){
    this.productService.createEmployee(this.product).subscribe( data =>{
      console.log(data);
      //this.goToEmployeeList();
    },
    error => console.log(error));
  }

  /*goToEmployeeList(){
    this.router.navigate(['/hoe']);
  }*/
  
  onSubmit(){
    console.log(this.product);
    this.saveproduct();
  }
}
