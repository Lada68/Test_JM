package com.company;

import java.util.*;

import static com.company.LexemeType.NUMBER;
import static com.company.LexemeType.NUMBER_RUM;


public class Main {

    public static String data;
    public static HashMap<String, Integer> lexemeRum = new HashMap<>();

    public static void main(String[] args) throws RuntimeException {

        LexemeRum.met(lexemeRum);
        System.out.println("Введите выражение для вычисления: ");
        Scanner scr = new Scanner(System.in);
        data = scr.nextLine();

        List<Lexemes> lexemes1 = Lexemes.LexemeAnalyze(data);
        System.out.println(lexemes1.size());
       Lexemes lexemes = lexemes1.get(0);
    //  Lexemes lexemes4 = lexemes1.get(3);
      Lexemes lexemes2 = lexemes1.get(1);
        Lexemes lexemes3 = lexemes1.get(2);
      System.out.println(lexemes.value+lexemes2.value+lexemes3.value);
        LexemeBuff lexemeBuff = new LexemeBuff(lexemes1);
        if (lexemes.type == NUMBER_RUM && lexemes3.type == NUMBER_RUM) {
            System.out.println(Convert.transform_number_to_roman_numeral(LexemeBuff.result(lexemeBuff)));
        } else if (lexemes.type == NUMBER && lexemes3.type == NUMBER){
            System.out.println(LexemeBuff.result(lexemeBuff));
        } else {throw new RuntimeException("Некорректный ввод: " + data);


    }
}}
