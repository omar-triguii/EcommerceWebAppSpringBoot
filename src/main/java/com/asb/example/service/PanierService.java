package com.asb.example.service;

import com.asb.example.dto.PanierDto;
import com.asb.example.dto.ProductDto;
import com.asb.example.dto.StudentDto;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
@Service
public class PanierService {

    @Resource
    private PanierRepository panierRepository;

    @Resource
    private ProductRepository productRepository;

    @Transactional

    public PanierDto addPanier(PanierDto panierDto) throws ParseException {


        Panier panier = mapDtoToEntity(panierDto);;
        Panier savedPanier = panierRepository.save(panier);
        return mapEntityToDto(savedPanier);
    }

    public List<PanierDto> getAllPaniers() {
        List<PanierDto> panierDtos = new ArrayList<>();
        List<Panier> paniers = panierRepository.findAll();
        paniers.stream().forEach(panier -> {
            PanierDto panierDto = mapEntityToDto(panier);
            panierDtos.add(panierDto);
        });
        return panierDtos;
    }


    public String deletePanier(Long panierID) {

        Optional<Panier> panier = panierRepository.findById(panierID);
        //Remove the related courses from student entity.
        if(panier.isPresent()) {
            panier.get().removeProducts();
            panierRepository.deleteById(panier.get().getPanier_ID());
            return "Student with id: " + panierID + " deleted successfully!";
        }
        return null;
    }

    public String deleteProduct_Panier(Long panierID,Long productID){
        Optional<Panier> panier = panierRepository.findById(panierID);
        Set<Product> products = panier.get().getProducts();
        for (Product product:products){
            if (product.getProduct_ID()==productID){
                panier.get().removeProduct(product);
                break;
            }
        }
       // if(panier.isPresent()) {
         //   panier.get().removeProduct(product.get());
           // product.get().removePanier(panier.get());
          //  panierRepository.deleteById(panier.get().getPanier_ID());
       panierRepository.save(panier.get());
            return "Panier with id: " + panierID + " deleted successfully! the product with id"+ productID;

    }
    public String addProductinPanier(Long panierID,Long productId){
        Optional<Panier> panier = panierRepository.findById(panierID);
      //  Product p=productRepository.findById(product.getProduct_ID());
       // Set<Product> products = panier.get().getProducts();
       // products.add(product);
        Optional<Product> product=productRepository.findById(productId);
        panier.get().addProduct(product.get());
        panier.get().setNbProducts(panier.get().getNbProducts()+1);
        BigDecimal x=panier.get().getTotal().add(product.get().getPrix());
        panier.get().setTotal(x);
        panierRepository.save(panier.get());
        return "product with id " + productId+ " est ajoute en panier avec id"+ panierID;

    }
/*
    @Transactional

    public StudentDto updateStudent(Integer id, StudentDto studentDto) {
        Student std = studentRepository.getOne(id);
        std.getCourses().clear();
        mapDtoToEntity(studentDto, std);
        Student student = studentRepository.save(std);
        return mapEntityToDto(student);
    }


    public String deleteStudent(Integer studentId) {

        Optional<Student> student = studentRepository.findById(studentId);
        //Remove the related courses from student entity.
        if(student.isPresent()) {
            student.get().removeCourses();
            studentRepository.deleteById(student.get().getId());
            return "Student with id: " + studentId + " deleted successfully!";
        }
        return null;
    }

    private void mapDtoToEntity(PanierDto panierDto, Panier panier) {
        panier.setName(panierDto.getName());
        if (null == student.getCourses()) {
            student.setCourses(new HashSet<>());
        }
        studentDto.getCourses().stream().forEach(courseName -> {
            Course course = courseRepository.findByName(courseName);
            if (null == course) {
                course = new Course();
                course.setStudents(new HashSet<>());
            }
            course.setName(courseName);
            student.addCourse(course);
        });
    }
*/
/*
    private PanierDto mapEntityToDto(Panier panier) {
        PanierDto responseDto = new PanierDto();
        responseDto.setPanierName(panier.getPanierName());
        responseDto.setID(panier.getPanier_ID());
        responseDto.setDatePanier(panier.getDatePanier());
        responseDto.setTotal(panier.getTotal());
        responseDto.setNbProducts(panier.getNbProducts());
        responseDto.setProducts(panier.getProducts().stream().map(Product::toString).collect(Collectors.toSet()));
        return responseDto;
    }*/

    @Autowired
    private ModelMapper modelMapper;

    private PanierDto mapEntityToDto(Panier panier) {
        PanierDto panierDto = modelMapper.map(panier, PanierDto.class);
      /*  productDto.setID(product.getProduct_ID());
        productDto.setTVA(product.getTVA());
        productDto.setPrix(product.getPrix());
        productDto.setQuantity(product.getQuantity());
        productDto.setName(product.getName());
        productDto.setDatefondation(product.getDatefondation());
        productDto.setCategory(product.getCategory());
        //productDto.setPaniers(product.getPaniers().);*/
        return panierDto;
    }

    private Panier mapDtoToEntity(PanierDto panierDto) throws ParseException {
        Panier panier = modelMapper.map(panierDto, Panier.class);
        //product.setProduct_ID(productDto.getID());
        /*product.setName(productDto.getName());
        product.setTVA(productDto.getTVA());
        product.setPrix(productDto.getPrix());
        product.setQuantity(productDto.getQuantity());
        product.setDatefondation(productDto.getDatefondation());
        product.setPaniers(product.getPaniers());
        product.setCategory(productDto.getCategory());*/
/*
        if (product.getProduct_ID() != null) {
            Product oldPost = .getPostById(postDto.getId());
            post.setRedditID(oldPost.getRedditID());
            post.setSent(oldPost.isSent());
        }*/
        return panier;
    }

}

