package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() { // cria uma matriz de booleanos da mesma dimens�o do tabuleiro; por padr�o todas as posi��es come�am com falso (null)
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}
}
