import {Category} from "./category";
export class Product {
    id!: number;
    quantity: number | undefined;
    name: string | undefined;
    prix: number | undefined 
    tva:number | undefined
    datefondation:Date | undefined
    categoryId!: number;
   
}
