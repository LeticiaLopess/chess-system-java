package boardgame;

public class Piece {

	protected Position position; // #position: Position -> tem uma posição protegida, não é pra essa posição ser visível na camada de xadrez, por isso é protected
	private Board board;
	
	public Piece(Board board) { // passamos apenas o tabuleiro ao criar a peça pois a posição recém criada será inicialmente como nula
		super();
		this.board = board;
		/*position = null;*/ // se eu não colocasse aqui, o java já iria atribuir null
	}

	protected Board getBoard() { // somente classes dentro do mesmo pacote e subclasses vão poder acessar o tabuleiro de uma peça
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
}
