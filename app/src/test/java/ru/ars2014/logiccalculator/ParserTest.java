package ru.ars2014.logiccalculator;

import org.junit.Test;

import ru.ars2014.logiccalculator.lexer.Lexer;
import ru.ars2014.logiccalculator.lexer.LexerError;
import ru.ars2014.logiccalculator.parser.Parser;
import ru.ars2014.logiccalculator.parser.ParserError;

public class ParserTest {
    @Test
    public void TestParse() throws LexerError, ParserError {
        Lexer l = new Lexer("(a + b) -> !c * d <=> a * b + c");
        Parser p = new Parser(l);

        p.parse();
    }

    @Test(expected = ParserError.class)
    public void TestParseThrows() throws LexerError, ParserError {
        Lexer l = new Lexer("(a + b) -> !c  d <=> a * b + c");
        Parser p = new Parser(l);

        p.parse();
    }
}
