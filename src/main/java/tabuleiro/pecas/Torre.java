package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;


public class Torre extends Xadrez.PecaXadrez {
    
    public Torre(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override    
    public String toString() {
        
       return "T";
        
    }
    
}
