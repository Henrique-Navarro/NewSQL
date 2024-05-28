package newsql;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author henri
 */
public class Main {
    public static void main(String[] args)
    {
        try{
           String query = "CREATE TABLE tabelinha USE SELECT * FROM table1 WHERE column1 = 123 "+
                "INSERT DELETE UPDATE FROM WHERE GROUP_BY ORDER_BY LIMIT DISTINCT CREATE ALTER DROP "+
                "AND OR NOT NULL TRUE FALSE IF "+
                "USE SHOW DESCRIBE "+
                "INT FLOAT TEXT BOOL "+
                "tabela ( ) , ; * 12 12.319 & ! teste123 123teste";
        
        
        
            query = "CREATE AND and TABLE tabela_teste(coluna int) 10 10.23 10.09 ; Pow POW() pow";

            ArrayList<Token>tokens = Lexer.tokenize(query);
            Parser parser = new Parser(tokens);
            parser.parse(); 
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
