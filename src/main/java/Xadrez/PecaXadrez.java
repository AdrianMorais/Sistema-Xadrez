package Xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {

    public Cores getCor() {
        return cor;
    }
    
    private Cores cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro);
        
        this.cor = cor;
    }
    
   
}
