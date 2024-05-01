package newsql;

public class Tabela {
    String[] colunas;
    String[][] dados;
    
    public Tabela(String[] colunas){
        this.colunas = colunas;
        this.dados = new String[0][colunas.length]; // Inicializa a matriz de dados com tamanho zero
        adicionarLinha(colunas);
    }
    
    // Método para adicionar uma linha de dados à tabela
    public void adicionarLinha(String[] linha) {
        if (linha.length != colunas.length) {
            System.out.println("Número incorreto de colunas na linha. A linha não será adicionada.");
            return;
        }
        
        // Cria uma nova matriz temporária com uma linha a mais
        String[][] novaMatriz = new String[dados.length + 1][colunas.length];
        
        // Copia os dados existentes para a nova matriz
        for (int i = 0; i < dados.length; i++) {
            novaMatriz[i] = dados[i];
        }
        
        // Adiciona a nova linha à matriz
        novaMatriz[dados.length] = linha;
        
        // Atualiza a matriz de dados
        dados = novaMatriz;
    }
    
    public void imprimirTabela() {
        // Imprime o cabeçalho da tabela
        for (String coluna : colunas) {
            System.out.print(coluna + "\t");
        }
        System.out.println(); // Nova linha após o cabeçalho
        
        // Imprime os dados da tabela
        for (String[] linha : dados) {
            for (String dado : linha) {
                System.out.print(dado + "\t");
            }
            System.out.println(); // Nova linha após cada linha de dados
        }
    }
}
