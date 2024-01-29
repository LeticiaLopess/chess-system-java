package boardgame;

public abstract class Piece { // abstrata - classe que n�o pode ser instanciada, apenas herdada;  Por Exemplo: a nossa DefaultClass � abastrata, ela prov�m atributos e m�todos comuns pra v�rias outras classes mas a mesma n�o pode ser instanciada

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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) { // um m�todo concreto que utiliza um m�todo abstrato. Isso se chama: Hook methods, m�todo que faz um gancho com a subclasse.
		return possibleMoves()[position.getRow()][position.getColumn()]; // chama uma poss�vel implementa��o de alguma subclasse concreta da classe Piece
	}
	
	public boolean isThereAnyPossibleMove() { // outra implementa��o concreta que necessita de um abstrato
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
