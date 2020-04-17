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
        System.err.println("sdgas");
        PartidaXadrez partida = new PartidaXadrez();

        
        
        while (true) {
            try {
                Interface.clearScreen();
                Interface.mostrarTabuleiro(partida.getPecas());
                
                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = Interface.lerPosicaoPeca(sc);

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
