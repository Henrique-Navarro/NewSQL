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
    private List<TokenType> tokens;
    private int currentPosition;

    public Parser(List<TokenType> tokens) {
        this.tokens = tokens;
        this.currentPosition = 0;
    }

    public void parse() {
        while (currentPosition < tokens.size()) {
            TokenType tokenType = tokens.get(currentPosition);
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
                default:
                    // Tratar erro: token inesperado
                    break;
            }
        }
    }

    private void parseCreateStatement() {
        if (currentPosition + 1 < tokens.size()) {
            TokenType nextTokenType = tokens.get(currentPosition + 1);
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
    
    private void parseIdentifier() {
        if (currentPosition < tokens.size() && tokens.get(currentPosition) == TokenType.IDENTIFIER) {
            System.out.println("tabelinha de nome "+tokens.get(currentPosition));
        } else {
            // Tratar erro: esperado um identificador
        }
    }
    
    private void parseCreateTableStatement() {
            
        System.out.print("tabela com nome de "+tokens.get(currentPosition));
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
