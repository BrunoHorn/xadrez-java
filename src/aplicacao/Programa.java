package aplicacao;

import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partidaXadrez = new PartidaXadrez();
		
		while(true) {
		UI.imprimirTabuleiro(partidaXadrez.getPecas());
		System.out.println();
		System.out.print("Inicial: ");
		PosicaoXadrez inicial = UI.escrevendoPosicaoXadrez(sc);
		
		System.out.println();
		System.out.print("posição final: ");
		PosicaoXadrez finaal =UI.escrevendoPosicaoXadrez(sc);
		
		PecaXadrez capPecaXadrez = partidaXadrez.movimentarPecaXadrez(inicial, finaal);
		
		}
		
	
		
		

	}

}
