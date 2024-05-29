/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author henri
 */
public class IllegalCharacter extends Exception {
    
    public IllegalCharacter (String token) {
        super("Sintax Error - illegal character '" + token +"'");
    }
}
