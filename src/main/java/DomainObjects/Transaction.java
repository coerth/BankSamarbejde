package DomainObjects;

public class Transaction
{
    String transaction = "";
    int amount = 0;

    public Transaction()
    {
    }

    public void deposit(int amount)
    {
        this.amount = amount;
        this.transaction = amount + "has been added";

    }


}
