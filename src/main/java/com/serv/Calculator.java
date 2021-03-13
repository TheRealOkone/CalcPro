package com.serv;

import java.util.*;

import static java.lang.Math.*;

public class Calculator {

    public static Double evaluate(ArrayList <String> strList) {

        if(strList.size() == 1){
            return Double.valueOf(strList.get(0));
        }

        while(strList.indexOf("(") == 0 && strList.indexOf(")") == strList.size()-1){
            strList.remove(0);
            strList.remove(strList.size()-1);
        }

        if(strList.contains("(")){
            for(int i = 0; i < strList.size(); i++){
                if(strList.get(i).equals("(")){
                    int b;
                    boolean succ = true;
                    int testo = 0;
                    ArrayList<String> str = new ArrayList<>();
                    for(int j = i + 1; succ; j++){
                        str.add(strList.get(j));
                        b = j+1;
                        if(strList.get(j + 1).equals("(")){
                            testo++;
                        }
                        if(strList.get(j + 1).equals(")")){
                            if(testo == 0) {
                                succ = false;
                            }
                            else{
                                testo--;
                            }
                        }

                    }
                    Double c = evaluate(str);
                    strList.set(i,c.toString());
                    while(!strList.get(i + 1).equals(")")){
                        strList.remove(i + 1 );
                    }
                    strList.remove(i + 1 );
                }
            }
        }

        if(!strList.contains("(")){
            if(strList.contains("+")){
                List<String> subList = new ArrayList<>();
                for(int i = 0; i < strList.indexOf("+"); i++){
                    subList.add(strList.get(i));
                }
                List<String> subList2 = new ArrayList<>();
                for(int i = strList.indexOf("+") + 1; i < strList.size(); i++){
                    subList2.add(strList.get(i));
                }
                 return goCalc(subList, "+", subList2);

            }
            if(strList.contains("-")){
                List<String> subList = new ArrayList<>();
                for(int i = 0; i < strList.indexOf("-"); i++){
                    subList.add(strList.get(i));
                }
                List<String> subList2 = new ArrayList<>();
                for(int i = strList.indexOf("-") + 1; i < strList.size(); i++){
                    subList2.add(strList.get(i));
                }
                return goCalc(subList, "-", subList2);

            }
            if(strList.contains("*")){
                List<String> subList = new ArrayList<>();
                for(int i = 0; i < strList.indexOf("*"); i++){
                    subList.add(strList.get(i));
                }
                List<String> subList2 = new ArrayList<>();
                for(int i = strList.indexOf("*") + 1; i < strList.size(); i++){
                    subList2.add(strList.get(i));
                }
                return goCalc(subList, "*", subList2);

            }
            if(strList.contains("/")){
                List<String> subList = new ArrayList<>();
                for(int i = 0; i < strList.indexOf("/"); i++){
                    subList.add(strList.get(i));
                }
                List<String> subList2 = new ArrayList<>();
                for(int i = strList.indexOf("/") + 1; i < strList.size(); i++){
                    subList2.add(strList.get(i));
                }
                return goCalc(subList, "/", subList2);

            }
        }
        return 0.0;
    }

    private static Double goCalc(List<String> subList, String s, List<String> subList2) {
        switch(s)
        {
            case "+":
                return evaluate((ArrayList<String>) subList) + evaluate((ArrayList<String>) subList2);

            case "-":
                return evaluate((ArrayList<String>) subList) - evaluate((ArrayList<String>) subList2);

            case "*":
                return evaluate((ArrayList<String>) subList) * evaluate((ArrayList<String>) subList2);

            case "/":
                return evaluate((ArrayList<String>) subList) / evaluate((ArrayList<String>) subList2);
        }
        return 0.0;
    }



    public double calc(String req){
        return evaluate(new ArrayList<>(Arrays.asList(req.trim().split(" "))));
    }

}
