package boardgame;

public class Piece {

	protected Position position; // #position: Position -> tem uma posi��o protegida, n�o � pra essa posi��o ser vis�vel na camada de xadrez, por isso � protected
	private Board board;
	
	public Piece(Board board) { // passamos apenas o tabuleiro ao criar a pe�a pois a posi��o rec�m criada ser� inicialmente como nula
		super();
		this.board = board;
		/*position = null;*/ // se eu n�o colocasse aqui, o java j� iria atribuir null
	}

	protected Board getBoard() { // somente classes dentro do mesmo pacote e subclasses v�o poder acessar o tabuleiro de uma pe�a
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
}
