package com.prakhar.shopping.finalShopping.service;


import com.prakhar.shopping.finalShopping.model.Coupon;

import java.util.List;

public interface CouponService {
    Coupon getbyId(long id);
    List<Coupon> getAllCoupons();

}
