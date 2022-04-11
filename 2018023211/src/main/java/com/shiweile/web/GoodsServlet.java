package com.shiweile.web;

import com.alibaba.fastjson.JSON;
import com.shiweile.pojo.Goods;
import com.shiweile.pojo.goodsBean;
import com.shiweile.service.GoodsService;
import com.shiweile.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet{
    private GoodsService goodsService=new GoodsServiceImpl();
    /**
     * 查询所有
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Goods> goods = goodsService.selectAll();
        String s = JSON.toJSONString(goods);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);

    }

    /**
     * 添加商品
     */
    public void addGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String s = br.readLine();
        Goods goods = JSON.parseObject(s, Goods.class);
        goodsService.addGoods(goods);
        resp.getWriter().write("success");
    }
    /**
     * 删除
     */
    public void deleteGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        int id = Integer.parseInt(br.readLine());
        goodsService.deleteGoods(id);
        resp.getWriter().write("success");
    }
    /**
     * 修改
     */
    public void updateGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String line = br.readLine();
        Goods goods = JSON.parseObject(line, Goods.class);
        goodsService.updateGoods(goods);
        resp.getWriter().write("success");
    }
    /**
     * 分页
     */
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        goodsBean goodsBean = goodsService.selectByPage(begin, size);
        String s = JSON.toJSONString(goodsBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
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
        Goods goods = JSON.parseObject(s, Goods.class);
        String name = goods.getName();
        String company = goods.getCompany();



        if (name!=null && name.length()>0) {
            goods.setName("%" + name + "%");
        };
        if (company!=null && company.length()>0) {
            goods.setCompany("%" + company + "%");
        };



        goodsBean goodsBean = goodsService.selectByPageAndC(begin, size, goods);
        String s1 = JSON.toJSONString(goodsBean);
        resp.setContentType("text/json;charset=utf-8");

        resp.getWriter().write(s1);
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader br = req.getReader();
        String s = br.readLine();
//        String s = req.getParameter("selectedIds");

        int[] ints = JSON.parseObject(s, int[].class);
        goodsService.deleteByIds(ints);
        resp.getWriter().write("success");


    }
}
