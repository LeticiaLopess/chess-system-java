package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { // se a ChessPiece é concreta e a Piece abstrata, então ChessPiece deveria implementar os métodos abstratos, mas como ChessPiece está meio genérica ainda e não podemos lançar as especificações de cada movimento de cada peça aqui, definiremos em cada peça em chass.piece. Então, para que esse erro se anule colocaremos a ChessPiece como abstrata também

	// quando colocamos essa classe como abstract, agora as classes dentro de chess.pieces deram erro, mas nelas que iremos implementar a lógica de movimentação de cada peça, então lá implementaremos os métodos abstratos
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) { // está aqui pra ser reaproveitada para todas as outras peças
		ChessPiece p = (ChessPiece)getBoard().piece(position); // pega a peça que está nessa posição
	
		return p != null && p.getColor() != color; // aqui estou confirmando se a peça tem cor diferente da peça atual selecionada = peça adversária
	}
	
}
