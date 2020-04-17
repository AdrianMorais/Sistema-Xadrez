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
    
    public PosicaoXadrez(char coluna,int linha) {
    if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
        throw new XadrezException("Posicao fora do tabuleiro");
    }
        
        this.linha = linha;
        this.coluna = coluna;
                        
    }
 
    public Posicao toPosition() {
       return new Posicao(8 - linha, coluna - 'a');        
    }
    
    protected static PosicaoXadrez fromPosition(Posicao posicao){
       return new PosicaoXadrez((char)('a' + posicao.getColuna()), 8 - posicao.getLinha());        
    }
            
    @Override
    public String toString() {
        return "" + coluna + linha;
    }
    
}
