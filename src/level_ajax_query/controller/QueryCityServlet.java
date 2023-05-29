package level_ajax_query.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import level_ajax_query.Dao.QueryDao;
import level_ajax_query.entity.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 27.6.22 11:53 PM
 */
@WebServlet("/QueryCityServlet")
public class QueryCityServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String json="{}";
        String id= request.getParameter("proid");
        if(id!=null&&!"".equals(id.trim())){
            QueryDao queryDao = new QueryDao();
            ArrayList<City> cities = queryDao.queryCityList(Integer.parseInt(id));
            //
            ObjectMapper om=new ObjectMapper();
            json=om.writeValueAsString(cities);
        }
        out.println(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
