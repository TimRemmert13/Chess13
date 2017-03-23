
package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import game.*;
import pieces.*;
/**
 * Class to run the game of chess where players moves are process and a winner or draw is 
 * determined.
 * @author Tim Remmert
 *
 */
public class Chess13 {
	public static void main(String[] args)
			throws IOException {
		//create buffer reader to read players input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//create board and print
		Board gameBoard = new Board(8,8);
		System.out.println();
		boolean bCheck = false;
		boolean wCheck = false;
		boolean checkmate = false;
		boolean wturn = true;
		boolean bturn = false;
		boolean drawSign = false;
		gameBoard.getPlayer(7, 0).toggleTurn();
		int[] wK ={7,4};
		int[] bK ={0,4};
	
		
		while(!checkmate){
			gameBoard.printBoard();
			System.out.println();
			if (wturn){
				if(gameBoard.findCheck(wK[0], wK[1])){
					if(gameBoard.findCheckMate(wK)){
						System.out.println("Checkmate");
						System.out.println("Black wins!");
						break;
					}else{
						System.out.println("Check");
						System.out.println();
						wCheck = true;
					}
				}
				System.out.println("white's turn");
				wturn = false; 
				bturn = true;
			}
			else if(bturn){
				if(gameBoard.findCheck(bK[0], bK[1])){
					if(gameBoard.findCheckMate(bK)){
						System.out.println("Checkmate");
						System.out.println("White wins");
						break;
					}else{
						System.out.println("Check");
						System.out.println();
						bCheck = true;
					}
				}
				System.out.println("black's turn");
				wturn = true;
				bturn = false;
			}
			
			String move = br.readLine();
			if(move.equals("resign")&&bturn==false){
				System.out.println("White wins");
				break;
			}else if(move.equals("resign")&&bturn==true){
				System.out.println("Black wins!");
				break;
			}
			if(drawSign == true && move.equals("draw")){
				System.out.println("Draw");
				break;
			}
			if(move.length()==11){
				drawSign = true;
				move = move.substring(0,5);
			}
			int piece[] = gameBoard.map(move);
			if(!gameBoard.getPlayer(piece[0], piece[1]).getTurn()){
				System.out.println("It's not your turn");
				System.out.println();
				if(bturn){
					bturn = false;
					wturn = true;
				}
				else{
					bturn = true;
					wturn = false;
				}
				continue;
			}
			
			if(gameBoard.getPiece(piece[0], piece[1]).validPath(gameBoard, move)){
				int dest[] = gameBoard.map(move.substring(3, 5));
				Piece temp = gameBoard.getPiece(dest[0], dest[1]);
				boolean empty = false;
				if(gameBoard.emptyCheck(dest[0], dest[1])){
					empty = true;
				}
				if(gameBoard.getPiece(piece[0], piece[1]) instanceof King){
					gameBoard.getPiece(piece[0], piece[1]).setMoved();
				}
				if(gameBoard.getPiece(piece[0], piece[1]) instanceof Rook){
					gameBoard.getPiece(piece[0], piece[1]).setMoved();
				}
				gameBoard.setOccuppiedTile(gameBoard.getPiece(piece[0], piece[1]), move.substring(3,5));
				gameBoard.setEmptyTile(move.substring(0,2));
				//check Promotion
				if(gameBoard.getPiece(dest[0], dest[1]) instanceof Pawn){
					if(gameBoard.getPlayer(dest[0], dest[1]).getColor() == "white"){
						if(dest[0] == 0){
							Piece q2 = new Queen("wQ", gameBoard.getPlayer(dest[0], dest[1]));
							gameBoard.setOccuppiedTile(q2, dest[0], dest[1]);
						}
					}
					else if(gameBoard.getPlayer(dest[0], dest[1]).getColor() == "black"){
						if(dest[0] == 7){
							Piece q3 = new Queen("bQ", gameBoard.getPlayer(dest[0], dest[1]));
							gameBoard.setOccuppiedTile(q3, dest[0], dest[1]);
						}
					}
				}
				if(piece[0] == wK[0] && piece[1] == wK[1]){
					wK = gameBoard.map(move.substring(3,5));
				}
				if(piece[0] == bK[0] && piece[1] == bK[1]){
					bK = gameBoard.map(move.substring(3,5));
				}
				if(bCheck){
					boolean bkingmov = false;
					boolean wkingmov = false;
					if(piece[0] == wK[0] && piece[1] == wK[1]){
						wK = gameBoard.map(move.substring(3,5));
						wkingmov = true;
					}
					if(piece[0] == bK[0] && piece[1] == bK[1]){
						bK = gameBoard.map(move.substring(3,5));
						bkingmov = true;
					}
					if(gameBoard.findCheck(bK[0], bK[1])){
						gameBoard.setOccuppiedTile(gameBoard.getPiece(dest[0], dest[1]), move.substring(0,2));
						if(empty){
							gameBoard.setEmptyTile(dest[0], dest[1]);
						}
						else{
							gameBoard.setOccuppiedTile(temp, dest[0], dest[1]);
						}
						if(wkingmov){
							wK = dest;
						}
						if(bkingmov){
							bK = piece;
						}
						System.out.println("Illegal move, try again");
						System.out.println();
						if(bturn){
							bturn = false;
							wturn = true;
						}
						else{
							bturn = true;
							wturn = false;
						}
						continue;
					}
					else{
						bCheck = false;
					}
			
				}
				if(wCheck){
					boolean bkingmov = false;
					boolean wkingmov = false;
					if(piece[0] == wK[0] && piece[1] == wK[1]){
						wK = gameBoard.map(move.substring(3,5));
						wkingmov = true;
					}
					if(piece[0] == bK[0] && piece[1] == bK[1]){
						bK = gameBoard.map(move.substring(3,5));
						bkingmov = true;
					}
					if(gameBoard.findCheck(wK[0], wK[1])){
						gameBoard.setOccuppiedTile(gameBoard.getPiece(dest[0], dest[1]), move.substring(0,2));
						if(empty){
							gameBoard.setEmptyTile(move.substring(3,5));
						}
						else{
							gameBoard.setOccuppiedTile(temp, move.substring(3,5));
						}
						if(wkingmov){
							wK = piece;
						}
						if(bkingmov){
							bK = dest;
						}
						System.out.println("Illegal move, try again");
						System.out.println();
						if(bturn){
							bturn = false;
							wturn = true;
						}
						else{
							bturn = true;
							wturn = false;
						}
						continue;
					}
					else{
						wCheck = false;
					}
				}
			}

			else{
				System.out.println("Illegal move, try again");
				System.out.println();
				if(bturn){
					bturn = false;
					wturn = true;
				}
				else{
					bturn = true;
					wturn = false;
				}
				continue;
			}
			gameBoard.toogleturns();
		}
	}	
}
