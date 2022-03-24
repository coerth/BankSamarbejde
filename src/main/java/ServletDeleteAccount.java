import DomainObjects.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletDeleteAccount", value = "/ServletDeleteAccount")
public class ServletDeleteAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String enteredPassword = request.getParameter("password");
        Map<String, Account> accounts = (Map<String, Account>) getServletContext().getAttribute("accounts");

        String accountPassword = account.getPassword();

        if(enteredPassword.equals(accountPassword))
        {
            accounts.remove(account.getName());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);


    }
}
