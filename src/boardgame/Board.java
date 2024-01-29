package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { //  recebe as coordenadas de uma posi��o no tabuleiro e retorna a pe�a localizada nessa posi��o no tabuleiro. 
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) { // Este m�todo sobrecarrega o m�todo anterior, permitindo que voc� forne�a uma inst�ncia de Position em vez de coordenadas separadas. Ele usa o m�todo getRow() e getColumn() da classe Position para obter as coordenadas e, em seguida, retorna a pe�a na posi��o correspondente no tabuleiro.
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // classe Board � do mesmo pacote e como position � protected eu posso acessar diretamente
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		if (piece(position) == null) { // n�o h� pe�a nessa posi��o
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux; // cont�m a pe�a que foi retirada
	}
	
	private boolean positionExists(int row, int column) { // pra existir: precisa estar dentro do tabuleiro, row ou column precisa ser menor do que a altura do tabuleiro (rows || columns)
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null;
	}
}
