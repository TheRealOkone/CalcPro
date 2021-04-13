package com.serv;

import java.util.*;

import static java.lang.Math.*;

/**
 * Класс для вычислений
 */
public class Calculator {

    public static Double evaluate(ArrayList <String> strList) {

        if(strList.size() == 1){
            return Double.valueOf(strList.get(0));
        }

        while(strList.indexOf("(") == 0 && strList.indexOf(")") == strList.size()-1){
            strList.remove(0);
            strList.remove(strList.size()-1);
        }

        if(strList.contains("(") || strList.contains("sqrt(") || strList.contains("pow(") || strList.contains("abs(")){

            for(int i = 0; i < strList.size(); i++){
                if(strList.get(i).equals("sqrt(")){
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
                    double c = sqrt(evaluate(str));
                    strList.set(i, Double.toString(c));
                    while(!strList.get(i + 1).equals(")")){
                        strList.remove(i + 1 );
                    }
                    strList.remove(i + 1 );
                }
            }

            for(int i = 0; i < strList.size(); i++){
                if(strList.get(i).equals("abs(")){
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
                    double c = abs(evaluate(str));
                    strList.set(i, Double.toString(c));
                    while(!strList.get(i + 1).equals(")")){
                        strList.remove(i + 1 );
                    }
                    strList.remove(i + 1 );
                }
            }


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
            if(strList.contains("^")){
                List<String> subList = new ArrayList<>();
                for(int i = 0; i < strList.indexOf("^"); i++){
                    subList.add(strList.get(i));
                }
                List<String> subList2 = new ArrayList<>();
                for(int i = strList.indexOf("^") + 1; i < strList.size(); i++){
                    subList2.add(strList.get(i));
                }
                return goCalc(subList, "^", subList2);

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



        if(strList.size() == 1){
            return Double.valueOf(strList.get(0));
        }
        return 0.0;
    }

    public Double dx(String str){
        ArrayList<String> alist = new ArrayList<>(Arrays.asList(str.trim().split(" ")));
        alist = fixlist(alist);
        System.out.println(alist);
        return 0.0;
    }

    /**
     * Вычисление простейшей операции
     * @param subList
     * @param s
     * @param subList2
     * @return
     */
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

            case "^":
                return Math.pow(evaluate((ArrayList<String>) subList),evaluate((ArrayList<String>) subList2));
        }
        return 0.0;
    }
    public ArrayList<String> fixstr(String str){

        String[] mas = new String[]{"(", ")", "+", "*", "/", "^", "x"};
        for(int i = 0; i < mas.length;i++) {
            if (str.contains(mas[i])) {
                str = mod(str, mas[i].charAt(0));
            }
        }
        if (str.contains("abs (")) {
            str = str.replace("abs (","abs(");
        }
        if (str.contains("sqrt (")) {
            str = str.replace("sqrt (","sqrt(");
        }
        ArrayList<String> a = new ArrayList<>(Arrays.asList(str.trim().split(" ")));
        return a;
    }
    public String mod(String str, char c){

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                str = str.replace(Character.toString(c)," " + Character.toString(c) + " ");
                i++;
            }
        }
        return str;
    }
    public ArrayList<String> fixlist(ArrayList<String> a){
        for(int i = 0; i < a.size(); i++){
            String str = a.get(i);
            ArrayList<String> splitted = fixstr(str);
            a.remove(i);
            a.addAll(i,splitted);
            a.remove("");
        }

        return a;
    }

    /**
     * Запуск вычислений
     * @param req
     * @return Результат
     */
    public double calc(String req){
        ArrayList<String> alist = new ArrayList<>(Arrays.asList(req.trim().split(" ")));
        alist = fixlist(alist);
        double res = evaluate(alist);
        return res;
    }

}
