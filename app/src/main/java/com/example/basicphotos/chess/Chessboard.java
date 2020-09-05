package com.example.basicphotos.chess;

import com.example.basicphotos.chess.ChessPiece;
import com.example.basicphotos.chess.Square;
import com.example.basicphotos.pieces.Bishop;
import com.example.basicphotos.pieces.Horse;
import com.example.basicphotos.pieces.King;
import com.example.basicphotos.pieces.Pawn;
import com.example.basicphotos.pieces.Queen;
import com.example.basicphotos.pieces.Rook;


/**
 * Creates the Chessboard that will be used for the game
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Chessboard {
	public static Square[][] board;
	static char[] files= {'a','b','c','d','e','f','g','h'};
	static char[] rows= {'8','7','6','5','4','3','2','1'};
	char[] chessRows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	char[] chessCols = {'1', '2', '3', '4', '5', '6', '7', '8'};
	boolean color=true;
	public Chessboard(){
		board=new Square[8][8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				board[i][j]=new Square(i,j,color,null,"M" + chessRows[i] + "" + chessCols[j]);
				color=!color;
			}
			color=!color;
		}
		color=true;
		initRook();
		initHorse();
		initBishop();
		initKingNQueen();
		initPawn();
	}
	
	/**
	 * Initiates the Rook's
	 */
	public void initRook() {
		board[0][0].c=new Rook(0,0,false,0);
		board[0][7].c=new Rook(0,7,false,0);
		board[7][0].c=new Rook(7,0,true,0);
		board[7][7].c=new Rook(7,7,true,0);
	}
	
	/**
	 * Initiates the Knight's
	 */
	public void initHorse() {
		board[0][1].c=new Horse(0,1,false,0);
		board[0][6].c=new Horse(0,6,false,0);
		board[7][1].c=new Horse(7,1,true,0);
		board[7][6].c=new Horse(7,6,true,0);
	}
	
	/**
	 * Initiates the Bishop's
	 */
	public void initBishop() {
		board[0][2].c=new Bishop(0,2,false,0);
		board[0][5].c=new Bishop(0,5,false,0);
		board[7][2].c=new Bishop(7,2,true,0);
		board[7][5].c=new Bishop(7,5,true,0);
	}
	
	/**
	 * Initiates the King's and Queen's
	 */
	public void initKingNQueen() {
		board[0][3].c=new Queen(0,3,false, 0);
		board[0][4].c=new King(0,4,false, 0);
		board[7][4].c=new King(7,4,true, 0);
		board[7][3].c=new Queen(7,3,true, 0);
	}
	
	/**
	 * Initiates the Pawn's
	 */
	public void initPawn() {
		for(int i=0;i<8;i++) {
			board[1][i].c=new Pawn(1,i,false, 0);
		}
		for(int i=0;i<8;i++) {
			board[6][i].c=new Pawn(6,i,true, 0);
		}
	}
	
	/**
	 * Prints out the board for each move
	 */
	public void printBoard() {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(board[i][j].toString());
				System.out.print(" ");
			}
			System.out.print("");
			System.out.print(rows[i]);
			System.out.println();
		}
		for(int i=0;i<8;i++) {
			if(i == 0) {
				System.out.print(" ");
				System.out.print(files[i]);
			} else {
				System.out.print("  ");
				System.out.print(files[i]);
			}
		}
		System.out.println("\n");
	}
	
	/**
	 *  Checks if piece is valid to move
	 *  
	 * @param x X-value coordinate
	 * @param y Y-value coordinate
	 * @return If there isn't a piece ,0, if the piece is the current color ,1, not a piece player can move return -1
	 */
	public int checkPiece(int x, int y) {
		if(board[x][y].c==null)
			return 0;
		if(board[x][y].c.color==color)
			return 1;
		return -1;
	}
	
}
