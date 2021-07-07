package com.example.springcloudzuul.filter;


import com.example.springcloudzuul.util.JudgeRbacAdmin;
import com.example.springcloudzuul.util.JudgeToken;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xqr
 * @Date: 2021/7/4 16:53
 */
@Component
public class AuthZuulFilter extends ZuulFilter {
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

    @Override
    public boolean shouldFilter() {
        //  服务名 PROVIDE-DEPT  需要过滤
        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();

        if(request.getRequestURI().contains("provider-xqr/logined")){
            return true;
        }

        return false;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx= RequestContext.getCurrentContext();

        HttpServletRequest request=ctx.getRequest();
        String token=request.getHeader("token");
        if (JudgeToken.judgeToken(token)){
            token=request.getParameter("token");
        }

        if(JudgeToken.judgeToken(token)){
            //禁止访问  401
            ctx.setSendZuulResponse(false);
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setResponseBody("登录失效，请您重新登录");
        }
        return null;
    }
}

