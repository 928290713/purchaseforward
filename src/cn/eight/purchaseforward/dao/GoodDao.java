package cn.eight.purchaseforward.dao;

import cn.eight.purchaseforward.pojo.Good;
import cn.eight.purchaseforward.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    private BasicDao dao = new BasicDao();
    public boolean insertGood(Good good){
        boolean result = false;
        String sql = "insert into good(goodname,goodtype,price,pic) VALUES(?,?,?,?)";
        PreparedStatement pst = null;
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,good.getGoodname(),good.getGoodtype(),good.getPrice(),good.getPic());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,null);
        }
        return result;
    }

    public boolean updateGood(Good good){
        boolean result = false;
        String sql = "update good set goodname=?,goodtype=?,price=? where id=?";
        PreparedStatement pst = null;
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,good.getGoodname(),good.getGoodtype(),good.getPrice(),good.getId());
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,null);
        }
        return result;
    }

    public boolean deleteGood(int id){
        boolean result = false;
        String sql = "delete from good where id=?";
        PreparedStatement pst = null;
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            pst = con.prepareStatement(sql);
            dao.execUpdate(pst,id);
            con.commit();
            result = true;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,null);
        }
        return result;
    }

    public List<Good> queryGoodByCriteria(Good good){
        String sql = "select id,goodname,goodtype,price from good";
        String criteria = "";
        //针对是否填写了条件值分别进行处理，构造查询条件的串
        if(good.getId()!=-1){//有具体的数字
            criteria = "id="+good.getId();
        }
        if(!good.getGoodname().trim().isEmpty()){
            if(criteria.isEmpty()){
                criteria+=" goodname like '%"+good.getGoodname()+"%'";
            }else{
                criteria+=" and goodname like '%"+good.getGoodname()+"%'";
            }
        }
        if(!good.getGoodtype().trim().isEmpty()){
            if(criteria.isEmpty()){
                criteria+=" goodtype like '%"+good.getGoodtype()+"%'";
            }else{
                criteria+=" and goodtype like '%"+good.getGoodtype()+"%'";
            }
        }
        //生成完整的sql
        if(!criteria.isEmpty()){
            sql+=" where "+criteria;
        }
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, null);
            List<Good> goodList = new ArrayList<>();
            while(rs!=null&&rs.next()){
                Good goodBean = new Good();
                goodBean.setId(rs.getInt(1));
                goodBean.setGoodname(rs.getString(2));
                goodBean.setGoodtype(rs.getString(3));
                goodBean.setPrice(rs.getDouble(4));
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

    public List<Good> queryGoodAll(int pageNow,int pageSize){
        String sql = "select * from good order by id LIMIT ? ,?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, (pageNow-1)*pageSize,pageSize);
            List<Good> goodList = new ArrayList<>();
            while(rs!=null&&rs.next()){
                Good goodBean = new Good();
                goodBean.setId(rs.getInt(1));
                goodBean.setGoodname(rs.getString(2));
                goodBean.setGoodtype(rs.getString(3));
                goodBean.setPrice(rs.getDouble(4));
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

    public int queryTotalRecord(){
        int result = 0;
        String sql = "select count(*) from good";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DbPool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst, null);
            if(rs!=null&&rs.next()){
                result = rs.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return 0;
    }


}
