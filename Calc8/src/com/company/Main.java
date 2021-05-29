package com.company;

import java.util.*;

import static com.company.LexemeType.NUMBER;
import static com.company.LexemeType.NUMBER_RUM;


public class Main {

    public static String data;
    public static HashMap<String, Integer> lexemeRum = new HashMap<>();

    public static void main(String[] args) {

        LexemeRum.met(lexemeRum);
        while (true) {
            System.out.println("Наберите \"end\" для выхода из программы или\n введите выражение для вычисления:");
            Scanner scr = new Scanner(System.in);
            data = scr.nextLine();
            if (!data.equals("end")) {
                List<Lexemes> lexemes1 = Lexemes.LexemeAnalyze(data);
                Lexemes lexemes = lexemes1.get(0);
                Lexemes lexemes3 = lexemes1.get(2);
                LexemeBuff lexemeBuff = new LexemeBuff(lexemes1);

                try {
                    if (lexemes.type == NUMBER_RUM && lexemes3.type == NUMBER_RUM) {
                        System.out.println(Convert.transform_number_to_roman_numeral(LexemeBuff.result(lexemeBuff)));

                    } else if (lexemes.type == NUMBER && lexemes3.type == NUMBER) {
                        System.out.println(LexemeBuff.result(lexemeBuff));

                    } else {
                        throw new Exception("Некорректный ввод: " + data);
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


            } else break;
        }

    }
}

