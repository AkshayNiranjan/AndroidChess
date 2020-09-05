package com.example.basicphotos.pieces;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Chessboard;

/**
 * Queen class for chess. Contains the rules for the Queen.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Queen extends ChessPiece {

	/**
	 * 
	 * @param r rank
	 * @param f file
	 * @param color color of piece
	 * @param hasMoved determines whether piece has moved or not
	 */
	public Queen(int r, int f, boolean color, int hasMoved) {
		super(r, f, color,hasMoved);
	}

	/**
	 * {@inheritDoc}
	 * Prints the correct piece color
	 */
	@Override
	public String toString() {
		if(color) {
			return "wQ";
		}
		return "bQ";
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
		int check = 0;
		
		if(x < 0 || y < 0 || x > 7 || y > 7) {
			return false;
		}

		
		if(beforeX == x && beforeY != y) {
			int temp = beforeY;
			while(y != temp) {
				if(beforeY-y > 0) {
					--temp;
				} else {
					++temp;
				}
				if(Chessboard.board[temp][x].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[temp][x].c != null && temp == y && Chessboard.board[temp][x].c.color != color) {
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		}
		if(beforeY == y && beforeX != x) {
			int temp = beforeX;
			while(x != temp) {
				if(beforeX-x > 0) {
					--temp;
				} else {
					++temp;
				}
				if(Chessboard.board[y][temp].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[y][temp].c != null && temp == x && Chessboard.board[y][temp].c.color != color) { 
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		}
		int tX = beforeX;
		int tY = beforeY;
		if((x-beforeX == y-beforeY) && (x-beforeX > 0) && (y-beforeY > 0)) {
			while(tX != x && tY != y) {
				++tX;
				++tY;
				if(Chessboard.board[tY][tX].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[tY][tX].c != null && tY == y && tX == x && Chessboard.board[tY][tX].c.color != color) {
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		} else if((beforeX-x == beforeY-y) && (beforeX-x > 0) && (beforeY-y > 0)) {
			while(tX != x && tY != y) {
				--tX;
				--tY;
				if(Chessboard.board[tY][tX].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[tY][tX].c != null && tY == y && tX == x && Chessboard.board[tY][tX].c.color != color) {
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		} else if((x-beforeX == beforeY-y) && (x-beforeX > 0) && (beforeY-y > 0)) {
			while(tX != x && tY != y) {
				++tX;
				--tY;
				if(Chessboard.board[tY][tX].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[tY][tX].c != null && tY == y && tX == x && Chessboard.board[tY][tX].c.color != color) {
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		} else if((beforeX-x == y-beforeY) && (beforeX-x > 0) && (y-beforeY > 0)) {
			while(tX != x && tY != y) {
				--tX;
				++tY;
				if(Chessboard.board[tY][tX].c == null) {
					check = 1;
					continue;
				} else if(Chessboard.board[tY][tX].c != null && tY == y && tX == x && Chessboard.board[tY][tX].c.color != color) {
					check = 1;
					continue;
				} else {
					check = 0;
					break;
				}
			}
		} else {
			;
		}
	
		if(check == 1) {
			return true;
		}
		return false;
	}

}
