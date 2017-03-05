package game;

import pieces.Piece;

public class Board {
	
	Tile board[][];
	
	public Board(){
		
	}
	public void buildBoard(){
		
		//initialize lower part labeling letter columns
		this.board[9][1].setLoc(" a");
		this.board[9][2].setLoc(" b");
		this.board[9][3].setLoc(" c");
		this.board[9][4].setLoc(" d");
		this.board[9][5].setLoc(" e");
		this.board[9][6].setLoc(" f");
		this.board[9][7].setLoc(" g");
		this.board[9][8].setLoc(" h");
		
		//initialize rightmost part labeling number rows
		this.board[8][9].setLoc(" 1");
		this.board[7][9].setLoc(" 2");
		this.board[6][9].setLoc(" 3");
		this.board[5][9].setLoc(" 4");
		this.board[4][9].setLoc(" 5");
		this.board[3][9].setLoc(" 6");
		this.board[2][9].setLoc(" 7");
		this.board[1][9].setLoc(" 8");
		
		//set locations of actual board
		//the a column
		for(int i = 8; i > 1; i --){
			this.board[i][0].setLoc("a" + i);
		}
		//the b column
		for(int i = 8; i > 1; i --){
			this.board[i][1].setLoc("b" + i);
		}
		//the c column
		for(int i = 8; i > 1; i --){
			this.board[i][2].setLoc("c" + i);
		}
		//the d column
		for(int i = 8; i > 1; i --){
			this.board[i][3].setLoc("d" + i);
		}
		//the e column
		for(int i = 8; i > 1; i --){
			this.board[i][4].setLoc("e" + i);
		}
		//the f column
		for(int i = 8; i > 1; i --){
			this.board[i][5].setLoc("f" + i);
		}
		// the g column
		for(int i = 8; i > 1; i --){
			this.board[i][6].setLoc("g" + i);
		}
		//for the h column
		for(int i = 8; i > 1; i --){
			this.board[i][7].setLoc("h" + i);
		}	
		
		//initialize colors of the tiles in the board
		for(int i = 0; i < 9; i ++){
			for(int k = 0; k < 9; k ++){
				if(i % 2 == 0 && k % 2 != 0){
					this.board[i][k].setColor("white");		
				}
				else if(i % 2 != 0 && k % 2 == 0){
					this.board[i][k].setColor("black");
				}
			}
		}
		}
	public Tile getLoc(int x, int y){
		return this.board[x][y];
		
	}
	public void setLoc(int x, int y, Piece p){
		this.board[x][y].setPiece(p);
	}
	//doesn't work right now I'm still working on it
	public void printBoard(){
		
		for(int i = 0; i < 9; i++){
			for(int k = 0; k < 9; k ++){
				if( i == 9){
					System.out.print(this.board[9][k].getLoc());
				}
				else if( k == 9){
					System.out.print(this.board[i][9].getLoc());
				}
				else if(this.board[i][k].getPiece() == null){
					if(this.board[i][k].getColor() == "black"){
						System.out.print("##");
					}
					else{
						System.out.print("  ");
					}
				}
				else if(this.board[i][k].getPiece() != null){
					System.out.print(board[i][k].getPiece());
					
				}
			}
			System.out.printf("\n");
		}
		
	}
		
	}
	



