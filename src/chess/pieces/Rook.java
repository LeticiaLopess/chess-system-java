package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	@Override
	public boolean[][] possibleMoves() { // cria uma matriz de booleanos da mesma dimensão do tabuleiro; por padrão todas as posições começam com falso (null)
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0); 
		
		// acima
		p.setValues(position.getRow() - 1, position.getColumn()); // position.getRow() - 1 -> uma linha acima da linha atual da peça
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		
		// teste se tem alguma peça adversária à frente da direção que está indo
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// esquerda
		p.setValues(position.getRow(), position.getColumn() - 1); // position.getRow() - 1 -> uma linha acima da linha atual da peça
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1); // agora a coluna que vai andar
		}
		
		// teste se tem alguma peça adversária à frente da direção que está indo
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// direita
		p.setValues(position.getRow(), position.getColumn() + 1); // position.getRow() - 1 -> uma linha acima da linha atual da peça
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1); // a coluna que vai andar
		}
		
		// teste se tem alguma peça adversária à frente da direção que está indo
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// abaixo
		p.setValues(position.getRow() + 1, position.getColumn()); // position.getRow() - 1 -> uma linha acima da linha atual da peça
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		
		// teste se tem alguma peça adversária à frente da direção que está indo
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
	}

}
