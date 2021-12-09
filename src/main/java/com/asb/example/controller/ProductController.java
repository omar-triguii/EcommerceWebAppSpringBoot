package com.asb.example.controller;

import com.asb.example.dto.CourseDto;
import com.asb.example.dto.ProductDto;
import com.asb.example.model.Product;
import com.asb.example.service.CourseService;
import com.asb.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
//adding a product with no dto and with list of its imgaes
    @PostMapping("addproduct")
    public ResponseEntity<String> uploadImage(@RequestParam("files") MultipartFile[] files, @RequestParam("name") String name,
                                              @RequestParam("prix") BigDecimal prix, @RequestParam("Tva") BigDecimal Tva
            , @RequestParam("quantity") Integer quantity
                              ,@RequestParam("categoryType") String categoryType               )
    {
        try {
            this.productService.addproduct2( name, prix, Tva, quantity,files,categoryType);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//get products not using dto
@GetMapping("zbat")
public List<Product> zbat(){
        return productService.getproduct();
}
//get products using dto
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllStudents() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//adding a product with dto format and with no images
    @PostMapping("/product")
    public ResponseEntity<ProductDto> getAllStudents(@RequestBody ProductDto productDto) throws ParseException {
        ProductDto std = productService.addProduct(productDto);
        return new ResponseEntity<>(std, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") Long id,
                                                  @RequestBody  ProductDto productDto) throws ParseException {
        ProductDto prd = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(prd, HttpStatus.CREATED);
    }
    @GetMapping("/product/find/{id}")
    public ResponseEntity<ProductDto> findbyid(@PathVariable(name = "id") Long id) {
        ProductDto product = productService.findbyid(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable(name = "id") Long id) {
        String message = productService.deleteProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("getall")
    public List<Product> getall(){
        return this.productService.getproduct();
    }


}



