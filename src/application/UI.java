package application;

import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i<pieces.length; i++) { // linhas
			
			System.out.print((8 - i) + " "); // vai imprimir os números do 8 ao 1 do canto esquerdo
			
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("  a b c d e f g h"); // vai imprimir as letras de a até h da parte de baixo do tabuleiro
	}
	
	private static void printPiece(ChessPiece piece) {
		
		if (piece == null) {
			System.out.print("-");
			
		} else {
			System.out.print(piece);
		}
		
		System.out.print(" ");
	}
}
