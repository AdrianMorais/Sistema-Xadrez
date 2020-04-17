package tabuleiro.pecas;

import Xadrez.Cores;
import Xadrez.PecaXadrez;
import tabuleiro.Posicao;

import tabuleiro.Tabuleiro;

public class Rei extends Xadrez.PecaXadrez {
 
   public Rei(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro, cor);
    }
    
    @Override    
    public String toString() {
        
       return "K";
        
    } 
    
    
    private boolean podeMover(Posicao posicao) {
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }
    
    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
    
       Posicao p = new Posicao(0, 0);
       
       p.setValues(posicao.getLinha() - 1, posicao.getColuna());
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() + 1, posicao.getColuna());
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() , posicao.getColuna() - 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() + 1 , posicao.getColuna() + 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() - 1 , posicao.getColuna() - 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() + 1 , posicao.getColuna() - 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       p.setValues(posicao.getLinha() - 1 , posicao.getColuna() + 1);
       if(getTabuleiro().PosicaoExistente(p) && podeMover(p)) {
           mat[p.getLinha()][p.getColuna()] = true;
       }
       
       return mat; 
      
    }
}
