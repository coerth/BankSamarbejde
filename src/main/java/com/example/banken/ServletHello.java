package com.example.banken;

import DomainObjects.Account;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletHello", value = "/ServletHello")
public class ServletHello extends HttpServlet
{

    Map<String , Account> accounts = new HashMap<>();

    /*public void init()
    {

        Account account = new Account("nicolai","1", 150);
        Account account1 = new Account("denis","1", 15);
        Account account2 = new Account("Betyl","1", 170);
        Account account3 = new Account("long","1", 15);
        Account account4 = new Account("Kristoffer","1", 1500);
        Account account5 = new Account("søren","1", 2157);

        accounts.put(account.getName(), account);
        accounts.put(account1.getName(), account1);
        accounts.put(account2.getName(), account2);
        accounts.put(account3.getName(), account3);
        accounts.put(account4.getName(), account4);
        accounts.put(account5.getName(), account5);

    }*/

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        /*this.config = config;
        this.init();*/


        Account account = new Account("nicolai","1", 150);
        Account account1 = new Account("denis","1", 15);
        Account account2 = new Account("betyl","1", 170);
        Account account3 = new Account("long","1", 15);
        Account account4 = new Account("kristoffer","1", 1500);
        Account account5 = new Account("søren","1", 2157);

        accounts.put(account.getName(), account);
        accounts.put(account1.getName(), account1);
        accounts.put(account2.getName(), account2);
        accounts.put(account3.getName(), account3);
        accounts.put(account4.getName(), account4);
        accounts.put(account5.getName(), account5);

        getServletContext().setAttribute("accounts", accounts);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("account", accounts);

        String msg = "her er en oversigt over kontisne";

        request.setAttribute("msg",msg);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy()
    {
    }
}