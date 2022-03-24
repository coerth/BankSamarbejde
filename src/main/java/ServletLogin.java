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
        int loginAttempt = 0;

        Map<String, Account> accounts = (Map<String, Account>) getServletContext().getAttribute("accounts");

        Account account = accounts.getOrDefault(name, null);

        HttpSession session = request.getSession();

        String errorMessage;

        if (account == null) {
            errorMessage = "Kontoen fandtes ikke";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (!account.getPassword().equals(password)) {

            account.wrongLoginAttempt();
            errorMessage = "Dit password er forkert, prøv igen, du har nu brugt " + account.getLoginAttempt() + " forsøg!";
            request.setAttribute("errorMessage", errorMessage);

            session.setAttribute("name", name);
            //session.setAttribute("loginAttempt", loginAttempt);

            if (account.getLoginAttempt() == 3) {
                account.setAccountLock(true);

                request.getRequestDispatcher("WEB-INF/AccountLocked.jsp").forward(request, response);
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            session.setAttribute("name", name);
            session.setAttribute("account", account);
            request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request, response);
            account.loginSuccessful();
            //
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
