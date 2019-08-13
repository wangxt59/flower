package com.flower.common.config;


import com.flower.common.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtFilter  extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    //  预
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("JwtFilter:preHandle........");
        final String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.substring(7); // The part after "Bearer "
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {

                if ("admin".equals(claims.get("roles"))) {//如果是管理员
                    request.setAttribute("admin_claims", claims);
                    request.setAttribute("roles", claims.get("roles"));
                }
                if ("user".equals(claims.get("roles"))) {//如果是用户
                    request.setAttribute("user_claims", claims);
                    request.setAttribute("roles", claims.get("roles"));
                }
//                return true;
            }
        }
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("JwtFilter:postHandle........");
//        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("JwtFilter:afterCompletion........");
//        super.afterCompletion(request, response, handler, ex);
    }
}
