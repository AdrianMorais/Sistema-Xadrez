package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;

public class Cavalo extends Xadrez.PecaXadrez {
    
    public Cavalo(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString() {        
        return "C";
    }
    
}
