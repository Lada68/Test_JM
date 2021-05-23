package com.company;

import java.util.*;
import java.util.List;

public class LexemeBuff {
    private int pos;
    public List<Lexemes> lexeme;
    public static int res;

    public LexemeBuff(List<Lexemes> lexeme) {
        this.lexeme = lexeme;
    }

    public Lexemes next() {
        return lexeme.get(pos++);
    }

    public static int factor(LexemeBuff lexeme) throws RuntimeException {
        Lexemes lexemes = lexeme.next();
        if (lexemes.type == LexemeType.NUMBER) {
            int factor1 = Integer.parseInt(lexemes.value);
                 if (factor1 <= 10 && factor1 >= 0) {
                return factor1;
                 } else {throw new RuntimeException("Введено некорректное число " + factor1);}
        } else if (lexemes.type == LexemeType.NUMBER_RUM) {
            int factor1 = Main.lexemeRum.get(lexemes.value);
            if (Main.lexemeRum.get(lexemes.value) == null) {
                throw new RuntimeException("Введен некорректный символ " + lexemes.value);
            } else {
                return factor1;
            }
        } else {
            throw new RuntimeException("Введен некорректный символ " + lexemes.value);
        }}

    public static int result(LexemeBuff lexeme) throws RuntimeException {
        int a = factor(lexeme);
        Lexemes lexemes = lexeme.next();
        switch (lexemes.type) {
            case OP_DIV:
                res = a / factor(lexeme);
                break;
            case OP_MULT:
                res = a * factor(lexeme);
                break;
            case OP_PLUS:
                res = a + factor(lexeme);
                break;
            case OP_MINUS:
                res = a - factor(lexeme);
                break;
            default:
                if (lexemes.type == LexemeType.EOF) {
                    break;
                } else {
                    throw new RuntimeException("Введен некорректный символ " + lexemes.value);
                }
        }
        return res;
    }
}
