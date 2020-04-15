package Xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.pecas.Rei;
import tabuleiro.pecas.Torre;

public class PartidaXadrez {
  
    private Tabuleiro tabuleiro;
    
    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8,8);
        iniciarPartida();
    }
    
    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
        for (int i = 0; i < tabuleiro.getLinha(); i++) {
            for(int j = 0; j < tabuleiro.getColuna(); j++){
                mat[i][j] = (PecaXadrez)tabuleiro.peca(i , j);
            }
        }
        return mat;
    }
    
    private void iniciarPartida() {
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cores.BRANCO), new Posicao(7, 7));
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cores.BRANCO), new Posicao(7, 0));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cores.BRANCO), new Posicao(7 , 4));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cores.PRETO), new Posicao(0, 4));
        
    }
    
}
