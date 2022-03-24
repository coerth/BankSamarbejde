import DomainObjects.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletChangePassword", value = "/ServletChangePassword")
public class ServletChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");

        String oldPassword = request.getParameter("oldPassword");
        String newPasssword = request.getParameter("newPassword");

        Map<String, Account> accounts   = (Map<String, Account>) getServletContext().getAttribute("accounts");

        String messagePassword;


        if(account.getPassword().equals(oldPassword))
        {
            account.setPassword(newPasssword);
            accounts.put(account.getName(), account);
            messagePassword = "Dit password er ændret";
            request.setAttribute("messagePassword", messagePassword);
            request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request, response);
        }

        messagePassword = "Det password du indtastede passer ikke med kontoen";
        request.setAttribute("messagePassword", messagePassword);
        request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request, response);


    }
}
