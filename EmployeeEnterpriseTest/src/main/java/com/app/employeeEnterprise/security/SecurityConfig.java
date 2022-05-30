package com.app.employeeEnterprise.security;

import com.app.employeeEnterprise.filter.CutomAuthenticationFilter;
import com.app.employeeEnterprise.filter.CutomAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
<<<<<<< HEAD
        log.info("AuthenticationManagerBuilder needs userDetailsService {} and bCryptPasswordEncoder {}",userDetailsService, bCryptPasswordEncoder );
=======
//        log.info("AuthenticationManagerBuilder needs userDetailsService {} and bCryptPasswordEncoder {}",userDetailsService, bCryptPasswordEncoder );
>>>>>>> 6afa36ac9f5b46aced61fae15cf841e45e0421cf
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     * Configure this method so we can allocate a JWT to the user
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**A way to customise the login url **/
        CutomAuthenticationFilter cutomAuthenticationFilter = new CutomAuthenticationFilter(authenticationManagerBean());
        cutomAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/api/login/**", "/api/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/employee/**").hasAnyAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/employee/save/**").hasAnyAuthority("ROLE_ADMIN");
        //http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        //http.addFilter(new CutomAuthenticationFilter(authenticationManagerBean()));
        http.addFilter(cutomAuthenticationFilter);
        http.addFilterBefore(new CutomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return  super.authenticationManagerBean();
    }
}
