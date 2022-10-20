package com.practice.expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balance{

    static class BalanceNode{
        User user;
        Float amount;

        public BalanceNode(User user, Float amount) {
            this.user = user;
            this.amount = amount;
        }
    }

    Map<User, List<BalanceNode>> balances;

    public Balance(){
        this.balances = new HashMap<>();
    }


    void update(User lender, Map<User, Float> balance) {
        List<BalanceNode> existingUsers = this.balances.containsKey(lender) ? this.balances.get(lender) : new ArrayList<>();
        for (Map.Entry<User, Float> entry : balance.entrySet()) {
            BalanceNode balanceNode = findExisting(lender, entry.getKey());
            if(balanceNode == null){
                balanceNode = new BalanceNode(entry.getKey(), (float) 0);
                existingUsers.add(balanceNode);
            }
            balanceNode.amount = balanceNode.amount + entry.getValue();
        }
        this.balances.put(lender, existingUsers);
    }

    BalanceNode findExisting(User lender, User receiver){
        if(!this.balances.containsKey(lender)){
            return null;
        }
        for(BalanceNode b: this.balances.get(lender)){
            if(b.user.userId.equals(receiver.getUserId())){
                return b;
            }
        }
        return null;
    }

    void show(User user){
        if(!this.balances.containsKey(user)){
            System.out.println("NO Balances");
            return;
        }
        for(BalanceNode u: this.balances.get(user)){
            if(u.user == user)
                continue;
            float oppBalance = findOppBalance(u.user, user);
            float amount = u.amount-oppBalance;
            if(amount >= 0.0)
            System.out.println(u.user.getUserId() + " owes " + user.getUserId() + ": " + amount);
            else
                System.out.println(user.getUserId() + " owes " + u.user.getUserId() + ": " + -amount);

        }

    }

    float findOppBalance(User u1, User u2){
        if(!this.balances.containsKey(u1)){
            return 0.0F;
        }
        for(BalanceNode b: this.balances.get(u1)){
            if(b.user.userId.equals(u2.getUserId())){
                return b.amount;
            }
        }
        return 0.0F;
    }

}
