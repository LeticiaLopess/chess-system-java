package chess;

import boardgame.Position;

public class ChessPosition {

	private char column; // outro sistema de coordenadas
	private int row;
	

	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			new ChessException("Error instantiating ChessPosition. Valis values are from a1 to h8.");
		}
			
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row; // a string vazia � um macete pra compilar automaticamente, se tirarmos o compilador n�o vai aceitar, colocamos para fazer o compilador entender que � uma concatena��o de strings
	}
	
	// a posi��o da linha da matriz que correspondente ao tabuleiro � feito da subtra��o do 8 com a posi��o atual da pe�a.
	// posi��o a8 -> 8 - 8 = (0, 0) na matriz
	// matrix_row = 8 - chess_row
	// matrix_column = chess_column - 'a'
	// se eu pegar o c�digo unicode de cada letra e subtrair:   'a' - 'a' = 0;   ou   'b' - 'a' = 1

}
