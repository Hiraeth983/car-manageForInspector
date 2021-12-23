package demo;

import com.alibaba.fastjson.JSON;
import implement.ComplaintDaoImpl;
import model.Complaint;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getComplaintListByStaffId")
public class getComplaintListByStaffId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String staffId = request.getParameter("staffId");
        ComplaintDaoImpl complaintDao = new ComplaintDaoImpl();
        try {

            ArrayList<Complaint> complaintList = complaintDao.getComplaintListByStaffId(staffId);
            if (!complaintList.isEmpty() ) {
                response.getWriter().print(JSONArray.fromObject(complaintList));
            } else {
                response.getWriter().print(JSON.toJSONString("暂无数据"));
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

