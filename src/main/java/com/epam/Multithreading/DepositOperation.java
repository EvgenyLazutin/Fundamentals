package com.epam.Multithreading;

public class DepositOperation {
    private int numberDep;
    private int balance;

    public DepositOperation(int numberDep, int balance) {
        this.numberDep = numberDep;
        this.balance = balance;
    }

    boolean depPlus(int val){
        if((val+balance)<Integer.MAX_VALUE&&(val+balance)>Integer.MIN_VALUE){
            System.out.print("Balance:"+ balance+ " dep: "+numberDep+"was change on: "+val+ " balance now: ");
            balance+=val;
            System.out.println(balance);
            return true;
        }else return false;
    }

    public int getNumberDep() {
        return numberDep;
    }

    public int getBalance() {
        return balance;
    }
}
