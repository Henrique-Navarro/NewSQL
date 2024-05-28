/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import newsql.Exception.IllegalCharacter;

public class Lexer {    
    private static final Pattern TOKEN_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*|\\d+(\\.\\d+)?|\\S");
    /**
     * Tokenizes the given input string into a list of tokens.
     * 
     * @throws IllegalCharacter
     * @param input the input string to tokenize
     * @return an ArrayList of tokens
     */
    public static ArrayList<Token> tokenize(String input) throws IllegalCharacter
    {
        ArrayList<Token> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(input);
        
        while (matcher.find()) {
            String token = matcher.group();
            TokenType type = getTokenType(token);
            tokens.add(new Token(token, type));
        }
        print(tokens);

        return tokens;
    }
    
    /**
     * Determines the token type for a given token string.
     *
     * @throws IllegalCharacter
     * @param token the token string to be classified
     * @return the token type of the given token
     */
    private static TokenType getTokenType(String token) throws IllegalCharacter
    {
        String upperToken = token.toUpperCase();
        TokenType type = TOKENS.get(upperToken);
        
        if (type != null) {
            return type;
        }
        if (isIdentifier(token)) {
            return TokenType.IDENTIFIER;
        } 
        if (isNumber(token)) {
            return TokenType.NUMBER;
        } 
            
        throw new IllegalCharacter("Sintax Error - illegal character '" + token +"'");
    }

    private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");
    /**
     * Checks if the given token is a valid identifier.
     *
     * @param token the token string to check
     * @return true if the token is a valid identifier, false otherwise
     */
    private static boolean isIdentifier(String token)
    {
        Matcher matcher = IDENTIFIER_PATTERN.matcher(token);
        return matcher.matches();
    }
 
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+(\\.\\d+)?");
    /**
     * Checks if the given token is a valid number.
     *
     * @param token the token string to check
     * @return true if the token is a valid number, false otherwise
     */
    private static boolean isNumber(String token)
    {
        Matcher matcher = NUMBER_PATTERN.matcher(token);
        return matcher.matches();
    }
    
    /**
    * Prints the tokens in the given array.
    *
    * @param tokensString the array of token strings to be printed
    */
    private static void print(ArrayList<Token> tokens)
    {
        System.out.println("| Token        | Tipo             |");
        System.out.println("+--------------+------------------+");

        for (Token token : tokens) {
            String valor = token.getValor();
            TokenType type = token.getTipo();
            System.out.printf("| %-12s | %-16s |\n", valor, type);
        }

        System.out.println("+--------------+------------------+");
    }
    
    private static final Map<String, TokenType> TOKENS = new HashMap<>();
    
    static {
        // Palavras reservadas
        TOKENS.put("SELECT", TokenType.SELECT);
        TOKENS.put("INSERT", TokenType.INSERT);
        TOKENS.put("DELETE", TokenType.DELETE);
        TOKENS.put("UPDATE", TokenType.UPDATE);
        TOKENS.put("FROM", TokenType.FROM);
        TOKENS.put("WHERE", TokenType.WHERE);
        TOKENS.put("GROUP_BY", TokenType.GROUP_BY);
        TOKENS.put("ORDER_BY", TokenType.ORDER_BY);
        TOKENS.put("LIMIT", TokenType.LIMIT);
        TOKENS.put("DISTINCT", TokenType.DISTINCT);
        TOKENS.put("CREATE", TokenType.CREATE);
        TOKENS.put("ALTER", TokenType.ALTER);
        TOKENS.put("DROP", TokenType.DROP);
        TOKENS.put("TABLE", TokenType.TABLE);

        // Condições
        TOKENS.put("AND", TokenType.AND);
        TOKENS.put("OR", TokenType.OR);
        TOKENS.put("NOT", TokenType.NOT);
        TOKENS.put("TRUE", TokenType.TRUE);
        TOKENS.put("FALSE", TokenType.FALSE);
        TOKENS.put("IF", TokenType.IF);
        TOKENS.put("IS", TokenType.IS);
        TOKENS.put(">", TokenType.MAIOR);
        TOKENS.put("<", TokenType.MENOR);

        // Outros
        TOKENS.put("USE", TokenType.USE);
        TOKENS.put("SHOW", TokenType.SHOW);
        TOKENS.put("DESCRIBE", TokenType.DESCRIBE);

        // Tipos de dados
        TOKENS.put("INT", TokenType.INT);
        TOKENS.put("FLOAT", TokenType.FLOAT);
        TOKENS.put("TEXT", TokenType.TEXT);
        TOKENS.put("BOOL", TokenType.BOOL);
        TOKENS.put("NULL", TokenType.NULL);

        // Operadores
        TOKENS.put("+", TokenType.MAIS);
        TOKENS.put("-", TokenType.MENOS);
        TOKENS.put("MULT", TokenType.VEZES);
        TOKENS.put("DIV", TokenType.DIVIDIR);
        
        // Símbolos
        TOKENS.put("(", TokenType.ABRE_PARENTESES);
        TOKENS.put(")", TokenType.FECHA_PARENTESES);
        TOKENS.put(",", TokenType.VIRGULA);
        TOKENS.put(";", TokenType.PONTO_VIRGULA);
        TOKENS.put("*", TokenType.ASTERISCO);
        TOKENS.put("=", TokenType.EQUAL);
        
        // Funções
        TOKENS.put("PI", TokenType.PI);
        TOKENS.put("CEIL", TokenType.CEIL);
        TOKENS.put("FLOOR", TokenType.FLOOR);
        TOKENS.put("POW", TokenType.POW);
        TOKENS.put("SQRT", TokenType.SQRT);
    }
}