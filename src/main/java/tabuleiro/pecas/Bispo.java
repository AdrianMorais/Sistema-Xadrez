package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Posicao;
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
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Posicao p = new Posicao(0, 0);
        
        p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha() - 1, p.getColuna() - 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha() - 1, p.getColuna() + 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha() + 1, p.getColuna() + 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha() + 1, p.getColuna() - 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        return mat;
    }
    
}
