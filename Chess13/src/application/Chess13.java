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
		boolean checkmate = false;
		boolean wturn = true;
		boolean bturn = false;
		gameBoard.getPlayer(7, 0).toggleTurn();
		
		while(!checkmate){
			gameBoard.printBoard();
			System.out.println();
			if (wturn){
				System.out.println("white's turn");
				wturn = false; 
				bturn = true;
			}
			else if(bturn){
				System.out.println("black's turn");
				wturn = true;
				bturn = false;
			}
			String move = br.readLine();
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
				gameBoard.setOccuppiedTile(gameBoard.getPiece(piece[0], piece[1]), move.substring(3,5));
				gameBoard.setEmptyTile(move.substring(0,2));
			}
			else{
				System.out.println("Invalid move");
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
