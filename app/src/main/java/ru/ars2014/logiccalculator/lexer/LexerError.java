package ru.ars2014.logiccalculator.lexer;

import androidx.annotation.Nullable;

public class LexerError extends Exception {
    private final char lexeme;
    private final int pos;

    public LexerError(char lexeme, int pos) {
        this.lexeme = lexeme;
        this.pos = pos;
    }

    public char getLexeme() {
        return lexeme;
    }

    public int getPos() {
        return pos;
    }

    @Nullable
    @Override
    public String getMessage() {
        return "Lexer error on " + lexeme + " pos: " + pos;
    }
}
