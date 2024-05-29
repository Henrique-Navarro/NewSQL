/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

/**
 *
 * @author henri
 */

//interface para manipular tabela
public class TabelaService {
    
   static Tabela tabela;
    
    public static Tabela createTabela(String[]colunas){
        tabela = new Tabela(colunas);
        //tabela.imprimirTabela();
        return tabela;
    }
    
    public static void selectTabela(){
        tabela.imprimirTabela();
    }
}
