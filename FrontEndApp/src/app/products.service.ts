import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Product } from './product';
import { TypeVariable } from 'typescript';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private baseURL = "http://localhost:8081/products";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.baseURL}`);
  }

  createEmployee(product: Product): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, product);}

/*
  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }*/

  updateProduct(id: number, product: Product): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, product);
  }

  deleteProduct(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
  addtopanier(panierId:number,productId:number)
  {
    return this.httpClient.get(`${this.baseURL}/${panierId}/${productId}`)
  }

}
