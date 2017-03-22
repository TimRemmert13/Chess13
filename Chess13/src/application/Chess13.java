//By Tim Remmert and Mengyu Gong
package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import game.*;
import pieces.*;

public class Chess13 {

	public static void main(String[] args)
			throws IOException {
		//create buffer reader to read players input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//create board and print
		Board gameBoard = new Board(8,8);
		System.out.println();
		boolean inCheck = false;
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
			//if()
			if (wturn){
				if(gameBoard.findCheck(wK[0], wK[1])){
					if(gameBoard.findCheckMate(wK)){
						System.out.println("Checkmate");
						System.out.println("Black wins!");
						break;
					}else{
						System.out.println("Check");
						System.out.println();
						inCheck = true;
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
						System.out.println("White wins!");
						break;
					}else{
						System.out.println("Check");
						System.out.println();
						inCheck = true;
					}
				}
				System.out.println("black's turn");
				wturn = true;
				bturn = false;
			}
			
			String move = br.readLine();
			if(move.equals("resign")&&bturn==false){
				System.out.println("White wins!");
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
			if(piece[0] == wK[0] && piece[1] == wK[1]){
				wK = gameBoard.map(move.substring(3,5));
			}
			if(piece[0] == bK[0] && piece[1] == bK[1]){
				bK = gameBoard.map(move.substring(3,5));
			}
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
			if(!(gameBoard.getPiece(piece[0], piece[1]) instanceof King) && inCheck){
				System.out.println("You are in Check; you can only move your King");
				System.out.println();
				if(wturn){
					wturn = false;
					bturn = true;
					continue;
				}
				else{
					wturn = true;
					bturn = false;
					continue;
				}
			}
			else{
				inCheck = false;
			}
			if(gameBoard.getPiece(piece[0], piece[1]).validPath(gameBoard, move)){
				int dest[] = gameBoard.map(move.substring(3, 5));
				gameBoard.setOccuppiedTile(gameBoard.getPiece(piece[0], piece[1]), move.substring(3,5));
				gameBoard.setEmptyTile(move.substring(0,2));
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
