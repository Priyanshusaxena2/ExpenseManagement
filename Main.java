package com.practice.expense;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ExpenseAdmin admin = new ExpenseAdmin();

        Scanner sc = new Scanner(System.in);

        while(true) {
            String s = sc.next();

            switch (s) {
                case "SHOW":
                    String user = sc.next();
                    User lender = admin.findUserbyId(user);
                    admin.show(lender);
                    break;
                case "EXPENSE":
                    user = sc.next();
                    lender = admin.findUserbyId(user);
                    float amount = sc.nextFloat();
                    int n = sc.nextInt();
                    List<User> users = new ArrayList<>();
                    for(int i=0;i<n;i++){
                        users.add(admin.findUserbyId(sc.next()));
                    }
                    String type = sc.next();
                    List<Float> data = new ArrayList<>();
                    if(!type.equalsIgnoreCase("EQUAL")){
                        for(int i=0;i<n;i++)
                        data.add(sc.nextFloat());
                    }

                    admin.createExpense(type, users, lender, amount ,data);
                    break;
                case "STOP":
                    System.exit(0);

            }
        }

    }
}

