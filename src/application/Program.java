package application;

import java.util.Scanner;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch(); // crio o tabuleiro, inicio a partida
		
		while (true) {
			UI.printBoard(chessMatch.getPieces()); // UI -> User Interface // aqui formo o tabuleiro visualmente
			System.out.println(); // pulo uma linha
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target); // o source é a peça que está no tabuleiro que você escolhe pra se mover, target é pra onde você quer jogar ela
		}
	}

}
