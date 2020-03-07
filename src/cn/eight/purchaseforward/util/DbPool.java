package cn.eight.purchaseforward.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
//该类是数据库连接池
public class DbPool{
    private static ComboPooledDataSource ds;

    static {
        ds = new ComboPooledDataSource();
        Properties properties = new Properties();
        try {
            properties.load(DbPool.class.getClassLoader().getResourceAsStream("db.properties"));
            ds.setDriverClass(properties.getProperty("driveName"));
            ds.setUser(properties.getProperty("username"));
            ds.setPassword(properties.getProperty("password"));
            ds.setJdbcUrl(properties.getProperty("url"));
            ds.setInitialPoolSize(Integer.valueOf(properties.getProperty("InitialPoolSize")));
            ds.setMinPoolSize(Integer.valueOf(properties.getProperty("MinPoolSize")));
            ds.setMaxPoolSize(Integer.valueOf(properties.getProperty("MaxPoolSize")));
            ds.setMaxStatements(Integer.valueOf(properties.getProperty("MaxStatements")));
            ds.setMaxIdleTime(Integer.valueOf(properties.getProperty("MaxIdleTime")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
