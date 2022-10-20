package com.practice.expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expense {

    ExpenseEnum type;
    List<User> users;
    User lender;
    float amount;
    Map<User, Float> shares;
    List<Float> expenseTypeData;

    public Expense(ExpenseEnum type, List<User> users, User lender, float amount, List<Float> expenseTypeData) {
        this.type = type;
        this.users = users;
        this.lender = lender;
        this.amount = amount;
        this.shares = new HashMap<>();
        this.expenseTypeData = expenseTypeData;
        this.updateShares();
    }

    public ExpenseEnum getType() {
        return type;
    }

    public void setType(ExpenseEnum type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Map<User, Float> getShares() {
        return shares;
    }

    public void setShares(Map<User, Float> shares) {
        this.shares = shares;
    }

    public List<Float> getExpenseTypeData() {
        return expenseTypeData;
    }

    public void setExpenseTypeData(List<Float> expenseTypeData) {
        this.expenseTypeData = expenseTypeData;
    }


    void updateShares(){
        switch(this.type){
            case EQUAL:
                float amount = this.amount/this.users.size();
                for(User u : this.users){
                    this.shares.put(u, amount);
                }
                return;
            case EXACT:
                int index = 0;
                for(User u : this.users){
                    this.shares.put(u, this.expenseTypeData.get(index));
                    index++;
                }
                return;
            case PERCENT:
                index = 0;
                for(User u : this.users){
                    this.shares.put(u, getAmountByPercent(this.amount, this.expenseTypeData.get(index)));
                    index++;
                }
        }
    }

    float getAmountByPercent(float totalAmount, float percent){
        return (float) ((totalAmount * percent)/100.00);
    }
}
