package Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.pecas.Bispo;
import tabuleiro.pecas.Cavalo;
import tabuleiro.pecas.Peao;
import tabuleiro.pecas.Rainha;
import tabuleiro.pecas.Rei;
import tabuleiro.pecas.Torre;
import tabuleiro.tabuleiroException;
import tabuleiro.Peca;
import Xadrez.PosicaoXadrez;

public class PartidaXadrez {

    private int turno;
    private Cores vezJogador;
    private Tabuleiro tabuleiro;
    private boolean check;
    private boolean checkMate;

    private List<Peca> pecasNoTabuleiro = new ArrayList<>();
    private List<Peca> pecasCapturadas = new ArrayList<>();

    public boolean getCheckMate() {
        return checkMate;
    }

    public int getTurno() {
        return turno;
    }

    public Cores getVezJogador() {
        return vezJogador;
    }

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        turno = 1;
        vezJogador = Cores.BRANCO;
        iniciarPartida();
    }

    public boolean getCheck() {
        return check;
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) {
        Posicao positao = posicaoOrigem.toPosition();
        validateOrigemPosition(positao);
        return tabuleiro.peca(positao).movimentosPossiveis();
    }

    public PecaXadrez movimentoPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {

        Posicao origem = posicaoOrigem.toPosition();
        Posicao destino = posicaoDestino.toPosition();
        validateOrigemPosition(origem);
        validateDestinoPosition(origem, destino);
        Peca pecaCapturada = fazerMovimento(origem, destino);

        if (testeCheck(vezJogador)) {
            desfazerMovimento(origem, destino, pecaCapturada);
            throw new XadrezException("Você não pode se colocar em xeque");
        }
        check = (testeCheck(oponente(vezJogador))) ? true : false;

        if (testeCheckMate(oponente(vezJogador))) {
            checkMate = true;
        } else {
            proximoTurno();
        }

        return (PecaXadrez) pecaCapturada;

    }

    private Peca fazerMovimento(Posicao origem, Posicao destino) {
        PecaXadrez p = (PecaXadrez) tabuleiro.removerPeca(origem);
        p.adicionarContadorMovimento();
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        if (pecaCapturada != null) {
            pecasNoTabuleiro.remove(pecaCapturada);
            pecasCapturadas.add(pecaCapturada);
        }

        if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(origemT);
            tabuleiro.colocarPeca(torre, destinoT);
            torre.adicionarContadorMovimento();
        }

        if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(origemT);
            tabuleiro.colocarPeca(torre, destinoT);
            torre.adicionarContadorMovimento();
        }

        return pecaCapturada;
    }

    private void desfazerMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
        PecaXadrez p = (PecaXadrez) tabuleiro.removerPeca(destino);
        p.removerContadorMovimento();
        tabuleiro.colocarPeca(p, origem);
        if (pecaCapturada != null) {
            pecasNoTabuleiro.add(pecaCapturada);
            pecasCapturadas.remove(pecaCapturada);
        }

        if (p instanceof Rei && destino.getColuna() == origem.getColuna() + 2) {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() + 3);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() + 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(destinoT);
            tabuleiro.colocarPeca(torre, origemT);
            torre.removerContadorMovimento();
        }

        if (p instanceof Rei && destino.getColuna() == origem.getColuna() - 2) {
            Posicao origemT = new Posicao(origem.getLinha(), origem.getColuna() - 4);
            Posicao destinoT = new Posicao(origem.getLinha(), origem.getColuna() - 1);
            PecaXadrez torre = (PecaXadrez) tabuleiro.removerPeca(destinoT);
            tabuleiro.colocarPeca(torre, origemT);
            torre.removerContadorMovimento();
        }
    }

    public void validateOrigemPosition(Posicao posicao) {
        if (!tabuleiro.PecaExistente(posicao)) {
            throw new tabuleiroException("Nao existe peca na posicao de origem");
        }
        if (vezJogador != ((PecaXadrez) tabuleiro.peca(posicao)).getCor()) {
            throw new tabuleiroException("A peca escolhida nao e sua");
        }
        if (!tabuleiro.peca(posicao).verificandoMovimento()) {
            throw new tabuleiroException("Não existe movimentos possiveis para a peça escolhida");
        }

    }

    public void validateDestinoPosition(Posicao origem, Posicao destino) {
        if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
            throw new tabuleiroException("A peca escolhida não pode se mover para a peca de destino");
        }
    }

    private void proximoTurno() {
        turno++;
        vezJogador = (vezJogador == Cores.BRANCO) ? Cores.PRETO : Cores.BRANCO;
    }

    private Cores oponente(Cores cor) {
        return (cor == Cores.BRANCO) ? Cores.PRETO : Cores.BRANCO;
    }

    private PecaXadrez rei(Cores cor) {
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor).collect(Collectors.toList());
        for (Peca p : list) {
            if (p instanceof Rei) {
                return (PecaXadrez) p;
            }
        }
        throw new IllegalStateException("Nao existe o rei " + cor + "no tabuleiro");
    }

    private boolean testeCheck(Cores cor) {
        Posicao posicaoRei = rei(cor).getPosicaoXadrez().toPosition();
        List<Peca> pecaOponente = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == oponente(cor)).collect(Collectors.toList());
        for (Peca p : pecaOponente) {
            boolean[][] mat = p.movimentosPossiveis();
            if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
                return true;
            }
        }
        return false;
    }

    private boolean testeCheckMate(Cores cor) {
        if (!testeCheck(cor)) {
            return false;
        }
        List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == oponente(cor)).collect(Collectors.toList());
        for (Peca p : list) {
            boolean[][] mat = p.movimentosPossiveis();
            for (int i = 0; i < 0; i++) {
                for (int j = 0; j < 0; j++) {
                    if (mat[i][j]) {
                        Posicao origem = ((PecaXadrez) p).getPosicaoXadrez().toPosition();
                        Posicao destino = new Posicao(i, j);
                        Peca pecaCapturada = fazerMovimento(origem, destino);
                        boolean testeCheck = testeCheck(cor);
                        desfazerMovimento(origem, destino, pecaCapturada);
                        if (!testeCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void NovaPeca(char coluna, int linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosition());
        pecasNoTabuleiro.add(peca);
    }

    private void iniciarPartida() {

        NovaPeca('h', 1, new Torre(tabuleiro, Cores.BRANCO));
        NovaPeca('a', 1, new Torre(tabuleiro, Cores.BRANCO));
        NovaPeca('e', 1, new Rei(tabuleiro, Cores.BRANCO, this));
        
         NovaPeca('a', 6, new Rei(tabuleiro, Cores.PRETO, this));
        
    }

}
