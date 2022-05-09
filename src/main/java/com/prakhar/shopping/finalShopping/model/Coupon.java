package com.prakhar.shopping.finalShopping.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    private String expdate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    @Transient
    private Product product;

    public Coupon(String code, BigDecimal discount) {
        this.code = code;
        this.discount = discount;
    }

    public Coupon(Long id, String code, BigDecimal discount, String expdate) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.expdate = expdate;
    }
}

