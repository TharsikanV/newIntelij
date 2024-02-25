package com.finalProject.finalProject.config;

import com.finalProject.finalProject.dto.RequestMeta;
import com.finalProject.finalProject.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

@Component
public class JwtInterceptor extends WebRequestHandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RequestMeta requestMeta;

//    public JwtInterceptor(RequestMeta requestMeta) {
//        super((WebRequestInterceptor) requestMeta);
//        this.requestMeta=requestMeta;
//    }

    public JwtInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }
//    public JwtInterceptor(RequestMeta requestMeta){
//        super(requestMeta);
//        this.requestMeta=requestMeta;
//    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String auth=request.getHeader("authorization");
        //authorization endra namela irukkira Header moolam value edukkirathukku

//        if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup") || request.getRequestURI().contains("products") || request.getRequestURI().contains("product") || request.getRequestURI().contains("createProduct") || request.getRequestURI().contains("brand") || request.getRequestURI().contains("brands"))){
        if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))){
        Claims claims=jwtUtils.verify(auth);
            requestMeta.setUserName(claims.get("name").toString());
            requestMeta.setUserId(Long.valueOf(claims.getIssuer()));
            requestMeta.setUserType(claims.get("type").toString());
            requestMeta.setEmailId(claims.get("emailId").toString());
            //claims la erukkiratha intha dto class kku poduran


        }


        return super.preHandle(request, response, handler);
    }


}
