package Program;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import java.util.Scanner;
import Xadrez.PosicaoXadrez;

public class Main {

 
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        
        
        
        while (true) {
            Interface.mostrarTabuleiro(partida.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoXadrez origem = Interface.lerPosicaoPeca(sc);
        
            System.out.println();
            System.out.print("Destino: ");
            PosicaoXadrez destino = Interface.lerPosicaoPeca(sc);
            
            PecaXadrez pecaCapturada = partida.movimentoPeca(origem, destino);
        }
        
    }
    
}
