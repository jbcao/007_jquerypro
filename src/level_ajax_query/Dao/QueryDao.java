package level_ajax_query.Dao;

import level_ajax_query.entity.City;
import level_ajax_query.entity.Province;

import java.sql.*;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.6.22 2:21 PM
 */
public class QueryDao {
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private String url = "jdbc:mysql://localhost:3306/liangshanhero";
    private String user = "root";
    private String pass = "root";

    //查询所有省份信息
    public ArrayList<Province> queryProvinceList() {
        ArrayList<Province> provinces = new ArrayList<>();
        Province p = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
            sql = "select id,name,jiancheng,shenghui from province order by id";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Province();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setJiancheng(rs.getString("jiancheng"));
                p.setShenghui(rs.getString("shenghui"));
                provinces.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return provinces;
    }

    //    查询所有城市
    public ArrayList<City> queryCityList(Integer id) {
        ArrayList<City> Cities = new ArrayList<>();
        City c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
            sql = "select id,name from city where provinceid = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new City();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                Cities.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Cities;
    }
}
