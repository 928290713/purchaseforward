package cn.eight.purchaseforward.dao;

import cn.eight.purchaseforward.pojo.Carbean;
import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GoodDao {
    private BasicDao dao = new BasicDao();

    public List<String> queryGoodType(){
        String sql = "SELECT DISTINCT goodtype from good ORDER BY goodtype";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst);
            List<String> goodTypeList = new ArrayList<>();
            while(rs!=null&&rs.next()){
                goodTypeList.add(rs.getString(1));
            }
            return goodTypeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return null;
    }

    public List<Good> queryGoodsByType(String type){
        String sql = "SELECT * from good WHERE goodtype =? ORDER BY id LIMIT ?,?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,type,0,20);
            List<Good> goodList = new ArrayList<>();
            while(rs!=null&&rs.next()){
                Good goodBean = new Good();
                goodBean.setId(rs.getInt(1));
                goodBean.setGoodname(rs.getString(2));
                goodBean.setGoodtype(rs.getString(3));
                goodBean.setPrice(rs.getDouble(4));
                goodBean.setPic(rs.getString(5));
                goodList.add(goodBean);
            }
            return goodList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return null;
    }

    public List<Good> findGoodsByCarBean(Carbean carbean){
        List<Good> goodList = new ArrayList<>();
        Map<Integer,Integer> car = carbean.getCar();
        StringBuffer ids = new StringBuffer();
        for (Map.Entry<Integer,Integer> entry:car.entrySet()) {//entry,遍历集合的方法
            Integer id = entry.getKey();
            ids.append(id.toString()).append(",");
        }
        String idstr = ids.toString();
        if (!idstr.isEmpty()){//去掉最后的逗号
            idstr = idstr.substring(0,idstr.length()-1);//需要赋值
        }else {
            return goodList;
        }
        String sql = "select * from good where id in (" +idstr+ ")";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,null);
            while (rs!=null&&rs.next()){
                Good good = new Good();
                good.setId(rs.getInt(1));
                good.setGoodname(rs.getString(2));
                good.setPrice(rs.getDouble(4));
                good.setAmount(car.get(rs.getInt(1)));
                goodList.add(good);
            }
            return goodList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return goodList;
    }


}
