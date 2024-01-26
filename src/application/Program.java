package application;

import boardgame.Board;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch(); // crio o tabuleiro
		UI.printBoard(chessMatch.getPieces()); // UI -> User Interface // aqui formo o tabuleiro visualmente
	}

}
