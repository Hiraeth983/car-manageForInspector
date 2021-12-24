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

@WebServlet("/deleteApplicationByOrderId")
public class deleteApplicationByOrderId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String staffId = request.getParameter("staffId");
        String orderId = request.getParameter("orderId");
        ApplicationDaoImpl applicationDao = new ApplicationDaoImpl();
        try {
            Boolean flag = applicationDao.deleteApplicationByOrderId(orderId);
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

