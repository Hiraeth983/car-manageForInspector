package demo;

import com.alibaba.fastjson.JSON;
import implement.RecordDaoImpl;
import model.Record;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getRecordList")
public class getRecordList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String stationId = request.getParameter("stationId");
        String staffId = request.getParameter("staffId");
        RecordDaoImpl rdi = new RecordDaoImpl();
        try {

            ArrayList<Record> recordList = rdi.getRecordList(stationId,staffId);
            if (!recordList.isEmpty()) {
                response.getWriter().print(JSONArray.fromObject(recordList));
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
