/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

/**
 *
 * @author henri
 */
public class Token {
    public String valor;
    public TokenType tipo;
    
    Token(String valor, TokenType tipo){
        this.valor = valor;
        this.tipo = tipo;
    }
}
