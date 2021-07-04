package com.example.springcloudzuul.filter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springcloudzuul.util.JudgeRbacAdmin;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xqr
 * @Date: 2021/6/29 16:26
 */


@Component
public class AuthZuulFilterAdmin extends ZuulFilter {

    /*
     *  filter 类型  前置：pre   后置：post
     */

    @Override
    public String filterType() {
        return "pre";
    }

    /*
     *  filter 执行顺序， 值越小越先
     */

    @Override
    public int filterOrder() {
        return 1;
    }
    /*
     ***************
     *判断请求是否需要过滤
     */

    @Override
    public boolean shouldFilter() {
        //  服务名 PROVIDE-DEPT  需要过滤
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();

        if(request.getRequestURI().contains("provider-xqr/admin/updateUserIdentity")){
            return true;
        }

        return false;
    }

    /*
     *****************
     * 怎么判断过滤
     */

    @Override
    public Object run() throws ZuulException {
        JudgeRbacAdmin judgeRbacAdmin =new JudgeRbacAdmin();
        RequestContext ctx= RequestContext.getCurrentContext();

        HttpServletRequest request=ctx.getRequest();
        String token=request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            token=request.getParameter("token");
        }else{
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@adhkajshd")).build();
            DecodedJWT jwt= jwtVerifier.verify(token);
            int uid=jwt.getClaims().get("id").asInt();
            int rid=jwt.getClaims().get("rid").asInt();

            if(!judgeRbacAdmin.play(uid,rid)){

                ctx.setSendZuulResponse(false);
                ctx.getResponse().setContentType("text/html;charset=UTF-8");
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody("对不起，您没有权限");


            }else {

                return null;
            }
        }

        if(StringUtils.isEmpty(token)){
            //禁止访问  401

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        }else{

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@adhkajshd")).build();
            DecodedJWT jwt= jwtVerifier.verify(token);
            int uid=jwt.getClaims().get("id").asInt();
            int rid=jwt.getClaims().get("rid").asInt();
            if(!judgeRbacAdmin.play(uid,rid)){

                ctx.setSendZuulResponse(false);
                ctx.getResponse().setContentType("text/html;charset=UTF-8");
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody("对不起，您没有权限");

            }
        }

        return null;
    }
}

