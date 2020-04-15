package Program;

import Xadrez.PecaXadrez;


public class Interface {
    
    public static void mostrarTabuleiro(PecaXadrez[][] pecas) {
 
        for(int i = 0; i < pecas.length; i++){
            System.err.print((8 - i) + " ");
            for(int j = 0; j < pecas.length; j++) {
               mostrarPeca(pecas[i][j]); 
            }
            System.err.println();
        }
        System.err.println("  a b c d e f g h");
        
    }
    
    private static void mostrarPeca(PecaXadrez peca) {
        if(peca == null) {
            System.err.print("- ");
        }
        else {
            System.err.print(peca+" ");
        }
            
    }
    
}
