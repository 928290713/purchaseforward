package cn.eight.purchaseforward.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//项目中对数据库的操作分为两大类，这个类用来实现公共部分
public class BasicDao {

    //公共的查询
    public ResultSet execQuery(PreparedStatement pst,Object...params) throws SQLException {
        ResultSet rs = null;
            if (params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs = pst.executeQuery();
        return rs;
    }

    //公共的修改部分
    public void execUpdate(PreparedStatement pst,Object...params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
        }
            pst.executeUpdate();
    }

    //公共的释放资源的方法
    public void releaseResource(Connection con , PreparedStatement pst , ResultSet rs){
        try {
            if (rs !=null){
                rs.close();
            }
            if (pst!=null){
                pst.close();
            }
            if (con!= null){
                con.close();
                con = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        Connection con = new DbPool().getConnection();
        String sql = "insert user(username,password,rule,email,QQ) value(?,?,?,?,?)";
        BasicDao dao = new BasicDao();
        try{
            PreparedStatement pst = con.prepareStatement(sql);
            dao.execUpdate(con,pst,"admin","123456",0,null,null);
            dao.releaseResource(con,pst,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
