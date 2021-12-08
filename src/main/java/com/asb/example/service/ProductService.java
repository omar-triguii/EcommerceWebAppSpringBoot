

package com.asb.example.service;

import com.asb.example.dto.CourseDto;
import com.asb.example.dto.ProductDto;
import com.asb.example.model.Course;
import com.asb.example.model.Panier;
import com.asb.example.model.Product;
import com.asb.example.model.Student;
import com.asb.example.repo.CourseRepository;
import com.asb.example.repo.PanierRepository;
import com.asb.example.repo.ProductRepository;
import com.asb.example.repo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.LongToIntFunction;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Resource
    private PanierRepository panierRepository;

    @Resource

    private ProductRepository productRepository;

    @Transactional

    public ProductDto addProduct(ProductDto productDto) throws ParseException {


        Product product = mapDtoToEntity(productDto);;
        Product savedProduct = productRepository.save(product);
        return mapEntityToDto(savedProduct);
    }


    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.stream().forEach(product -> {
            ProductDto productDto = mapEntityToDto(product);
            productDtos.add(productDto);
        });
        return productDtos;
    }

    @Transactional

    public ProductDto updateProduct(Long id, ProductDto productDto) throws ParseException {
        Product prd = productRepository.getOne(id);
        prd.getPaniers().clear();
        Product prd1=mapDtoToEntity(productDto);
        prd.setName(prd1.getName());
        Product product = productRepository.save(prd);
        return mapEntityToDto(product);
    }
    public ProductDto findbyid(Long id){
        Product prd = productRepository.getOne(id);
        ProductDto productDto = mapEntityToDto(prd);
        return  productDto;
    }


    @Transactional

    public String deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        // Remove the related students from course entity.
        if(product.isPresent()) {
            product.get().removePaniers();
            productRepository.deleteById(product.get().getProduct_ID());
            return "Course with id: " + id + " deleted successfully!";
        }
        return null;
    }

/*
    private void mapDtoToEntity(ProductDto productDto, Product product) {
        product.setName(productDto.getName());
        if (null == product.getPaniers()) {
            product.setPaniers(new HashSet<>());
        }
        productDto.getPaniers().stream().forEach(panierName -> {
            Panier panier = panierRepository.findByName(panierName);
            if (null == panier) {
                panier = (new Panier());
                panier.setProducts(new HashSet<>());
            }
           // panier.setPanier_ID(id);
            panier.setPanierName(panierName);
            panier.addProduct(product);
        });
    }*/
/*
    private ProductDto mapEntityToDto(Product product) {
        ProductDto responseDto = new ProductDto();
        responseDto.setName(product.getName());
        responseDto.setID(product.getProduct_ID());
        responseDto.setDatefondation(product.getDatefondation());
        responseDto.setPrix(product.getPrix());
        responseDto.setQuantity(product.getQuantity());
        responseDto.setTVA(product.getTVA());
        responseDto.setPaniers(product.getPaniers().stream().map(Panier::toString).collect(Collectors.toSet()));
        return responseDto;
    }*/

    @Autowired
    private ModelMapper modelMapper;

    private ProductDto mapEntityToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        productDto.setID(product.getProduct_ID());
        productDto.setTVA(product.getTVA());
        productDto.setPrix(product.getPrix());
        productDto.setQuantity(product.getQuantity());
        productDto.setName(product.getName());
        productDto.setDatefondation(product.getDatefondation());
        productDto.setCategory(product.getCategory());
        //productDto.setPaniers(product.getPaniers().);
        return productDto;
    }
public List<Product> getproduct(){
        return this.productRepository.findAll();
}


    private Product mapDtoToEntity(ProductDto productDto) throws ParseException {
        Product product = modelMapper.map(productDto, Product.class);
        //product.setProduct_ID(productDto.getID());
        product.setName(productDto.getName());
        product.setTVA(productDto.getTVA());
        product.setPrix(productDto.getPrix());
        product.setQuantity(productDto.getQuantity());
        product.setDatefondation(productDto.getDatefondation());
        product.setPaniers(product.getPaniers());
        product.setCategory(productDto.getCategory());
/*
        if (product.getProduct_ID() != null) {
            Product oldPost = .getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.isSent());
        }*/
        return product;
    }
}


