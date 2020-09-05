package com.example.basicphotos.pieces;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Chessboard;

/**
 * King class for chess. Contains the rules for the King.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class King extends ChessPiece {

	/**
	 * 
	 * @param r rank
	 * @param f file
	 * @param color color of piece
	 * @param hasMoved determines whether piece has moved or not
	 */
	public King(int r, int f, boolean color, int hasMoved) {
		super(r, f, color,hasMoved);
	}

	/**
	 * {@inheritDoc}
	 * Prints the correct piece color
	 */
	@Override
	public String toString() {
		if(color) {
			return "wK";
		}
		return "bK";
	}
	
	/**
	 * {@inheritDoc}
	 * Determines whether move is acceptable or not.
	 * 
	 * @param x X-value on chessboard
	 * @param y Y-value on chessboard
	 */
	@Override
	public boolean acceptableMove(int x, int y) {
		
		int beforeX = f;
		int beforeY = r;
		
		if(x < 0 || y < 0 || x > 7 || y > 7) {
			return false;
		}
		if(color) {
			if((beforeX == 4 && beforeY == 7 && x == 6 && y == 7)) {
				if(Chessboard.board[7][7].c == null) {
					return false;
				}
				if(Chessboard.board[beforeY][beforeX].c.hasMoved != 0 || Chessboard.board[7][7].c.hasMoved != 0) {
					return false;
				}
				if(Chessboard.board[7][5].c == null && Chessboard.board[7][6].c == null) {
					return true;
				}
			} else if((beforeX == 4 && beforeY == 7 && x == 2 && y == 7)) {
				if(Chessboard.board[7][0].c == null) {
					return false;
				}
				if(Chessboard.board[beforeY][beforeX].c.hasMoved != 0 || Chessboard.board[7][0].c.hasMoved != 0) {
					return false;
				}
				if(Chessboard.board[7][1].c == null && Chessboard.board[7][2].c == null && Chessboard.board[7][3].c == null) {
					return true;
				}
			} else {
				;
			}
		} else {
			if((beforeX == 4 && beforeY == 0 && x == 2 && y == 0)) {
				if(Chessboard.board[0][0].c == null) {
					return false;
				}
				if(Chessboard.board[beforeY][beforeX].c.hasMoved != 0 || Chessboard.board[0][0].c.hasMoved != 0) {
					return false;
				}
				if(Chessboard.board[0][1].c == null && Chessboard.board[0][2].c == null && Chessboard.board[0][3].c == null) {
					return true;
				}
			} else if((beforeX == 4 && beforeY == 0 && x == 6 && y == 0)) {
				if(Chessboard.board[0][7].c == null) {
					return false;
				}
				if(Chessboard.board[beforeY][beforeX].c.hasMoved != 0 || Chessboard.board[0][7].c.hasMoved != 0) {
					return false;
				}
				if(Chessboard.board[0][5].c == null && Chessboard.board[0][6].c == null) {
					return true;
				}
			} else {
				;
			}
		}
		
		if(x == beforeX || y == beforeY) {
			if(beforeY-y == 1 || y-beforeY == 1) {
				if(Chessboard.board[y][x].c == null || Chessboard.board[y][x].c.color != color) {
					return true;
				}
			}
			if(beforeX-x == 1 || x-beforeX == 1) {
				if(Chessboard.board[y][x].c == null || Chessboard.board[y][x].c.color != color) {
					return true;
				}			}
		}
		if((x-beforeX == y-beforeY) || (beforeX-x == beforeY-y) || (x-beforeX == beforeY-y) || (beforeX-x == y-beforeY)) {
			if(x-beforeX == 1 || beforeX-x == 1 || y-beforeY == 1 || beforeY-y == 1) {
				if(Chessboard.board[y][x].c == null || Chessboard.board[y][x].c.color != color) {
					return true;
				}			
			}
		}

		return false;
	}

}
