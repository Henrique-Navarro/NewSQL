/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsql;

/**
 *
 * @author henri
 */
import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int currentPosition;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentPosition = 0;
    }

    public void parse() {
        while (currentPosition < tokens.size()) {
            TokenType tokenType = tokens.get(currentPosition).tipo;
            switch (tokenType) {
                case CREATE:
                    parseCreateStatement();
                    break;
                case SELECT:
                    parseSelectStatement();
                    break;
                case INSERT:
                    parseInsertStatement();
                    break;
                case DELETE:    
                    parseDeleteStatement();
                    break;
                case UPDATE:
                    parseUpdateStatement();
                    break;
                case FROM:
                    parseFromClause();
                    break;
                // Adicionar casos para os demais tipos de token
                case PONTO_VIRGULA:
                    currentPosition++;
                    break;
                default:
                    currentPosition++;
                    TabelaService.selectTabela();
                    break;
            }
            //break;
        }
    }

    private void parseCreateStatement() {
        if (currentPosition + 1 < tokens.size()) {
            TokenType nextTokenType = tokens.get(currentPosition + 1).tipo;
            if (nextTokenType == TokenType.TABLE) {
                currentPosition += 2; // Avança para o token após "TABLE"
                parseIdentifier(); // Chama o método para analisar o identificador da tabela
                // Aqui você pode adicionar mais lógica, se necessário
            } else {
                // Tratar erro: token inesperado após "CREATE"
            }
        } else {
            // Tratar erro: fim inesperado do código após "CREATE"
        }
    }
    
    boolean nao_acabou(){
        return currentPosition < tokens.size();
    }
    
    //fazer funções assim para verificar o proximo token
    boolean check_IDENTIFIER(int posic){
        return tokens.get(posic).tipo == TokenType.IDENTIFIER;
    }
    
    private void parseIdentifier() {
        if (nao_acabou() && check_IDENTIFIER(currentPosition)) {
            //System.out.println("tabela de nome "+tokens.get(currentPosition).valor);
            String[] colunas = {"Nome", "Idade", "Cidade"};
            TabelaService.createTabela(colunas);            
        } else {
            // Tratar erro: esperado um identificador
        }
    }
    
    private void parseCreateTableStatement() {
        //String[] colunas = {"Nome", "Idade", "Cidade"};
       //TabelaService.createTabela(colunas);
        //System.out.print("tabela com nome de "+tokens.get(currentPosition));
    }

    private void parseSelectStatement() {
        // Implementar análise sintática para SELECT
    }

    private void parseInsertStatement() {
        // Implementar análise sintática para INSERT
    }

    private void parseDeleteStatement() {
        // Implementar análise sintática para DELETE
    }

    private void parseUpdateStatement() {
        // Implementar análise sintática para UPDATE
    }

    private void parseFromClause() {
        // Implementar análise sintática para FROM
    }
}
