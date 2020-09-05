package com.example.basicphotos.chess;

/**
 * Defines a square on the chessboard. The Chessboard is an 8x8 array containing these squares.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Square {
	int r,f;
	boolean color;
	public String square_str;
	public ChessPiece c;
	public Square(int x, int y, boolean color, ChessPiece c,String s) {
		//this.color=color;
		this.r=x;
		this.f=y;
		this.c=c;
		square_str=s;
	}

	/**
	 * Prints the correct piece color
	 */
	public String toString(){
		if(c!=null) {
			return c.toString();
		}
		if(color) {
			return "  ";
		}
		return "##";
	}
	
}
