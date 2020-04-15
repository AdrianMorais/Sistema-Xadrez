package Program;

import Xadrez.PartidaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Main {

 
    public static void main(String[] args) {
      
        PartidaXadrez partida = new PartidaXadrez();
        Interface.mostrarTabuleiro(partida.getPecas());
        
    }
    
}
