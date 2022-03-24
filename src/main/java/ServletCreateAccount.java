import DomainObjects.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletCreateAccount", value = "/ServletCreateAccount")
public class ServletCreateAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("newUser");
        String password = request.getParameter("newPassword");
        String errorMessage;

        Map<String, Account> accounts = (Map<String, Account>) getServletContext().getAttribute("accounts");

        HttpSession session = request.getSession();

        if(accounts.containsKey(name))
        {
            errorMessage = "Det navn er allerede i brug, vælg et andet";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        Account account = new Account(name, password,0);


        accounts.put("account", account);


        session.setAttribute("name", name);
        session.setAttribute("account", account);

        request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
