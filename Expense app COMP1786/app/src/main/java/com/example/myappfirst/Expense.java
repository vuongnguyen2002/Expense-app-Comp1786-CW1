package com.example.myappfirst;

public class Expense {
    private String namespense;
    private int expenseAmount;

    private String messagetext;



    public Expense(String namespense, int expenseAmount, String messagetext) {
        this.namespense = namespense;
        this.expenseAmount = expenseAmount;
        this.messagetext = messagetext;
    }

    public String getNamespense() {
        return namespense;
    }

    public void setNamespense(String namespense) {
        this.namespense = namespense;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }


}
