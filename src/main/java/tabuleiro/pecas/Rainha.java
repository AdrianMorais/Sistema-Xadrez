package tabuleiro.pecas;

import Xadrez.Cores;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Rainha extends Xadrez.PecaXadrez {
    
    public Rainha(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override
    public String toString() {       
      return "R";                  
    }    

    @Override
    public boolean[][] movimentosPossiveis() {
       boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
       
       Posicao p = new Posicao(0, 0);

        // Cima
        p.setValues(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        // Baixo
        p.setValues(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() + 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        // Esquerda
        p.setValues(posicao.getLinha() , posicao.getColuna() - 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Direita
        p.setValues(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() + 1);
        }
        if(getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
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
