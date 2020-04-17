package Program;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import java.util.Scanner;
import Xadrez.PosicaoXadrez;
import Xadrez.XadrezException;
import java.util.InputMismatchException;
import tabuleiro.tabuleiroException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();

        
        
        while (true) {
            try {
                Interface.clearScreen();
                Interface.mostrarPartida(partida);
                
                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = Interface.lerPosicaoPeca(sc);
                
                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
                Interface.clearScreen();
                Interface.mostrarTabuleiro(partida.getPecas(), movimentosPossiveis);
                
                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = Interface.lerPosicaoPeca(sc);

                PecaXadrez pecaCapturada = partida.movimentoPeca(origem, destino);                               
            } catch (XadrezException e) {
                e.getMessage();
            } catch (InputMismatchException e) {
                e.getMessage();
            }
        }

    }

}
