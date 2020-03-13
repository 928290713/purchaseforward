package cn.eight.purchaseforward.controller;

import cn.eight.purchaseforward.pojo.Carbean;
import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.service.GoodService;
import cn.eight.purchaseforward.service.serviceImpl.GoodServiceImpl;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet("/qiantai/GoodSvl")
public class GoodSvl extends HttpServlet {
    GoodService service =new GoodServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("main")){
            opMain(request,response);
        }else if (reqType.equals("uploadImg")){
            uploadImg(request,response);
        }else if (reqType.equals("addCar")){
            addCar(request,response);
        }else if (reqType.equals("delgood")){
            delgood(request,response);
        }else if (reqType.equals("cleanCar")){
            cleanCar(request,response);
        }else if (reqType.equals("modCar")){
            modCar(request,response);
        }
    }

    private void modCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] goodids = request.getParameterValues("goodids");
        String[] amounts = request.getParameterValues("amounts");
        Integer[] goodids_int = new Integer[goodids.length];
        Integer[] amounts_int = new Integer[amounts.length];
        for (int i = 0; i < goodids.length; i++) {
            if (amounts[i]==""){
                amounts[i] = "0";
            }
            goodids_int[i] = Integer.valueOf(goodids[i]);
            amounts_int[i] = Integer.valueOf(amounts[i]);
        }
        HttpSession session = request.getSession();
        Carbean carbean = (Carbean) session.getAttribute("car");
        if (carbean == null){
            carbean = new Carbean();
        }
        carbean.modGood(goodids_int,amounts_int);
        session.setAttribute("car",carbean);
        List<Good> goodList = service.findGoodsByCarBean(carbean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    private void cleanCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carbean carbean = (Carbean) session.getAttribute("car");
        if (carbean == null){
            carbean = new Carbean();
        }
        carbean.cleanCar();
        session.setAttribute("car",carbean);
        List<Good> goodList = service.findGoodsByCarBean(carbean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    private void delgood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("goodid"));
        HttpSession session = request.getSession();
        Carbean carbean = (Carbean) session.getAttribute("car");
        if (carbean==null){
            carbean = new Carbean();
        }
        carbean.removeGood(id);
        session.setAttribute("car",carbean);
        //把商品呈现在购物车中
        List<Good> goodList = service.findGoodsByCarBean(carbean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    //往购物车添加商品
    private void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("goodid"));
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60*60*24);
        //把session中的购物车取出来
        Carbean carbean = (Carbean) session.getAttribute("car");
        if (carbean==null){
            carbean = new Carbean();
        }
        carbean.addGood(id);
        session.setAttribute("car",carbean);
        //把商品呈现在购物车中
        List<Good> goodList = service.findGoodsByCarBean(carbean);
        request.setAttribute("car",goodList);
        request.getRequestDispatcher("flow.jsp").forward(request,response);
    }

    private void genericCadData(Carbean carbean){

    }

    //加载商品图片
    private void uploadImg(HttpServletRequest request, HttpServletResponse response) {
        String filename = request.getParameter("filename");
        String path = request.getServletContext().getRealPath("/WEB-INF/upload/"+filename);
        FileInputStream fis = null;
        ServletOutputStream os =null;
        try {
            int len;
            byte[] buff = new byte[1024];
            fis = new FileInputStream(path);
            os = response.getOutputStream();
            while ((len = fis.read(buff))!=-1){
                os.write(buff,0,len);
            }os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //加载主页上的内容
    private void opMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodType = request.getParameter("goodType");
        List<String> GoodTypeList = service.findAllGoodType();
        List<Good> goodListByType = null;
        if (GoodTypeList.size()>0){
            if (goodType==null||goodType.isEmpty()){
                goodType = GoodTypeList.get(0);
            }
            goodListByType = service.findGoodsByType(goodType);
        }
        HttpSession session = request.getSession();
        Carbean carbean = (Carbean) session.getAttribute("car");
        int amounts = 0;
        double balance = 0;
        if (carbean!=null){
            amounts = carbean.getAmounts();
            balance = carbean.getBalance();
        }
        request.setAttribute("amounts",amounts);
        request.setAttribute("balance",balance);
        request.setAttribute("goodTypes",GoodTypeList);
        request.setAttribute("goodList",goodListByType);
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }
}
