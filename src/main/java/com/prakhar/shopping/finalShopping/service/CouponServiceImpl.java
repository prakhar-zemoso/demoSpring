package com.prakhar.shopping.finalShopping.service;


import com.prakhar.shopping.finalShopping.model.Coupon;
import com.prakhar.shopping.finalShopping.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    CouponRepo couponRepo;



    @Override
    public Coupon getbyId(long id) {
        Optional<Coupon> coupon = couponRepo.findById(id);
        return coupon.orElse(null);
    }

    @Override
    public List<Coupon> getAllCoupons() {

            return couponRepo.findAll();
        }

}
