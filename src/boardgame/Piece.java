package boardgame;

public abstract class Piece { // abstrata - classe que não pode ser instanciada, apenas herdada;  Por Exemplo: a nossa DefaultClass é abastrata, ela provém atributos e métodos comuns pra várias outras classes mas a mesma não pode ser instanciada

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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) { // um método concreto que utiliza um método abstrato. Isso se chama: Hook methods, método que faz um gancho com a subclasse.
		return possibleMoves()[position.getRow()][position.getColumn()]; // chama uma possível implementação de alguma subclasse concreta da classe Piece
	}
	
	public boolean isThereAnyPossibleMove() { // outra implementação concreta que necessita de um abstrato
		boolean[][] mat = possibleMoves(); // abstrato
		
		for (int i=0; i < mat.length; i++) {
			for (int j=0; j < mat.length; j++) {
				if (mat [i][j]) {
					return true;
				}
			}
		} 
		return false;
	}
}
