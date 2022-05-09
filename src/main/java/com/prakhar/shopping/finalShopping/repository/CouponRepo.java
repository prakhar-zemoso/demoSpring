package com.prakhar.shopping.finalShopping.repository;

import com.prakhar.shopping.finalShopping.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
    Coupon findByCode(String code);

}
