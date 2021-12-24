package demo;

import com.alibaba.fastjson.JSON;
import implement.ApplicationDaoImpl;
import implement.RecordDaoImpl;
import model.Application;
import model.Record;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/applyTaskScheduling")
public class applyTaskScheduling extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderId");
        String reason = request.getParameter("reason");
        String stationId = request.getParameter("stationId");
        String oStaffId = request.getParameter("oStaffId");
        String nStaffId = request.getParameter("nStaffId");
        String submitTime = request.getParameter("submitTime");
        RecordDaoImpl rdi = new RecordDaoImpl();
        ApplicationDaoImpl adi = new ApplicationDaoImpl();
        try {
            Application application = new Application(orderId, submitTime, oStaffId, "", nStaffId, "", reason, "");
            Boolean flag = adi.insertApplication(application);

            if (flag) {
                ArrayList<Record> list = rdi.getRecordList(stationId, oStaffId);
                if (!list.isEmpty()) {
                    response.getWriter().print(JSONArray.fromObject(list));
                } else {
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


