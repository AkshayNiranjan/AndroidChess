package com.example.basicphotos.pieces;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Chessboard;

/**
 * Knight class for chess. Contains the rules for the Knight.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Rook extends ChessPiece {

	/**
	 * 
	 * @param r rank
	 * @param f file
	 * @param color color of piece
	 * @param hasMoved determines whether piece has moved or not
	 */
	public Rook(int r, int f, boolean color, int hasMoved) {
		super(r, f, color,hasMoved);
	}
	
	/**
	 * {@inheritDoc}
	 * Prints the correct piece color
	 */
	@Override
	public String toString() {
		if(color) {
			return "wR";
		}
		return "bR";
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
		
		if(check == 1) {
			return true;
		}
		
		return false;
	}
}
