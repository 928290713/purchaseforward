package cn.eight.purchaseforward.dao;

import cn.eight.purchaseforward.pojo.User;
import cn.eight.purchaseforward.util.DbPool;
import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private BasicDao dao = new BasicDao();

    public boolean queryUserByUsername(String username){
        ResultSet rs = null;
        boolean result = false;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        String sql ="select count(*) from user where username=? and rule=1";
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,username);
            int count = 0;
            if (rs!=null&&rs.next()){
                count = rs.getInt(1);
            }
            if (count == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return result;
    }

    public boolean insterUser(User user){
        boolean result = false;
        String sql = "insert into user(username,password,rule,email,qq) value (?,?,1,?,?)";
        Connection con = DbPool.getConnection();
        try {
            con.setAutoCommit(false);
            PreparedStatement pst = con.prepareStatement(sql);
            dao.execUpdate(pst,user.getUsername(),user.getPassword(),user.getEmail(),user.getQq());
            con.commit();
             result=true;
             return result;
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return result;
    }

    public boolean queryLoginUser(User user){
        ResultSet rs = null;
        PreparedStatement pst=null;
        Connection con = DbPool.getConnection();
        String sql ="select count(*) from user where username=? and password=? and rule=1";
        try {
            pst = con.prepareStatement(sql);
            rs = dao.execQuery(pst,user.getUsername(),user.getPassword());
            int count = 0;
            if (rs!=null&&rs.next()){
                count = rs.getInt(1);
            }
            if (count == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dao.releaseResource(con,pst,rs);
        }
        return false;
    }
}
