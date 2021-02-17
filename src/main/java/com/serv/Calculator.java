package com.serv;

public class Calculator {

    public double calc(String req){

        if (req.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
            return Double.parseDouble(req);

        return 14.88;
    }

}
