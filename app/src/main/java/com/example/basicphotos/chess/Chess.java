package com.example.basicphotos;

import java.util.Scanner;



/**
 * 
 * Main chess class containing main method.
 * 
 * @author Jack Kelly, Akshay Niranjan
 *
 */
public class Chess {
	
	/**
	 * Main method
	 * 
	 * @param args The command line argument
	 */
	//public static void main(String[] args) {

		/** Create new Chessboard */
		//Chessboard c = new Chessboard();

		//Scanner sc = new Scanner(System.in);
		
		/** even is white's turn, odd is black's turn */
		//int turn = 2;
		
		/** 1 means white won, 2 means black won, 3 means draw */
		//int winner = -1;
		
		/** Offered to draw */
		//boolean draw = false;
		
		/** Offered to draw */
		//boolean drawBoard = true;
		
		/** Position of x-value of white king */
		//int wK_x = 4;
		
		/** Position of y-value of white king */
		//int wK_y = 7;
		
		/** Position of x-value of black king */
		//int bK_x = 4;
		
		/** Position of y-value of black king */
		//int bK_y = 0;
		
		/** Team in check. 1 means white is in check, 2 means black is in check */
		//int check = 0;
		
		/** Used for En-Passant. 1 means white moved pawn +2, 2 means black moved pawn +2 */
		//int enPassant = -1;
		
		/** Print check */
		//int printCheck = 0;
		
		/*while(true) {
			if(drawBoard) {
				c.printBoard();
			}*/
			
			/** Check for checkmate */
			/*boolean testMate = true;
			if(check == 2) {
				testMate = checkMate(c, false, bK_x, bK_y, enPassant,0);
			}
			if (check == 1) {
				testMate = checkMate(c, true, wK_x, wK_y, enPassant,0);
			}
				
			if(testMate == false) {
				System.out.println("Checkmate");
				if(check == 1) {
					winner = 1;
				} else {
					winner = 2;
				}
				break;
			}
			/** Check for stalemate */
			/*boolean testStaleMate = false;
			if (check == 0) {
				if(turn%2==0) {
					testStaleMate = checkMate(c, true, wK_x, wK_y, enPassant,1);

				} else {
					testStaleMate = checkMate(c, false, bK_x, bK_y, enPassant,1);
				}
			} 
			
			if(testStaleMate == false && check == 0) {
				System.out.println("Stalemate");
				break;
			}
			
			if(printCheck != 0) {
				System.out.println("Check");
			}
			
			
			if(turn % 2 == 0) {
				System.out.print("White's move: ");
			} else {
				System.out.print("Black's move: ");
			}
			
			String move = sc.nextLine();
			
			/** Parse string into start and end move */
			/*String[] moves = move.split(" ");
			
			/** Check if player resigned  */
			/*if(move.equals("resign")) {
				if(turn % 2 == 0) {
					winner = 1;
				} else {
					winner = 2;
				}
				break;
			}
			
			/** Check if player accepts draw */
			/*if(moves[0].equals("draw") && draw == true) {
				winner = 3;
				break;
			} else if(moves[0].equals("draw") && draw == false){ 
				System.out.println("Illegal move, try again");
				drawBoard = false;
				continue;
			} else {
				draw = false;
			}
					
			int x1 = moves[0].charAt(0) - 'a';
			int y1 = 8 - (moves[0].charAt(1) - '0');
			
			int x2 = moves[1].charAt(0) - 'a';
			int y2 = 8 - (moves[1].charAt(1) - '0');
			
			/** Make sure moving a piece at all */
			/*if(Chessboard.board[y1][x1].c == null) {
				System.out.println("Illegal move, try again");
				drawBoard = false;
				continue;
			}
						
			
			/** Moving the correct color piece */
			/*if(turn%2 == 0) {
				if(Chessboard.board[y1][x1].c.color == false) {
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
				}
			} else {
				if(Chessboard.board[y1][x1].c.color == true) {
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
				}
			}
			
			/** Illegal move, try again... */
			/*if(!(Chessboard.board[y1][x1].c.acceptableMove(x2,y2))) {
				System.out.println("Illegal move, try again");
				drawBoard = false;
				continue;
			}
			
			
			/** Illegal move, lost right to do En-Passant */
			/*if(Chessboard.board[y1][x1].c.toString().equals("wp") && (x1-x2 == 1 || x2-x1 == 1) && y1-y2 == 1 && (enPassant != x2 || enPassant == -1)) {
				if(Chessboard.board[y2][x2].c == null) {
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
				}
			}
			if(Chessboard.board[y1][x1].c.toString().equals("bp") && (x1-x2 == 1 || x2-x1 == 1) && y2-y1 == 1 && (enPassant != x2 || enPassant == -1)) {
				if(Chessboard.board[y2][x2].c == null) {
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
				}
			}			
			/** 
			 * Check castling move of King
			 * Black trying to castle on top
			 */
			/*int castleCheck = 0;
			int castle = 0;
			if(y1 == 0 && x1 == 4 && (y2 == 0 && (x2 == 2 || x2 == 6))) {
				if(check != 0) {		
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
					
				} else {
					int posCheck = 0;
					if(x2 == 2) {
						for(int i = 1; i < 4; i++) {
							posCheck = inCheck(c, i, 0, false);
							if(posCheck > 0) {
								castleCheck = 1;
							}
						}
					} else {
						for(int i = 5; i < 7; i++) {
							posCheck = inCheck(c, i, 0, false);
							if(posCheck > 0) {
								castleCheck = 1;
							}
						}
					}
					
					if(castleCheck == 1) {
						System.out.println("Illegal move, try again");
						drawBoard = false;
						continue;
					} else {
						castle = 2;
					}
				}
			} else {
				;
			}
			/** White trying to castle on bottom */
			/*if(y1 == 7 && x1 == 4 && (y2 == 7 && (x2 == 2 || x2 == 6))) {
				if(check != 0) {
					System.out.println("Illegal move, try again");
					drawBoard = false;
					continue;
				} else {
					/** Can't castle if positions between would be hit */
					/*int posCheck = 0;
					if(x2 == 2) {
						for(int i = 1; i < 4; i++) {
							posCheck = inCheck(c, i, 7, true);
							if(posCheck > 0) {
								castleCheck = 1;
							}
						}
					} else {
						for(int i = 5; i < 7; i++) {
							posCheck = inCheck(c, i, 7, true);
							if(posCheck > 0) {
								castleCheck = 1;
							}
						}
					}
					
					if(castleCheck == 1) {
						System.out.println("Illegal move, try again");
						drawBoard = false;
						continue;
					} else {
						castle = 1;
					}				}
			} else {
				;
			}
			

			ChessPiece temp = null;
			int p = 0;
			int kingMoved = 0;
			boolean firstMove = false;
			
			/** Check for En-Passant */
			/*if(turn%2 == 0) {
				if(castle != 0) {
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
					
					if(x2 == 6) {
						ChessPiece hold1 = Chessboard.board[7][5].c;
						Chessboard.board[7][5].c = Chessboard.board[7][7].c;
						Chessboard.board[7][7].c = hold1;
						Chessboard.board[7][5].c.r = 7;
						Chessboard.board[7][5].c.f = 5;
						Chessboard.board[7][5].c.hasMoved += 1;
					} else {
						ChessPiece hold1 = Chessboard.board[7][3].c;
						Chessboard.board[7][3].c = Chessboard.board[7][0].c;
						Chessboard.board[7][0].c = hold1;
						Chessboard.board[7][3].c.r = 7;
						Chessboard.board[7][3].c.f = 3;
						Chessboard.board[7][3].c.hasMoved += 1;
					}
					
				} else if(Chessboard.board[y2][x2].c == null && (x1-x2 == 1 || x2-x1 == 1) && y1-y2 == 1 && enPassant == x2) {
					temp = Chessboard.board[y1][x2].c;
					Chessboard.board[y1][x2].c = null;
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					Chessboard.board[y2][x2].c.hasMoved += 1;
					p = 3;
				} else if(Chessboard.board[y2][x2].c == null) {
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
				} else if(Chessboard.board[y2][x2].c.color == false) {
					temp = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					Chessboard.board[y2][x2].c.color = true;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
					Chessboard.board[y1][x1].c = null;
					p = 1;
				} else {
					;
				}
				/** Update the position of the king if it was moved */
				/*if(Chessboard.board[y2][x2].c.toString().equals("wK")) {
					kingMoved = 1;
					wK_x = x2;
					wK_y = y2;
				}
				
			} else {
				if(castle != 0) {
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
										
					if(x2 == 2) {
						ChessPiece hold1 = Chessboard.board[0][3].c;
						Chessboard.board[0][3].c = Chessboard.board[0][0].c;
						Chessboard.board[0][0].c = hold1;
						Chessboard.board[0][3].c.r = 0;
						Chessboard.board[0][3].c.f = 3;
						Chessboard.board[0][3].c.hasMoved += 1;
					} else {
						ChessPiece hold1 = Chessboard.board[0][5].c;
						Chessboard.board[0][5].c = Chessboard.board[0][7].c;
						Chessboard.board[0][7].c = hold1;
						Chessboard.board[0][5].c.r = 0;
						Chessboard.board[0][5].c.f = 5;
						Chessboard.board[0][5].c.hasMoved += 1;
					}
					
				} else if(Chessboard.board[y2][x2].c == null && (x1-x2 == 1 || x2-x1 == 1) && y2-y1 == 1 && enPassant == x2) {
					temp = Chessboard.board[y1][x2].c;
					Chessboard.board[y1][x2].c = null;
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					Chessboard.board[y2][x2].c.hasMoved += 1;
					p = 4;
				} else if(Chessboard.board[y2][x2].c == null) {
					ChessPiece hold = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = hold;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
				} else if(Chessboard.board[y2][x2].c.color == true) {
					temp = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = Chessboard.board[y1][x1].c;
					Chessboard.board[y2][x2].c.r = y2;
					Chessboard.board[y2][x2].c.f = x2;
					Chessboard.board[y2][x2].c.color = false;
					if(Chessboard.board[y2][x2].c.hasMoved == 0) {
						firstMove = true;
					}
					Chessboard.board[y2][x2].c.hasMoved += 1;
					Chessboard.board[y1][x1].c = null;
					p = 2;
				} else {
					;
				}
				/** Update the position of the king if it was moved */
				/*if(Chessboard.board[y2][x2].c.toString().equals("bK")) {
					kingMoved = 2;
					bK_x = x2;
					bK_y = y2;
				}
			}
			
			/** Check if move will put own king in check */
			/*int testCheck = 0;
			if(turn%2 == 0) {
				testCheck = inCheck(c, wK_x, wK_y, true);
			} else {
				testCheck = inCheck(c, bK_x, bK_y, false);
			}
			
			/** Invalid move and would put king in check */
			/*if(testCheck > 0) {
				System.out.println("Illegal move, try again");
				drawBoard = false;
				
				/** Undo the move */
				/*if(p == 0) {
					ChessPiece hold = Chessboard.board[y1][x1].c;
					Chessboard.board[y1][x1].c = Chessboard.board[y2][x2].c;
					Chessboard.board[y2][x2].c = hold;
					Chessboard.board[y1][x1].c.r = y1;
					Chessboard.board[y1][x1].c.f = x1;
					if(firstMove == true) {
						Chessboard.board[y1][x1].c.hasMoved = 0;
					}
				} else {
					if(p == 3 || p == 4) {
						Chessboard.board[y1][x1].c = Chessboard.board[y2][x2].c;
						Chessboard.board[y1][x1].c.r = y1;
						Chessboard.board[y1][x1].c.f = x1;
						Chessboard.board[y1][x2].c = temp;
					} else {
						Chessboard.board[y1][x1].c = Chessboard.board[y2][x2].c;
						Chessboard.board[y1][x1].c.r = y1;
						Chessboard.board[y1][x1].c.f = x1;
						Chessboard.board[y2][x2].c = temp;
						if(firstMove == true) {
							Chessboard.board[y1][x1].c.hasMoved = 0;
						}
						if(p == 1) {
							Chessboard.board[y2][x2].c.color = false;
						} else if(p == 2) {
							Chessboard.board[y2][x2].c.color = true;
						} else {
							;
						}
					}
				}
				if(kingMoved == 1) {
					wK_x = x1;
					wK_y = y1;
				} else if (kingMoved == 2) {
					bK_x = x1;
					bK_y = y1;
				} else {
					;
				}
				continue;
			}
			
			
			/** Check if player put opposing team in check */
			/*testCheck = 0;
			if(turn%2 == 0) {
				testCheck = inCheck(c, bK_x, bK_y, false);
			} else {
				testCheck = inCheck(c, wK_x, wK_y, true);
			}
			
			if(testCheck > 0) {
				if(turn%2 == 0) {
					check = 2;
				} else {
					check = 1;
				}
				printCheck = 1;
			} else {
				check = 0;
				printCheck = 0;
			}
			
			/** Pawn Upgrade */
			/*if(turn%2 == 0) {
				if(Chessboard.board[y2][x2].c.toString().equals("wp") && y2 == 0) {
					if(moves.length < 3) {
						Chessboard.board[y2][x2].c = null;
						Chessboard.board[y2][x2].c = new Queen(y2,x2,true,7);
					} else {
						if(moves[2].equals("N")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Horse(y2,x2,true,7);
						} else if(moves[2].equals("R")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Rook(y2,x2,true,7);
						} else if(moves[2].equals("B")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Bishop(y2,x2,true,7);
						} else {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Queen(y2,x2,true,7);
						}
					}
				}
			} else {
				if(Chessboard.board[y2][x2].c.toString().equals("bp") && y2 == 7) {
					if(moves.length < 3) {
						Chessboard.board[y2][x2].c = null;
						Chessboard.board[y2][x2].c = new Queen(y2,x2,false,7);
					} else {
						if(moves[2].equals("N")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Horse(y2,x2,false,7);
						} else if(moves[2].equals("R")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Rook(y2,x2,false,7);
						} else if(moves[2].equals("B")) {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Bishop(y2,x2,false,7);
						} else {
							Chessboard.board[y2][x2].c = null;
							Chessboard.board[y2][x2].c = new Queen(y2,x2,false,7);
						}
					}				
				}
			}
			
			
			/** If pawned moved +2 squares in initial move, set en-passant flag */
			/*if(Chessboard.board[y2][x2].c.toString().equals("wp") && x1-x2 == 0 && y1-y2 == 2) {
				enPassant = x2;
			} else if(Chessboard.board[y2][x2].c.toString().equals("bp") && x1-x2 == 0 && y2-y1 == 2) {
				enPassant = x2;
			} else {
				enPassant = -1;
			}
				
			/** Check if player offered "draw?" */
			/*if(moves.length >= 3) {
				if(moves[2].equals("draw?")) {
					draw = true;
					System.out.println();
				}
			}
			
			System.out.println();
			drawBoard = true;
			++turn;
			
		}
		

		/** Declare winner */
		/*if(winner == 1) {
			System.out.println("Black wins");
		} else if(winner == 2) {
			System.out.println("White wins");
		} else if(winner == 3) {
			System.out.println("draw");
		} else {
			System.out.println("draw");
		}
		sc.close();
	}
	
	
	/** 
	 * Given a Chessboard, will determine whether king is in check. This method can also be used for castling, 
	 * making sure none of the positions between the king and rook are in reach by an enemy piece
	 * 
	 * @param c Chessboard to look at
	 * @param x X value of the coordinates
	 * @param y Y value of the coordinates
	 * @param color What color to look at when testing if a piece can reach the (x,y) coordinates. True is white, False is black
	 * @return returns 1 if an enemy piece has an acceptable move to the (x,y) coordinates, 0 if not
	 */
	/*public static int inCheck(Chessboard c, int x, int y, boolean color) {
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(Chessboard.board[i][j].c == null) {
					continue;
				} else {
					if(Chessboard.board[i][j].c.color != color) {
						if(Chessboard.board[i][j].c.acceptableMove(x,y)) {
							return 1;
						}
					}
				}
				
			}
		}
		
		return 0;
	}
	
	
	
	
	/**
	 * Given a Chessboard, will iterate over every possible move for all pieces to see if the King can
	 * get out of check.
	 * 
	 * @param c Chessboard to look at
	 * @param color Color of king try to get out of check. True is white, False is black.
	 * @param x X value of the coordinates
	 * @param y Y value of the coordinates
	 * @param enPassant Flag passed from the main method. If en-passant is possible move and can get King out of check, do it
	 * @param flag Used to differentiate between testing for checkmate or stalemate. Main concern is castling.
	 * @return returns false is there is no valid move to get the king out of check, or true if there is.
	 */
	/*public static boolean checkMate(Chessboard c, boolean color, int x, int y, int enPassant, int flag) {
		
		int kingX = x;
		int kingY = y;
		
		int check = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				
				if(Chessboard.board[i][j].c == null) {
					continue;
				} else {
					
					if(Chessboard.board[i][j].c.color == color) {
						for(int k = 0; k < 8; k++) {
							for(int l = 0; l < 8; l++) {
								if(Chessboard.board[i][j].c.acceptableMove(l, k)) {
									
									if(Chessboard.board[i][j].c.toString().equals("wp") && (j-l == 1 || l-j == 1) && i-k == 1 && (enPassant != l || enPassant == -1)) {
										if(Chessboard.board[k][l].c == null) {
											continue;
										}
									}
									if(Chessboard.board[i][j].c.toString().equals("bp") && (j-l == 1 || l-j == 1) && k-i == 1 && (enPassant != l || enPassant == -1)) {
										if(Chessboard.board[k][l].c == null) {
											continue;
										}
									}
									
									if(flag == 0) {
										if(Chessboard.board[i][j].c.toString().equals("wK")) {
											if(i == 7 && j == 4 && (k == 7 && (l == 2 || l == 6))) {
												continue;
											}
										}
										if(Chessboard.board[i][j].c.toString().equals("bK")) {
											if(i == 0 && j == 4 && (k == 0 && (l == 2 || l == 6))) {
												continue;
											}
										}
									} else {
										if(Chessboard.board[i][j].c.toString().equals("wK")) {
											if(i == 7 && j == 4 && (k == 7 && (l == 2 || l == 6))) {
												int posCheck = 0;
												int castleCheck = 0;
												if(l == 2) {
													for(int p = 1; p < 4; p++) {
														posCheck = inCheck(c, p, 7, true);
														if(posCheck > 0) {
															castleCheck = 1;
														}
													}
												} else {
													for(int p = 5; p < 7; p++) {
														posCheck = inCheck(c, p, 7, true);
														if(posCheck > 0) {
															castleCheck = 1;
														}
													}
												}
												if(castleCheck == 1) {
													continue;
												} else {
													check = 1;
													continue;
												}
											}
										}
										if(Chessboard.board[i][j].c.toString().equals("bK")) {
											if(i == 0 && j == 4 && (k == 0 && (l == 2 || l == 6))) {
												int posCheck = 0;
												int castleCheck = 0;
												if(l == 2) {
													for(int p = 1; p < 4; p++) {
														posCheck = inCheck(c, p, 0, false);
														if(posCheck > 0) {
															castleCheck = 1;
														}
													}
												} else {
													for(int p = 5; p < 7; p++) {
														posCheck = inCheck(c, p, 0, false);
														if(posCheck > 0) {
															castleCheck = 1;
														}
													}
												}	
												if(castleCheck == 1) {
													continue;
												} else {
													check = 1;
													continue;
												}
											}
										}
									}
									

									
									ChessPiece temp = null;
									int p = 0;
									int kingMoved = 0;
									boolean firstMove = false;
									
									if((Chessboard.board[i][j].c.toString().equals("wp") || Chessboard.board[i][j].c.toString().equals("bp")) && Chessboard.board[k][l].c == null && (j-l == 1 || l-j == 1) && i-k == 1 && enPassant == l) {
										temp = Chessboard.board[i][l].c;
										Chessboard.board[i][l].c = null;
										ChessPiece hold = Chessboard.board[k][l].c;
										Chessboard.board[k][l].c = Chessboard.board[i][j].c;
										Chessboard.board[i][j].c = hold;
										Chessboard.board[k][l].c.r = k;
										Chessboard.board[k][l].c.f = l;
										p = 3;
										
									} else if(Chessboard.board[k][l].c == null) {		
										ChessPiece hold = Chessboard.board[k][l].c;
										Chessboard.board[k][l].c = Chessboard.board[i][j].c;
										Chessboard.board[i][j].c = hold;
										Chessboard.board[k][l].c.r = k;
										Chessboard.board[k][l].c.f = l;
										if(Chessboard.board[k][l].c.hasMoved == 0) {
											firstMove = true;
										}
									} else if(Chessboard.board[k][l].c.color != color) {
										temp = Chessboard.board[k][l].c;
										Chessboard.board[k][l].c = Chessboard.board[i][j].c;
										Chessboard.board[k][l].c.r = k;
										Chessboard.board[k][l].c.f = l;
										Chessboard.board[k][l].c.color = color;
										if(Chessboard.board[k][l].c.hasMoved == 0) {
											firstMove = true;
										}
										Chessboard.board[k][l].c.hasMoved += 1;
										Chessboard.board[i][j].c = null;
										p = 1;
									} else {
										;
									}
									
									if(color == true) {
										if(Chessboard.board[k][l].c.toString().equals("wK")) {
											kingMoved = 1;
											kingX = l;
											kingY = k;
										}
									} else {
										if(Chessboard.board[k][l].c.toString().equals("bK")) {
											kingMoved = 1;
											kingX = l;
											kingY = k;
										}
									}

									
									
									int testCheck = 0;
									testCheck = inCheck(c, kingX, kingY, color);
								
									if(testCheck > 0) {
										if(p == 0) {
											ChessPiece hold = Chessboard.board[i][j].c;
											Chessboard.board[i][j].c = Chessboard.board[k][l].c;
											Chessboard.board[k][l].c = hold;
											Chessboard.board[i][j].c.r = i;
											Chessboard.board[i][j].c.f = j;
											if(firstMove == true) {
												Chessboard.board[i][j].c.hasMoved = 0;
											}
										} else {
											if(p == 3 || p == 4) {
												Chessboard.board[i][j].c = Chessboard.board[k][l].c;
												Chessboard.board[i][j].c.r = i;
												Chessboard.board[k][l].c.f = j;
												Chessboard.board[i][l].c = temp;
											} else {
												Chessboard.board[i][j].c = Chessboard.board[k][l].c;
												Chessboard.board[i][j].c.r = i;
												Chessboard.board[i][j].c.f = j;
												Chessboard.board[k][l].c = temp;
												if(firstMove == true) {
													
													Chessboard.board[i][j].c.hasMoved = 0;
												}
											}
										}
										if(kingMoved == 1) {
											kingX = j;
											kingY = i;
										}
	
									} else {
										check = 1;
										
										if(p == 0) {
											ChessPiece hold = Chessboard.board[i][j].c;
											Chessboard.board[i][j].c = Chessboard.board[k][l].c;
											Chessboard.board[k][l].c = hold;
											Chessboard.board[i][j].c.r = i;
											Chessboard.board[i][j].c.f = j;
											if(firstMove == true) {
												Chessboard.board[i][j].c.hasMoved = 0;
											}
										} else {
											if(p == 3 || p == 4) {
												Chessboard.board[i][j].c = Chessboard.board[k][l].c;
												Chessboard.board[i][j].c.r = i;
												Chessboard.board[k][l].c.f = j;
												Chessboard.board[i][l].c = temp;
											} else {
												Chessboard.board[i][j].c = Chessboard.board[k][l].c;
												Chessboard.board[i][j].c.r = i;
												Chessboard.board[i][j].c.f = j;
												Chessboard.board[k][l].c = temp;
												if(firstMove == true) {
													Chessboard.board[i][j].c.hasMoved = 0;
												}
											}
										}
									}
								}
							}
						}
					}
					
				}
					
			}
		}
		if(check == 1) {
			return true;
		} else {
			return false;
		}
	}*/
}
