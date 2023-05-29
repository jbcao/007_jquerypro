package level_ajax_query.controller;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import level_ajax_query.Dao.QueryDao;
        import level_ajax_query.entity.Province;

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
 * @date 27.6.22 6:30 PM
 */
@WebServlet("/QueryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //调用dao,获取province集合
        QueryDao dao= new QueryDao();
        ArrayList<Province> provinces = dao.queryProvinceList();
        String json="{}";
        if(provinces!=null){
            ObjectMapper om = new ObjectMapper();
//            这里转变成json数组了
            json=om.writeValueAsString(provinces);
        }
        out.println(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
