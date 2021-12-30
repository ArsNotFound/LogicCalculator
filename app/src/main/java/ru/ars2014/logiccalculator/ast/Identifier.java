package ru.ars2014.logiccalculator.ast;

import ru.ars2014.logiccalculator.lexer.Token;

public class Identifier extends AST {
    private final Token p;

    public Identifier(Token p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "p=" + p +
                '}';
    }

    public Token getP() {
        return p;
    }

}
