package com.itheima.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;

        String[] urls={"/login.jsp","/loginServlet","/register.jsp","/RegisterServlet","/css/","/imgs/","/checkCodeServlet","/register.html","/01-ajax-demo1.html"};
        String url = req.getRequestURL().toString();
        for (String s : urls) {
            if (url.contains(s)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }


        HttpSession session = req.getSession();
        Object user = session.getAttribute("User");

        if (user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            req.setAttribute("login_msg","请先登录");
            req.getRequestDispatcher("/login.jsp").forward(req,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
