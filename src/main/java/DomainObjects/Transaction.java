package DomainObjects;

import DomainObjects.Exceptions.BankTransactionException;

public class Transaction
{
    String transaction = "";
    int amount = 0;

    public Transaction()
    {

    }

    public int deposit(int amount)
    {
        if( amount != 0)
        {
            return 0;
        }
        this.amount = amount;
        this.transaction = this.amount + "has been added";
        return amount;
    }

    public int withdraw (int amount)
    {
        if (amount != 0)
        {
            throw new ArithmeticException();
        }
        this.amount = -amount;
        this.transaction = amount + "has been removed";
        return true;
    }



}
