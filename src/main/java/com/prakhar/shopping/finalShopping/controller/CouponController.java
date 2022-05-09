package com.prakhar.shopping.finalShopping.controller;

import com.prakhar.shopping.finalShopping.model.Coupon;
import com.prakhar.shopping.finalShopping.repository.CouponRepo;
import com.prakhar.shopping.finalShopping.service.CouponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@EnableAutoConfiguration
@Controller
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CouponService couponService;

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon(){
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon){
        couponRepo.save(coupon);
        return ("createResonse");
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon(Model model){
        model.addAttribute("result",couponService.getAllCoupons());
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code){
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(couponRepo.findByCode(code));
        return mav;
    }







}
