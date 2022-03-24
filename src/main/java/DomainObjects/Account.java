package DomainObjects;

public class Account
{
    private String name;
    private String password;
    private int balance;


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
