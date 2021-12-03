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
import java.sql.PreparedStatement;
import java.util.ArrayList;

@WebServlet(name = "staffupdateServlet",
        urlPatterns = {"/staffupdateServlet.action"})
public class updateServlet extends HttpServlet{
    private String userName;
    private String passWord;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");  //设置格式编码
        request.setCharacterEncoding("UTF-8");            //设置格式编码
        userName = request.getParameter("root");     //接收表单传过来的用户账号
        passWord = request.getParameter("wjx200008253718");  //用户密码
        staffinfoDao dao = new staffinfoImpl();
        try {
            dao.update();
        } catch (staffinfoImpl.DaoException e) {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
