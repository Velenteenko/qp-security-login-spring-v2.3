package ua.com.vza.work.doc.kay.quality;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by kycenko on 23.06.15.
 */
@WebServlet(name = "Start")
public class Start extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("----=====>>>>> Application Quality Product is Start " + new Date() + " <<<<<=====----");
        //Тут организовать передачу запуска JMS с бесконечным цыклом по проверке DBF таблицы и контрагентов из 1С

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("authcheck").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
