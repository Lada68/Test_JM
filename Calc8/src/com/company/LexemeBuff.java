package com.company;

import java.util.List;

public class LexemeBuff {
    private int pos;
    public List<Lexemes> lexeme;
    public static double res;
    public static double factor1;

    public LexemeBuff(List<Lexemes> lexeme) {
        this.lexeme = lexeme;
    }

    public Lexemes next() {
        return lexeme.get(pos++);
    }

    public static double factor(LexemeBuff lexeme) throws RuntimeException {
        Lexemes lexemes = lexeme.next();
        if (lexemes.type == LexemeType.NUMBER) {
            factor1 = Integer.parseInt(lexemes.value);

            if (factor1 <= 10 && factor1 >= 0) {
                return factor1;
            } else {
                throw new RuntimeException("Введено некорректное число " + factor1);
            }
        } else if (lexemes.type == LexemeType.NUMBER_RUM && Main.lexemeRum.get(lexemes.value) != null) {
            factor1 = Main.lexemeRum.get(lexemes.value);
            return factor1;
        } else {
            throw new RuntimeException("Введен некорректный символ: " + lexemes.value);

        }
    }

    public static double result(LexemeBuff lexeme) {
        double a = factor(lexeme);
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
                    throw new RuntimeException("Введен некорректный символ: " + lexemes.value);
                }
        }
        return res;
    }
}
