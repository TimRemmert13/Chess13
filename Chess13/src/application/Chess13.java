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
		gameBoard.printBoard();
		System.out.println();
		//initialize turns
		System.out.println("whites turn");
		String move = br.readLine();
		int temp[] = gameBoard.map(move);
		Piece p = gameBoard.getPiece(temp[0], temp[1]);
		if(p.validPath(gameBoard, move)){
			System.out.println("It Works!!!!!!!");
		}
		else{
			System.out.println("Failed");
		}
	}

}
