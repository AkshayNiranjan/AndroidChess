package com.example.basicphotos.pieces;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Chessboard;

/**
 * Pawn class for chess. Contains the rules for the pawn.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Pawn extends ChessPiece {

	/**
	 * Defines the pawn Chesspiece
	 * 
	 * @param r rank
	 * @param f file
	 * @param color color of piece
	 * @param hasMoved whether it has moved or not.
	 */
	public Pawn(int r, int f, boolean color, int hasMoved) {
		super(r, f, color, hasMoved);
	}

	/**
	 * {@inheritDoc}
	 * Prints the correct piece color
	 */
	@Override
	public String toString() {
		if(color) {
			return "wp";
		}
		return "bp";
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
			if(beforeY-y > 0) {
				if(x-beforeX == 0 && beforeY-y == 2 && hasMoved == 0) {
					if(beforeY-1 < 0 || beforeY-2 < 0){
						return false;
					}
					if(Chessboard.board[beforeY-1][x].c == null && Chessboard.board[beforeY-2][x].c == null) {
						return true;
					}
				} else if (x-beforeX == 0 && beforeY-y == 1 && Chessboard.board[y][x].c == null) {
					return true;
				} else if ((x-beforeX == 1 || beforeX-x == 1) && beforeY-y == 1 && Chessboard.board[y][x].c != null && Chessboard.board[y][x].c.color != true) {
					return true;
				} else if ((x-beforeX == 1 || beforeX-x == 1) && beforeY-y == 1 && Chessboard.board[y][x].c == null) {
					if(beforeY == 3) {
						if (Chessboard.board[beforeY][x].c != null) {
							if(Chessboard.board[beforeY][x].c.color != color && Chessboard.board[beforeY][x].c.hasMoved == 1) {
								return true;
							}
						}
						
					}
				}
			}
		} else {
			if(y-beforeY > 0) {
				if(x-beforeX == 0 && y-beforeY == 2 && hasMoved == 0) {
					if(beforeY+1 > 7 || beforeY+2 > 7){
						return false;
					}
					if(Chessboard.board[beforeY+1][x].c == null && Chessboard.board[beforeY+2][x].c == null) {
						return true;
					}
				} else if (x-beforeX == 0 && y-beforeY == 1 && Chessboard.board[y][x].c == null) {
					return true;
				} else if ((x-beforeX == 1 || beforeX-x == 1) && y-beforeY == 1 && Chessboard.board[y][x].c != null && Chessboard.board[y][x].c.color != false) {
					return true;
				} else if ((x-beforeX == 1 || beforeX-x == 1) && y-beforeY == 1 && Chessboard.board[y][x].c == null) {
					if(beforeY == 4) {
						if (Chessboard.board[beforeY][x].c != null) {
							if(Chessboard.board[beforeY][x].c.color != color && Chessboard.board[beforeY][x].c.hasMoved == 1) {
								return true;
							}
						}
						
					}
				}
			}
		}
		
		return false;
	}

}
