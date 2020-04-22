package tabuleiro.pecas;

import Xadrez.Cores;
import Xadrez.PartidaXadrez;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public class Peao extends Xadrez.PecaXadrez {

    private PartidaXadrez partidaXadrez;

    public Peao(Tabuleiro tabuleiro, Cores cor, PartidaXadrez partidaXadrez) {
        super(tabuleiro, cor);

        this.partidaXadrez = partidaXadrez;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0, 0);

        if (getCor() == Cores.BRANCO) {
            p.setValues(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() - 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p) && getTabuleiro().PosicaoExistente(p2) && !getTabuleiro().PecaExistente(p2) && getContadorMovimento() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }

            //enPassant
            if (posicao.getLinha() == 3) {
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if (getTabuleiro().PosicaoExistente(esquerda) && pecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partidaXadrez.getEnPassant()) {
                    mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if (getTabuleiro().PosicaoExistente(direita) && pecaOponente(direita) && getTabuleiro().peca(direita) == partidaXadrez.getEnPassant()) {
                    mat[direita.getLinha() - 1][direita.getColuna()] = true;
                }
            }
        } else {
            p.setValues(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() + 2, posicao.getColuna());
            Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
            if (getTabuleiro().PosicaoExistente(p) && !getTabuleiro().PecaExistente(p) && getTabuleiro().PosicaoExistente(p2) && !getTabuleiro().PecaExistente(p2) && getContadorMovimento() == 0) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
            if (getTabuleiro().PosicaoExistente(p) && pecaOponente(p)) {
                mat[p.getLinha()][p.getColuna()] = true;
            }
            //enPassant
            if (posicao.getLinha() == 4) {
                Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
                if (getTabuleiro().PosicaoExistente(esquerda) && pecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partidaXadrez.getEnPassant()) {
                    mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
                }
                Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
                if (getTabuleiro().PosicaoExistente(direita) && pecaOponente(direita) && getTabuleiro().peca(direita) == partidaXadrez.getEnPassant()) {
                    mat[direita.getLinha() + 1][direita.getColuna()] = true;
                }
            }                                      

            }

        
        return mat;
    }
}
