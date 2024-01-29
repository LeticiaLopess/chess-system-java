package chess;

import boardgame.BoardException;

public class ChessException extends BoardException { // mudamos de RunTimeException para BoardException pois quando ocorrer algum BoardException eu também irei capturar

	private static final long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}

}
