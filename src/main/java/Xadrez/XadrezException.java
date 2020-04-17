package Xadrez;

import tabuleiro.tabuleiroException;

public class XadrezException extends tabuleiroException {
    private static final long serialVersionUID = 1L;
    
    XadrezException(String msg) {
        super(msg);
    }
    
}
