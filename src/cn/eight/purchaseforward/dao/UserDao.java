package cn.eight.purchaseforward.dao;

import cn.eight.purchaseforward.pojo.User;
import cn.eight.purchaseforward.util.DbPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private DbPool dbPool = new DbPool();
    private BasicDao dao = new BasicDao();

    public boolean queryUser(User user){
        ResultSet rs = null;
        boolean result = false;
        PreparedStatement pst=null;
        Connection con = dbPool.getConnection();
        String sql ="select count(*) from user where username=? and password=? and rule=0";
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
        return result;
    }
}
