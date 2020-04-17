package Xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;
import tabuleiro.Posicao;

public abstract class PecaXadrez extends Peca {

    public Cores getCor() {
        return cor;
    }

    private Cores cor;
    private int contadorMovimento;
    
    
    protected void adicionarContadorMovimento() {
        contadorMovimento++;
    }
    
   protected void removerContadorMovimento() {
       contadorMovimento--;
   }
    
   public int getContadorMovimento() {
       return contadorMovimento;
   }
   
    public PecaXadrez(Tabuleiro tabuleiro, Cores cor) {
        super(tabuleiro);

        this.cor = cor;
    }
    
    protected boolean pecaOponente(Posicao posicao) {
        PecaXadrez p = (PecaXadrez) getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;

    }
    
    public PosicaoXadrez getPosicaoXadrez() {
        return PosicaoXadrez.fromPosition(posicao);
    }
    
}
