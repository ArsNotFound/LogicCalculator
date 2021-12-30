package ru.ars2014.logiccalculator.ast;

import ru.ars2014.logiccalculator.lexer.Token;

public class UnaryOp extends AST {
    private final Token op;
    private final AST expr;

    public UnaryOp(Token op, AST expr) {
        this.op = op;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "UnaryOp{" +
                "op=" + op +
                ", expr=" + expr +
                '}';
    }

    public Token getOp() {
        return op;
    }

    public AST getExpr() {
        return expr;
    }
}
