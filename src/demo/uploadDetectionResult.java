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

@WebServlet("/uploadDetectionResult")
public class uploadDetectionResult extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String orderId = request.getParameter("orderId");
        String result = request.getParameter("result");
        String stationId = request.getParameter("stationId");
        String staffId = request.getParameter("staffId");
        RecordDaoImpl rdi = new RecordDaoImpl();
        try {
            Record record = new Record();
            record.setOrderId(orderId);
            record.setResult(result);
            record.setProcess("已完成");
            record.setAvailable(1);
            Boolean flag = rdi.uploadDetectionResult(record);
            if (flag) {
                ArrayList<Record> list = rdi.getRecordList(stationId,staffId);
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


