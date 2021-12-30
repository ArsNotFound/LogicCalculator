package ru.ars2014.logiccalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.ars2014.logiccalculator.lexer.Lexer;
import ru.ars2014.logiccalculator.lexer.LexerError;
import ru.ars2014.logiccalculator.lexer.Token;

public class LexerTest {
    @Test
    public void TestEOF() throws LexerError {
        Lexer l = new Lexer("");
        Token t = l.getNextToken();
        assertEquals(Token.Type.EOF, t.getType());
        assertEquals(0, t.getPos());
        assertEquals("", t.getLiteral());
    }

    @Test
    public void TestParameter() throws LexerError {
        Lexer l = new Lexer("ABC ab14f");
        Token t = l.getNextToken();
        assertEquals(Token.Type.Param, t.getType());
        assertEquals(0, t.getPos());
        assertEquals("ABC", t.getLiteral());

        t = l.getNextToken();
        assertEquals(Token.Type.Param, t.getType());
        assertEquals(4, t.getPos());
        assertEquals("ab14f", t.getLiteral());
    }

    @Test
    public void TestConst() throws LexerError {
        Lexer l = new Lexer("1 0");
        Token t = l.getNextToken();
        assertEquals(Token.Type.Const, t.getType());
        assertEquals(0, t.getPos());
        assertEquals("1", t.getLiteral());

        t = l.getNextToken();
        assertEquals(Token.Type.Const, t.getType());
        assertEquals(2, t.getPos());
        assertEquals("0", t.getLiteral());
    }

    @Test
    public void TestOperators() throws LexerError {
        Lexer l = new Lexer("!*+-><=>()");
        assertEquals(Token.Type.Not, l.getNextToken().getType());
        assertEquals(Token.Type.Conj, l.getNextToken().getType());
        assertEquals(Token.Type.Disj, l.getNextToken().getType());
        assertEquals(Token.Type.Impl, l.getNextToken().getType());
        assertEquals(Token.Type.Equal, l.getNextToken().getType());
        assertEquals(Token.Type.LParen, l.getNextToken().getType());
        assertEquals(Token.Type.RParen, l.getNextToken().getType());
    }
}
