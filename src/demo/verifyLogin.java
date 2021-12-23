package demo;

import implement.StaffDaoImpl;
import model.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verifyLogin")
public class verifyLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        String staffId = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            StaffDaoImpl ldi = new StaffDaoImpl();
            Staff staff = ldi.verifyLogin(staffId,password);
            if (staff != null) {
                request.getSession().setAttribute("staff", staff);
                response.sendRedirect("staffInfo.jsp");
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

