package com.shiweile.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] urls={"/login.jsp","/register.jsp","/js/","/css/","/imgs/","/element-ui/","/user/register","/user/login","/checkCodeServlet"};
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String s = httpServletRequest.getRequestURL().toString();

        for (String url : urls) {
            if (s.contains(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");

        if (user!=null){
                filterChain.doFilter(servletRequest,servletResponse);

        }else {
            servletRequest.setAttribute("login_msg","您尚未登陆");
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);

        }


    }

    @Override
    public void destroy() {

    }
}
