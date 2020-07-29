package xadrez;

import camadaTabuleiro.Peca;
import camadaTabuleiro.Posicao;
import camadaTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		
		tabuleiro = new Tabuleiro(8,8);
		inicialSetup();
		
	}
	
	public PecaXadrez [][] getPecas(){
		
		PecaXadrez [][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0;i<tabuleiro.getLinhas();i++) {
			for(int j=0;j<tabuleiro.getColunas();j++) {
				mat[i][j]= (PecaXadrez)  tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	public PecaXadrez movimentarPecaXadrez(PosicaoXadrez posicaoInicial,PosicaoXadrez posicaoFinal) {
		
		Posicao inicial= posicaoInicial.paraPosicao();
		Posicao finaal = posicaoFinal.paraPosicao();
		validacaoPosicaoInicial (inicial);		
		Peca capturaPeca =  movimento (inicial,finaal);
		return (PecaXadrez)capturaPeca ;
		
		}
	
	private Peca movimento(Posicao inicial,Posicao finaal) {
		Peca p = tabuleiro.removePeca(inicial);
		Peca pecaCapturada = tabuleiro.removePeca(finaal);
		tabuleiro.colocarPeca(p, finaal);
		return pecaCapturada;
	}
	
	
	
	
	
	private void validacaoPosicaoInicial (Posicao posicao) {
		if (!tabuleiro.haPeca(posicao)) {
			throw  new ExcessaoXadez ("Não a peças nessa posição");
		}
	}
	
	private void lugarNovaPeca(char coluna,int linha,PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
	}
	
	public void inicialSetup() {
		lugarNovaPeca('c',1,new Torre(tabuleiro,Cor.BRANCO));
		lugarNovaPeca('c',2,new Torre(tabuleiro,Cor.BRANCO));
		lugarNovaPeca('d',2,new Torre(tabuleiro,Cor.BRANCO));
		lugarNovaPeca('e',2,new Torre(tabuleiro,Cor.BRANCO));
		lugarNovaPeca('e',1,new Torre(tabuleiro,Cor.BRANCO));
		lugarNovaPeca('d',1,new Rei(tabuleiro,Cor.BRANCO));
		
		lugarNovaPeca('c',7,new Torre(tabuleiro,Cor.PRETO));
		lugarNovaPeca('c',8,new Torre(tabuleiro,Cor.PRETO));
		lugarNovaPeca('d',7,new Torre(tabuleiro,Cor.PRETO));
		lugarNovaPeca('e',8,new Torre(tabuleiro,Cor.PRETO));
		lugarNovaPeca('e',7,new Torre(tabuleiro,Cor.PRETO));
		lugarNovaPeca('d',8,new Rei(tabuleiro,Cor.PRETO));
		
		
		
	}
	
}
