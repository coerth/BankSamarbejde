import DomainObjects.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("user");
        String password = request.getParameter("password");

       Map<String, Account> accounts   = (Map<String, Account>) getServletContext().getAttribute("account");

       Account account = accounts.getOrDefault(name, null);

        String errorMessage;

       if(account == null)
       {
           errorMessage = "Kontoen fandtes ikke";
           request.setAttribute("errorMessage", errorMessage);
           request.getRequestDispatcher("index.jsp").forward(request, response);
       }

       if(!account.getPassword().equals(password) )
       {
           errorMessage = "dit login er forkert";
           request.setAttribute("errorMessage", errorMessage);
           request.getRequestDispatcher("index.jsp").forward(request, response);
       }

       HttpSession session = request.getSession();

       session.setAttribute("name", name);
       session.setAttribute("account", account);

        request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request,response);
       //

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
