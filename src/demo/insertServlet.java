package demo;

import dao.staffinfoDao;
import implement.staffinfoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "staffinsertServlet",
        urlPatterns = {"/staffinsertServlet.action"})
public class insertServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");  //设置格式编码
            request.setCharacterEncoding("UTF-8");            //设置格式编码
            staffinfoDao dao = new staffinfoImpl();
            String staffid=request.getParameter("number");
            String staffname=request.getParameter("username");
            String stationid=request.getParameter("title");
            Boolean isAble=false;
            //判断是否上传东西
            FileItemFactory factory = new DiskFileItemFactory();
            //创建文件上传的处理器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析请求
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                String fileName = item.getFieldName();
                if (!item.isFormField()) {//前端保证不空
                    String value = item.getString("utf-8");
                    String uploadname = item.getFieldName();
                    if (uploadname == "demo2") {
                        isAble=true;//资格证
                    }
                }
            }
            dao.insert(staffid,staffname,stationid,isAble);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            public void doGet (HttpServletRequest request, HttpServletResponse response){
                doPost(request, response);
            }
        }
