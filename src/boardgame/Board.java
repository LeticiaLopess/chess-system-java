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
	
	public Piece piece(Position position) { //  recebe as coordenadas de uma posição no tabuleiro e retorna a peça localizada nessa posição no tabuleiro. 
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) { // Este método sobrecarrega o método anterior, permitindo que você forneça uma instância de Position em vez de coordenadas separadas. Ele usa o método getRow() e getColumn() da classe Position para obter as coordenadas e, em seguida, retorna a peça na posição correspondente no tabuleiro.
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position; // classe Board é do mesmo pacote e como position é protected eu posso acessar diretamente
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		if (piece(position) == null) { // não há peça nessa posição
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux; // contém a peça que foi retirada
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
