package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Tabuleiro;

public class Peao extends Xadrez.PecaXadrez {
    
    public Peao(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString() {       
        return "P";       
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
        return mat;
    }
    
}
