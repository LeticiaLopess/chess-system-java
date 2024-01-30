package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() { // cria uma matriz de booleanos da mesma dimens�o do tabuleiro; por padr�o todas as posi��es come�am com falso (null)
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// acima
		p.setValues(position.getRow() - 1, position.getColumn());
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
	}
}
