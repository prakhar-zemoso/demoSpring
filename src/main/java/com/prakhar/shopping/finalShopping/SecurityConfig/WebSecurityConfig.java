package com.prakhar.shopping.finalShopping.SecurityConfig;

import com.prakhar.shopping.finalShopping.security.UserDetailsSecurityimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsSecurityimpl userDetailsSecurityimpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsSecurityimpl);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/couponapi/coupons/","/index",
                        "/showNewProductForm","/saveProduct","/showFormForUpdate/{id}",
                        "/deleteProduct/{id}", "/getCoupon" ,"/showGetCoupon",
                        "/couponDetails","/index2").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET,"/showCreateCoupon","/createCoupon","/createResponse").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/getCoupon","/index","/index2","/showNewProductForm",
                                "/saveProduct","/showFormForUpdate/{id}","/deleteProduct/{id}").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST,"/couponapi/coupons","/createResonse","/saveCoupon").hasRole("ADMIN").
                 antMatchers("/","/login","/showReg","/registration").
                permitAll().anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).clearAuthentication(true).invalidateHttpSession(false);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
