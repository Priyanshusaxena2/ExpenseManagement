package com.practice.expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdmin {

    List<Expense> expences;
    List<User> users;
    Balance balance;

    public ExpenseAdmin(){
        this.expences = new ArrayList<>();
        this.users = new ArrayList<>();
        this.balance = new Balance();
    }

    void createExpense(String type, List<User> users, User lender, float amount, List<Float> data){
        Expense expense = new Expense(getEnum(type),users, lender,amount, data);
        balance.update(lender, expense.getShares());
    }

    User findUserbyId(String userId){

        for(User u: this.users){
            if(u.getUserId().equals(userId))
                return u;
        }
        User u = new User(userId,"","","");
        this.users.add(u);
        return u;
    }

    ExpenseEnum getEnum(String name){
        if(name.equals("EQUAL")){
            return ExpenseEnum.EQUAL;
        }else if(name.equals("EXACT")){
            return ExpenseEnum.EXACT;
        }
        return ExpenseEnum.PERCENT;
    }

    void show(User user){
        this.balance.show(user);
    }
}
