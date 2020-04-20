package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Posicao;
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
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        if (getCor() == Cores.BRANCO) {
            p.setValues(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p) && getTabuleiro().PosicaoExistente(p2) && getTabuleiro().PecaExistente(p2) && getContadorMovimento() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
        }
        else {
           p.setValues(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p) && getTabuleiro().PosicaoExistente(p2) && getTabuleiro().PecaExistente(p2) && getContadorMovimento() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true; 
        }
        }
        return mat;
    }
    
}
