package DomainObjects;

public class Account
{
    private String name;
    private String password;
    private int balance;
    private boolean accountLock = false;
    private int loginAttempt;

    public int wrongLoginAttempt(){
     loginAttempt++;
        return loginAttempt;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

    public int loginSuccessful() {
        loginAttempt = 0;
        return loginAttempt;
    }

    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }


    public boolean isAccountLock() {
        return accountLock;
    }

    public void setAccountLock(boolean accountLock) {
        this.accountLock = accountLock;
    }


    public Account(String name, String password, int balance)
    {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int deposit(int i)
    {


        if (i > 0) {
            balance = balance + i;
        }

        return balance;
    }



    public int withdraw(int i)
    {
        if(i > 0)
        {
            balance = balance - i;
        }

        return balance;

    }
}
