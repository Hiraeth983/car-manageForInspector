package demo;

import dao.staffinfoDao;
import implement.staffInfoImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "insertStaffInfoServlet",
        urlPatterns = {"/insertStaffInfoServlet.action"})
public class insertServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");  //设置格式编码
            request.setCharacterEncoding("UTF-8");            //设置格式编码
            staffinfoDao dao = new staffInfoImpl();
            String staffid=request.getParameter("number");
            String staffname=request.getParameter("username");
            String stationid=request.getParameter("title");
            Boolean isAble=true;
            dao.insert(staffid,staffname,stationid,isAble);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            public void doGet (HttpServletRequest request, HttpServletResponse response){
                doPost(request, response);
            }
        }
