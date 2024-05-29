/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import Token.Token;

/**
 *
 * @author henri
 */
public class ParseError extends RuntimeException {
    
    // TODO: adicionar atributo line no token
    public ParseError (Token token, String message) {
        super("Error at '" + token.getValue() +"': " + message);
    }
}
