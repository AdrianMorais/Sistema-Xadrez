package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;

public class Rei extends Xadrez.PecaXadrez {
 
   public Rei(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override    
    public String toString() {
        
       return "K";
        
    } 
}
