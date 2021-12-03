package demo;

import dao.staffinfoDao;
import implement.staffinfoImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "staffupdateServlet",
        urlPatterns = {"/staffupdateServlet.action"})
public class updateServlet extends HttpServlet{
    private String userName;
    private String passWord;
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");  //设置格式编码
        try {
            request.setCharacterEncoding("UTF-8");            //设置格式编码
            userName = request.getParameter("root");     //接收表单传过来的用户账号
            passWord = request.getParameter("wjx200008253718");  //用户密码
            staffinfoDao dao = new staffinfoImpl();
            dao.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request,response);
    }
}
