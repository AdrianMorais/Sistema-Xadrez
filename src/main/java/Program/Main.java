package Program;

import Xadrez.PartidaXadrez;
import Xadrez.PecaXadrez;
import java.util.Scanner;
import Xadrez.PosicaoXadrez;
import Xadrez.XadrezException;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import tabuleiro.tabuleiroException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        List<PecaXadrez> capturadas = new ArrayList<>();
        
        
        while (!partida.getCheckMate()) {
            try {
                Interface.clearScreen();
                Interface.mostrarPartida(partida, capturadas);
                
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
                
                if(pecaCapturada != null) {
                    capturadas.add(pecaCapturada);
                }
                
            } catch (XadrezException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (tabuleiroException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } 
        }
        Interface.clearScreen();
        Interface.mostrarPartida(partida, capturadas);
    }

}
