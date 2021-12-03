package demo;

import dao.staffinfoDao;
import implement.staffinfoImpl;
import model.staffinfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "staffinfoServlet",
        urlPatterns = {"/staffinfoServlet.action"})
public class staffinfoServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setCharacterEncoding("UTF-8");
        staffinfoDao dao = new staffinfoImpl();
        ArrayList<staffinfo> staffinfolist;
        try {
            staffinfolist = (ArrayList<staffinfo>) dao.search();
            //2.将list存入request域
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", staffinfolist.size());
            JSONArray result = null;
            result = JSONArray.fromObject(staffinfolist);
            jsonObject.put("data", result);
            response.getWriter().print(jsonObject);
            //request.setAttribute("stationlist",Stationlist);
        } catch (staffinfoImpl.DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
