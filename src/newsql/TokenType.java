/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

/**
 *
 * @author henri
 */
public enum TokenType {
        // Palavras reservadas
        SELECT, INSERT, DELETE, UPDATE, FROM, WHERE, GROUP_BY, ORDER_BY, LIMIT, DISTINCT, CREATE, ALTER, DROP, TABLE,
        // Condições
        AND, OR, NOT, NULL, TRUE, FALSE, IF, IS, MAIOR, MENOR,
        //OPERADORES
        MAIS, MENOS, VEZES, DIVIDIR,
        // Outros
        USE, SHOW, DESCRIBE,
        // Tipos de dados
        INT, FLOAT, TEXT, BOOL,
        // Identificador
        IDENTIFIER,
        // Símbolos
        ABRE_PARENTESES, FECHA_PARENTESES, VIRGULA, PONTO_VIRGULA, ASTERISCO, EQUAL,
        // Número
        NUMBER,
        
        // FUNÇÕES
        PI, CEIL, FLOOR, POW, SQRT, 
    }