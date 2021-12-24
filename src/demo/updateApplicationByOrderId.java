package demo;

import com.alibaba.fastjson.JSON;
import implement.ApplicationDaoImpl;
import model.Application;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/updateApplicationByOrderId")
public class updateApplicationByOrderId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String staffId = request.getParameter("staffId");
        String orderId = request.getParameter("orderId");
        String reason = request.getParameter("reason");
        String nStaffId = request.getParameter("nStaffId");
        String nStaffName = request.getParameter("nStaffName");

        ApplicationDaoImpl applicationDao = new ApplicationDaoImpl();
        try {
            Application application = new Application();
            application.setOrderId(orderId);
            application.setnStaffId(nStaffId);
            application.setnStaffName(nStaffName);
            application.setReason(reason);

            Boolean flag = applicationDao.updateApplicationByOrderId(application);
            if (flag) {
                ArrayList<Application> list = applicationDao.getApplicationListByStaffId(staffId);
                if (!list.isEmpty()){
                    response.getWriter().print(JSONArray.fromObject(list));
                }else{
                    response.getWriter().print(JSON.toJSONString("暂无数据"));
                }
            } else {
                response.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

