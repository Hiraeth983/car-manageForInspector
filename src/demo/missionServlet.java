package demo;

import dao.missionDao;
import implement.missionImpl;
import model.mission;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "missionServlet",
        urlPatterns = {"/missionServlet.action"})
public class missionServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setCharacterEncoding("UTF-8");
        missionDao dao = new missionImpl();
        ArrayList<mission> missionlist;
        try {
            missionlist = dao.search();
            //2.将list存入request域
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", missionlist.size());
            JSONArray result = null;
            result = JSONArray.fromObject(missionlist);
            jsonObject.put("data", result);
            response.getWriter().print(jsonObject);
            //request.setAttribute("stationlist",Stationlist);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
