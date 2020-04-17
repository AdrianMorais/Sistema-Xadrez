package tabuleiro;

public class Tabuleiro {

    public int getLinhas() {
        return linhas;
    }
    
    public int getColunas() {
        return colunas;
    }
       
    private int linhas;
    private int colunas;
    private Peca[][] pecas;
    
    public Tabuleiro(int linhas, int colunas) {
    if(linhas < 1 || colunas < 1) {
        throw new tabuleiroException("Erro ao criar o tabuleiro");
    }
    this.linhas = linhas;
    this.colunas = colunas;
    
    pecas = new Peca[linhas][colunas];
    
    }
    
    
    public Peca peca(int linha, int coluna) {
        if(!PosicaoExistente(linha,coluna)){
         throw new tabuleiroException("Posicao nao esta no tabuleiro");
        }
        return pecas[linha][coluna];   
    }
    
    public Peca peca(Posicao posicao) {
        if(!PosicaoExistente(posicao)){
         throw new tabuleiroException("Posicao Inexistente");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];   
    }
    
    public void colocarPeca(Peca peca, Posicao posicao) {
       if(PecaExistente(posicao)){
         throw new tabuleiroException("Peca ja existente na posicao: " + posicao);  
       }
        
       pecas[posicao.getLinha()][posicao.getColuna()] = peca;
       peca.posicao = posicao;
    }
    
    public Peca removerPeca(Posicao posicao) {
        if(!PosicaoExistente(posicao)) {
          throw new tabuleiroException("Posicao Inexistente");  
        }
        if(peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
    
    
    public boolean PosicaoExistente(int linha, int coluna){
       return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;       
    }
    
    public boolean PosicaoExistente(Posicao posicao){
      return PosicaoExistente(posicao.getLinha(), posicao.getColuna());
    }
     
    public boolean PecaExistente(Posicao posicao) {
        if(!PosicaoExistente(posicao)){
        throw new tabuleiroException("Posicao nao esta no tabuleiro");
        }
        return peca(posicao) != null;    
    }
    
}
