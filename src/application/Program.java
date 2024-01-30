package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch(); // crio o tabuleiro, inicio a partida
		List<ChessPiece> captured = new ArrayList<>();
		
		while (true) {
			
			try {
				
				UI.clearScreen();
				UI.printMatch(chessMatch, captured); // UI -> User Interface // aqui formo o tabuleiro visualmente
				System.out.println(); // pulo uma linha
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves); // imprime o tabuleiro colorindo as posi��es poss�veis
				
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target); // o source � a pe�a que est� no tabuleiro que voc� escolhe pra se mover, target � pra onde voc� quer jogar ela
			
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
			} catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
	}

}
