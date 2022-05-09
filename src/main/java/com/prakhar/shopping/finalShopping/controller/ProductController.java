package com.prakhar.shopping.finalShopping.controller;


import com.prakhar.shopping.finalShopping.model.Product;
import com.prakhar.shopping.finalShopping.repository.CouponRepo;
import com.prakhar.shopping.finalShopping.repository.ProductRepo;
import com.prakhar.shopping.finalShopping.security.SecurityService;
import com.prakhar.shopping.finalShopping.service.CouponServiceImpl;
import com.prakhar.shopping.finalShopping.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
//@RequestMapping(value = "/productapi")
public class ProductController {

    @Autowired
    ProductRepo repo;

    @Autowired
    private CouponServiceImpl couponService;

    @Autowired
    CouponRepo couponRepo;

    @Autowired
    private ProductServiceImpl productService;



    @Autowired
    private SecurityService securityService;

    @GetMapping("/index2")
    public String AdminHomePage(Model model){
        model.addAttribute("listProduct", productService.getAllProduct());
        BigDecimal totalValue = BigDecimal.valueOf(0);
        for(Product p: productService.getAllProduct()) {
            totalValue = totalValue.add(p.getPrice());
        }


        model.addAttribute("totalPrice",totalValue);
        return "index2";

    }

    @PostMapping("/index2")
    public String login(String email, String password){

        boolean loginresponse = securityService.login(email, password);
        if (loginresponse){
            return "redirect:index";
        }
        return "login";
    }


    @GetMapping("/showNewProductForm")
    public String showNewEmployeeForm(Model model){

        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
//
        productService.saveProduct(product);
        return "redirect:/index2";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute(("product"),product);
        return "update_Product";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id){
        productService.deleteProductById(id);
        return "redirect:/index2";
    }

}
