package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { // se a ChessPiece � concreta e a Piece abstrata, ent�o ChessPiece deveria implementar os m�todos abstratos, mas como ChessPiece est� meio gen�rica ainda e n�o podemos lan�ar as especifica��es de cada movimento de cada pe�a aqui, definiremos em cada pe�a em chass.piece. Ent�o, para que esse erro se anule colocaremos a ChessPiece como abstrata tamb�m

	// quando colocamos essa classe como abstract, agora as classes dentro de chess.pieces deram erro, mas nelas que iremos implementar a l�gica de movimenta��o de cada pe�a, ent�o l� implementaremos os m�todos abstratos
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) { // est� aqui pra ser reaproveitada para todas as outras pe�as
		ChessPiece p = (ChessPiece)getBoard().piece(position); // pega a pe�a que est� nessa posi��o
	
		return p != null && p.getColor() != color; // aqui estou confirmando se a pe�a tem cor diferente da pe�a atual selecionada = pe�a advers�ria
	}
	
}
