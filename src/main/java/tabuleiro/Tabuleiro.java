package tabuleiro;

public class Tabuleiro {

    public int getLinha() {
        return linha;
    }
    
    public int getColuna() {
        return coluna;
    }
       
    private int linha;
    private int coluna;
    private Peca[][] pecas;
    
    public Tabuleiro(int linha, int coluna) {
    
    this.linha = linha;
    this.coluna = coluna;
    
    pecas = new Peca[linha][coluna];
    
    }
    
    
    public Peca peca(int linha, int coluna) {
        if(!PosicaoExistente(linha,coluna)){
         throw new tabuleiroException("Posicao Inexistente");
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
         throw new tabuleiroException("Peça ja existente na posicao: " + posicao);  
       }
        
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
       peca.posicao = posicao;
    }
    
    public boolean PosicaoExistente(int linha, int coluna){
       return linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna;       
    }
    
    public boolean PosicaoExistente(Posicao posicao){
      return PosicaoExistente(posicao.getLinha() , posicao.getColuna());
    }
     
    public boolean PecaExistente(Posicao posicao) {
        if(!PosicaoExistente(posicao)){
         throw new tabuleiroException("Posição Inexistente");
        }
        return peca(posicao) != null;    
    }
    
}
