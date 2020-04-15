package Xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

    public int getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }
  
    private int linha;
    private char coluna;
    
    public PosicaoXadrez(int linha, char coluna) {
    if(coluna < 'a' && coluna > 'h' && linha < 1 && linha > 8){
        throw new XadrezException("Posição fora do tabuleiro");
    }
        
        this.linha = linha;
        this.coluna = coluna;
                        
    }
 
    public Posicao toPosition() {
       return new Posicao(8 - linha, coluna - 'a');        
    }
    
    protected static PosicaoXadrez fromPosition(Posicao posicao){
       return new PosicaoXadrez(8 - posicao.getLinha(),(char)('a' - posicao.getColuna()));        
    }
    
    @Override
    public String toString() {
        return "" + coluna + linha;
    }
    
}
