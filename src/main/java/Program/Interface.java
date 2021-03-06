package Program;

import Xadrez.PecaXadrez;
import Xadrez.Cores;
import Xadrez.PartidaXadrez;
import Xadrez.PosicaoXadrez;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Interface {

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console 
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static PosicaoXadrez lerPosicaoPeca(Scanner sc) {
        try {
            String s = sc.nextLine();
            char coluna = s.charAt(0);
            int linha = Integer.parseInt(s.substring(1));
            return new PosicaoXadrez(coluna, linha);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Erro");
        }
    }

    public static void mostrarTabuleiro(PecaXadrez[][] pecas) {

        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                mostrarPeca(pecas[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");

    }

     public static void mostrarTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis) {

        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                mostrarPeca(pecas[i][j], movimentosPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");

    }
    
     public static void mostrarPartida(PartidaXadrez partidaXadrez, List<PecaXadrez> capturadas) {
         mostrarTabuleiro(partidaXadrez.getPecas());
         System.out.println();
         mostrarPecasCapturadas(capturadas);
         System.out.println();                                          
         System.out.println("Turno: " + partidaXadrez.getTurno());
         if(!partidaXadrez.getCheckMate()) { 
         System.out.println("Esperando jogador: " + partidaXadrez.getVezJogador());
         if(partidaXadrez.getCheck()) {
             System.out.println("CHECK");
         }       
         }else {
             System.out.println("CHECKMATE!");
             System.out.println("Ganhador: "+ partidaXadrez.getVezJogador());
         }
     }
    
     
     private static void mostrarPecasCapturadas(List<PecaXadrez> capturadas) {
         List<PecaXadrez> branco = capturadas.stream().filter(x -> x.getCor() == Cores.BRANCO).collect(Collectors.toList());
         List<PecaXadrez> preto = capturadas.stream().filter(x -> x.getCor() == Cores.PRETO).collect(Collectors.toList());
         
         System.out.println("Pecas capturadas");  
         System.out.print("Brancas: ");
         System.out.print(ANSI_WHITE);
         System.out.println(Arrays.toString(branco.toArray()));
         System.out.print(ANSI_RESET);
         System.out.print("Pretas: ");
         System.out.print(ANSI_YELLOW);
         System.out.println(Arrays.toString(preto.toArray()));
         System.out.print(ANSI_RESET);
         
     }
     
    private static void mostrarPeca(PecaXadrez peca,boolean background) {
        if(background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null) {
            System.out.print("- " + ANSI_RESET);
        } else {

            if (peca.getCor() == Cores.BRANCO) {
                System.out.print(ANSI_WHITE + peca + " " + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + peca + " " + ANSI_RESET);
            }

        }

    }

}
