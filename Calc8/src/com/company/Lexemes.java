package com.company;

import java.util.*;

public class Lexemes {
    LexemeType type;
    String value;

    public Lexemes(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Lexemes(LexemeType type, Character value) {
        this.type = type;
        this.value = value.toString();
    }

    public static List<Lexemes> LexemeAnalyze(String data) throws RuntimeException {
        ArrayList<Lexemes> lexeme = new ArrayList<>();
        int pos = 0;
        while (pos <= Main.data.length()) {
            char c = Main.data.charAt(pos);
            switch (c) {
                case '+':
                    lexeme.add(new Lexemes(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexeme.add(new Lexemes(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexeme.add(new Lexemes(LexemeType.OP_MULT, c));
                    pos++;
                    continue;
                case '/':
                    lexeme.add(new Lexemes(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sbr = new StringBuilder();
                         while (c <= '9' && c >= '0'){
                            sbr.append(c);
                            pos++;
                            if (pos >= Main.data.length()) {
                                break;
                            }
                           c = Main.data.charAt(pos);
                        }
                        lexeme.add(new Lexemes(LexemeType.NUMBER, sbr.toString()));
                    } else if (c == 'I' || c == 'V' || c == 'X') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= Main.data.length()) {
                                break;
                            }
                            c = Main.data.charAt(pos);
                        } while (c == 'I' || c == 'V' || c == 'X');
                        lexeme.add(new Lexemes(LexemeType.NUMBER_RUM, sb.toString()));
                    } else {
                      throw new RuntimeException("Введен некорректный символ " + c);
                    }
                  pos++;


            }


        }
      lexeme.add(new Lexemes(LexemeType.EOF, " "));
        return lexeme;
    }
}