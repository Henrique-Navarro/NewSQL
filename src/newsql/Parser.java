/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

/**
 *
 * @author henri
 */
import Token.*;
import Statement.SelectStatement;
import java.util.List;
import Statement.*;
import Exception.*;

public class Parser {
    private List<Token> tokens;
    private int current;

    public Parser(List<Token> tokens)
    {
        this.tokens = tokens;
        this.current = 0;
    }

    /**
     * Parses the list of tokens into statements.
     */    
    public void parse()
    {
        while (!isAtEnd()) {
            parseStatement();
        }
    }
    
    private boolean match(TokenType... types)
    {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }
        return false;
    }
    
    private boolean check(TokenType type)
    {
        if (isAtEnd()) return false;
        return peek().getType() == type;
    }
    
    private Token advance()
    {
        if (!isAtEnd()) current++;
        return previous();
    }
    
    private boolean isAtEnd()
    {
        return peek().getType() == TokenType.EOF;
    }
    
    private Token peek()
    {
        return tokens.get(current);
    }
    
    private Token previous()
    {
        return tokens.get(current - 1);
    }
    
    private Token consume(TokenType type, String message)
    {
        if (check(type)) return advance();
        throw error(peek(), message);
    }
    
    private ParseError error(Token token, String message)
    {
        return new ParseError(token, message);
    }
    
    /**
     * Parses a statement based on the current token.
     *
     * @throws ParseError if the statement is not recognized
     */
    private void parseStatement()
    {
        if (match(TokenType.SELECT)) {
            new SelectStatement(this).parseSelectStatement();
        }
        if (match(TokenType.USE)) {
            new UseStatement(this).parseUseStatement();
        }
        if (match(TokenType.DROP)) {
            new DropStatement(this).parseDropStatement();
        }
        if (match(TokenType.SHOW)) {
            new ShowStatement(this).parseShowStatement();
        } 
        if (match(TokenType.CREATE)) {
            new CreateStatement(this).parseCreateStatement();
        }
        
        throw error(peek(), "Unexpected statement.");
    }
}
