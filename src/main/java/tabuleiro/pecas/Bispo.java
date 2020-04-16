package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;

public class Bispo extends Xadrez.PecaXadrez {
    
    public Bispo(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString() {        
        return "B";        
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
        return mat;
    }
    
}
