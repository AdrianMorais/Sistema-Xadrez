package Xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.pecas.Bispo;
import tabuleiro.pecas.Cavalo;
import tabuleiro.pecas.Peao;
import tabuleiro.pecas.Rainha;
import tabuleiro.pecas.Rei;
import tabuleiro.pecas.Torre;
import tabuleiro.tabuleiroException;
import tabuleiro.Peca;

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
    
    public PecaXadrez movimentoPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
        
        Posicao origem = posicaoOrigem.toPosition();
        Posicao destino = posicaoDestino.toPosition();
        
        validateOrigemPosition(origem);
        Peca pecaCapturada = fazerMovimento(origem,destino);
        return (PecaXadrez)pecaCapturada;
        
    }
    
    private Peca fazerMovimento(Posicao origem, Posicao destino) {
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }
    
    public void validateOrigemPosition(Posicao posicao) {
        if(!tabuleiro.PecaExistente(posicao)) {
            throw new tabuleiroException("Não existe peça na posição de origem");
        }
       
    }
    
    private void NovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(linha,coluna).toPosition());
    }
    
    private void iniciarPartida() {
        
        //Peão Branco
        NovaPeca('a', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('b', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('c', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('d', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('e', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('f', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('g', 2, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('h', 2, new Peao(tabuleiro, Cores.BRANCO));
        
        //Torres Branca
        NovaPeca('a', 1, new Torre(tabuleiro, Cores.BRANCO));
        NovaPeca('h',1, new Torre(tabuleiro, Cores.BRANCO));
        
        //Rei Branco
        NovaPeca('e',1, new Rei(tabuleiro, Cores.BRANCO)); 
        
        //Rainha Branca
        NovaPeca('d',1, new Rainha(tabuleiro, Cores.BRANCO));
        
        //Cavalos Brancos
        NovaPeca('b', 1, new Cavalo(tabuleiro, Cores.BRANCO));
        NovaPeca('g', 1, new Cavalo(tabuleiro, Cores.BRANCO));
        
        //Bispos brancos
        NovaPeca('c', 1, new Bispo(tabuleiro, Cores.BRANCO));
        NovaPeca('f', 1, new Bispo(tabuleiro, Cores.BRANCO));
        
        
        //Peão Preto       
        NovaPeca('a', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('b', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('c', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('d', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('e', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('f', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('g', 7, new Peao(tabuleiro, Cores.BRANCO));
        NovaPeca('h', 7, new Peao(tabuleiro, Cores.BRANCO));
        
        //Torres Branca
        NovaPeca('a', 8, new Torre(tabuleiro, Cores.BRANCO));
        NovaPeca('h',8, new Torre(tabuleiro, Cores.BRANCO));
        
        //Rei Branco
        NovaPeca('e',8, new Rei(tabuleiro, Cores.BRANCO)); 
        
        //Rainha Branca
        NovaPeca('d',8, new Rainha(tabuleiro, Cores.BRANCO));
        
        //Cavalos Brancos
        NovaPeca('b', 8, new Cavalo(tabuleiro, Cores.BRANCO));
        NovaPeca('g', 8, new Cavalo(tabuleiro, Cores.BRANCO));
        
        //Bispos brancos
        NovaPeca('c', 8, new Bispo(tabuleiro, Cores.BRANCO));
        NovaPeca('f', 8, new Bispo(tabuleiro, Cores.BRANCO));
        
        
    }
    
}
