package com.example.basicphotos.chess;

/**
 * Chesspiece class that has the variables needed for each type of chesspiece. All chesspieces inherit this class.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public abstract class ChessPiece {
	public int r;
	public int f;
	public boolean color;
	public int hasMoved;
	public abstract String toString();
	public abstract boolean acceptableMove(int x, int y);
	public ChessPiece(int r, int f, boolean color, int hasMoved) {
		this.r=r;
		this.f=f;
		this.color=color;
		this.hasMoved=hasMoved;
	}
}
