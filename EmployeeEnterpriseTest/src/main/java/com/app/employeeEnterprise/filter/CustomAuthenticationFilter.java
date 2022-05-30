package com.app.employeeEnterprise.filter;

import com.app.employeeEnterprise.logging.SL4JLogger;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        SL4JLogger.getLogger().info("AuthenticationManager should be instantiated to {}",authenticationManager.toString());
        String employeeRegistration = request.getParameter("employeeRegistration");
        String password = request.getParameter("password");
        SL4JLogger.getLogger().info("Employee registration {} and its password is {}",employeeRegistration, password);
        SL4JLogger.getLogger().info("Step 1 : creating an authenticationToken");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(employeeRegistration, password);
        SL4JLogger.getLogger().info("Principal in authenticationToken is  : {} and it its authentication status is {}",authenticationToken.getPrincipal(), authenticationToken.isAuthenticated());
        return   authenticationManager.authenticate(authenticationToken);
    }

    /**
     * Also we can override the unseccessful authentication method
     * which will allow to block a user who is trying to brut force access the app
     *
     * The following method is called once the user has successfully logged in, give the user the access token and the refresh token
     * we need to generate a token, sign it then send it over to the user -->
     * We will be using an external library to do this for us which is in : https://mvnrepository.com/artifact/com.auth0/java-jwt
     * Add the maven dependency in the Pom.xml
     *
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User)authResult.getPrincipal(); // principal is the user that has been authenticated
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes()); // do not do this in production
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) //adding 10 min to the current time
                .withIssuer(request.getRequestURL().toString())
                .withClaim("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) //adding 10 min to the current time
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        /*
        response.setHeader("access_token", access_token);
        response.setHeader("refresh_token", refresh_token);
         */
        Map<String, String> token = new HashMap<>();
        token.put("access_token", access_token);
        token.put("refresh_token", refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), token);

    }


}
