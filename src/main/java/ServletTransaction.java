import DomainObjects.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTransaction", value = "/ServletTransaction")
public class ServletTransaction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();

        String amount = request.getParameter("amount");
        String type = request.getParameter("type");
        log("Beløbet er " + amount);

        int intAmount = 0;

        try {
            intAmount = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            String errorMessage = "Husk beløbet skal være et tal";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request, response);
        }


        Account account = (Account) httpSession.getAttribute("account");
        if(type.equals("Insert"))
        {
            account.deposit(intAmount);
        }
        if(type.equals("Withdraw"))
        {
            account.withdraw(intAmount);
        }

        httpSession.setAttribute("account", account);

        request.getRequestDispatcher("WEB-INF/UserSite.jsp").forward(request, response);
    }
}
