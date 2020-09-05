package com.example.basicphotos.pieces;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Chessboard;

/**
 * Knight class for chess. Contains the rules for the Knight.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Horse extends ChessPiece {

	/**
	 * 
	 * @param r rank
	 * @param f file
	 * @param color color of the piece
	 * @param hasMoved determines whether piece has moved
	 */
	public Horse(int r, int f, boolean color, int hasMoved) {
		super(r, f, color,hasMoved);
	}

	/**
	 * {@inheritDoc}
	 * Prints the correct piece color
	 */
	@Override
	public String toString() {
		if(color) {
			return "wN";
		}
		return "bN";
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
		} else {
			if(((x-beforeX == 1) || (beforeX-x == 1)) && ((y-beforeY == 2) || (beforeY-y == 2))) {
				if(Chessboard.board[y][x].c != null  && Chessboard.board[y][x].c.color == color) {
					return false;
				}
				return true;
			}
			if(((x-beforeX == 2) || (beforeX-x == 2)) && ((y-beforeY == 1) || (beforeY-y == 1))) {
				if(Chessboard.board[y][x].c != null  && Chessboard.board[y][x].c.color == color) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

}
