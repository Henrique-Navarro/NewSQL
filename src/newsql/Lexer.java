/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author henri
 */
public class Lexer {
    // Mapa para armazenar os padrões e os tokens correspondentes
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
        TOKENS.put("NULL", TokenType.NULL);
        TOKENS.put("TRUE", TokenType.TRUE);
        TOKENS.put("FALSE", TokenType.FALSE);
        TOKENS.put("IF", TokenType.IF);

        // Outros
        TOKENS.put("USE", TokenType.USE);
        TOKENS.put("SHOW", TokenType.SHOW);
        TOKENS.put("DESCRIBE", TokenType.DESCRIBE);

        // Tipos de dados
        TOKENS.put("INT", TokenType.INT);
        TOKENS.put("FLOAT", TokenType.FLOAT);
        TOKENS.put("TEXT", TokenType.TEXT);
        TOKENS.put("BOOL", TokenType.BOOL);
        
        // Símbolos
        TOKENS.put("(", TokenType.ABRE_PARENTESES);
        TOKENS.put(")", TokenType.FECHA_PARENTESES);
        TOKENS.put(",", TokenType.VIRGULA);
        TOKENS.put(";", TokenType.PONTO_VIRGULA);
        TOKENS.put("*", TokenType.ASTERISCO);
        TOKENS.put("=", TokenType.EQUAL);

    }
    
    // Expressão regular para identificar identificadores
    private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*");

    // Expressão regular para identificar números inteiros
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+(\\.\\d+)?");
    
    // Método para tokenizar o texto de entrada
    public static ArrayList<Token> tokenize(String input) {
        String[] tokensString = input.split("\\s+"); // Divide o texto por espaços em branco
        ArrayList<Token> tokens = new ArrayList<Token>();
        // Imprimir cabeçalhos da tabela
        System.out.println("| Token        | Tipo             |");
        System.out.println("+--------------+------------------+");

        for (String token : tokensString) {
            TokenType type = getTokenType(token);
            tokens.add(new Token(token, type));
            System.out.printf("| %-12s | %-16s |\n", token, type);
        }

        // Imprimir linha final da tabela
        System.out.println("+--------------+-----------------+");
        
        return tokens;
    }

    // Método auxiliar para obter o tipo de token para uma palavra
    private static TokenType getTokenType(String token) {
        if (TOKENS.containsKey(token.toUpperCase())) {
            return TOKENS.get(token.toUpperCase());
        } else if (isIdentifier(token)) {
            return TokenType.IDENTIFIER;
        } else if (isNumber(token)) {
            return TokenType.NUMBER;
        } else {
            return TokenType.UNKNOWN;
        }
    }

    // Método auxiliar para verificar se uma palavra é um identificador
    private static boolean isIdentifier(String token) {
        Matcher matcher = IDENTIFIER_PATTERN.matcher(token);
        return matcher.matches();
    }

    // Método auxiliar para verificar se uma palavra é um número inteiro
    private static boolean isNumber(String token) {
        Matcher matcher = NUMBER_PATTERN.matcher(token);
        return matcher.matches();
    }
}