package tabuleiro;

public abstract class Peca {
   
    protected Posicao posicao;
    protected Tabuleiro tabuleiro;
    
    public Peca(Tabuleiro tabuleiro) {
        
        this.tabuleiro = tabuleiro;
        posicao = null;
        
    }
    
    protected Tabuleiro getTabuleiro() {       
 
        return tabuleiro;
        
    }
    
    public abstract boolean[][] movimentosPossiveis();      
    
    public boolean movimentoPossivel(Posicao posicao) {    
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];        
    }
    
    public boolean verificandoMovimento() {
        boolean[][] mat = movimentosPossiveis();
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++){
                if(mat[i][j] == true){
                    return true;
                }
                    
                }
            }
        return false;
        }
    
    
}
