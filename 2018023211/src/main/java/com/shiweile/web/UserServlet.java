package com.shiweile.web;

import com.alibaba.fastjson.JSON;
import com.shiweile.pojo.Goods;
import com.shiweile.pojo.User;
import com.shiweile.pojo.goodsBean;
import com.shiweile.pojo.userBean;
import com.shiweile.service.UserService;
import com.shiweile.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private UserService userService=new UserServiceImpl();
    /**
     * 判断账号名是否已存在
     */
    public void selectByUsername (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        User user = userService.selectByUsername(username);
        if (user == null){
            //可以注册
            resp.getWriter().write("success");
        }
    }

    /**
     * 注册
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setusername(username);
        user.setpassword(password);
        boolean flag = userService.register(user);
        if (flag){
            req.setAttribute("register_msg","注册成功");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            req.setAttribute("register_msg","用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
    }

    /**
     * 登录
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User login = userService.login(username, password);
        if (login==null){
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            if ("1".equals(remember)){
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                resp.addCookie(c_username);
                resp.addCookie(c_password);

            }
            HttpSession session = req.getSession();
            session.setAttribute("user",login);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/goods.html");

        }
    }
    /**
     * 条件查询后分页
     */
    public void selectByPageAndC(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        User user = JSON.parseObject(s, User.class);
        String name = user.getName();
        String department = user.getDepartment();



        if (name!=null && name.length()>0) {
            user.setName("%" + name + "%");
        };
        if (department!=null && department.length()>0) {
            user.setDepartment("%" + department + "%");
        };



        userBean userBean = userService.selectByPageAndC(begin, size, user);
        String s1 = JSON.toJSONString(userBean);
        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write(s1);
    }

    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        User user = JSON.parseObject(s, User.class);
        userService.addUser(user);
        resp.getWriter().write("success");
    }

    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        User user = JSON.parseObject(s, User.class);
        userService.updateUser(user);
        resp.getWriter().write("success");
    }

    public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        int id = Integer.parseInt(br.readLine());
        userService.deleteUser(id);
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String s = br.readLine();
        int[] ints = JSON.parseObject(s, int[].class);
        userService.deleteByIds(ints);
        resp.getWriter().write("success");
    }
}
