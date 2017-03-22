package pieces;

import game.Player;
import game.Board;

public class King extends Piece{
	
	boolean moved = false;
	 
	public King(String name, Player p){
		super(name, p);
	}
	
	public void setMoved(){
		this.moved = true;
	}
	
	public boolean getMoved(){
		return this.moved;
	}
	
	@Override
	 public boolean validPath(Board board, String s){
		int start[] = board.map(s.substring(0, 2));
		int dest[] = board.map(s.substring(3,5));
		//case 1: Moving up
		if(start[1] == dest[1] && start[0] > dest[0]){
			int x = start[0] - 1;
			if(dest[0] == x){
				if(board.emptyCheck(x, start[1])){
					return true;
				}
				else if(board.getPiece(x, start[1]).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		}
		//case 2: Moving down
		if(start[1] == dest[1] && start[0] < dest[0]){
			int x = start[0] +1;
			if(dest[0] == x){
				if(board.emptyCheck(x, start[1])){
					return true;
				}
				else if(board.getPiece(x, start[1]).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		}
		//case 3: Moving to the right
		if(start[1] < dest[1] && start[0] == dest[0]){
			int y = start[1] +1;
			if(dest[1] == y){
				if(board.emptyCheck(start[0], y)){
					return true;
				}
				else if(board.getPiece(start[0], y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		}
		//case 4: Moving to the left
		if(start[1] > dest[1] && start[0] == dest[0]){
			int y = start[1] -1;
			if(dest[1] == y){
				if(board.emptyCheck(start[0], y)){
					return true;
				}
				else if(board.getPiece(start[0], y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		}
		//case 5: moving up and to the right
		if(dest[0] == start[0]+1 && dest[1] == start[1] +1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 6: moving up and to the left
		if(dest[0] == start[0]+1 && dest[1] == start[1] -1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 7: moving down and to the right
		if(dest[0] == start[0]-1 && dest[1] == start[1] +1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 8: moving down and to the left
		if(dest[0] == start[0]-1 && dest[1] == start[1] -1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 9: castling request
		if(dest[1] == start[1] +2 || dest[1] == start[1]-2){
			if(!board.findCheck(start[0], start[1])){
				//for black King
				if(start[0] == 0 && start[1] == 4 && this.moved == false){
					//check moving to the right 
					//check if the tiles are empty
					if(board.emptyCheck(0, 5) && board.emptyCheck(0, 6)){
						board.setOccuppiedTile(board.getPiece(start[1], start[0]), "g8");
						if(!board.findCheck(0, 6)){
							if(!board.emptyCheck(0, 7)){
								if(board.getPiece(0, 7) instanceof Rook){
									if(board.getPiece(0, 7).getMoved() == false){
										board.setOccuppiedTile(board.getPiece(0, 7), "f8");
										board.setEmptyTile(0, 7);
										return true;
									}
									else{
										board.setEmptyTile("g8");
									}
								}
								else{
									board.setEmptyTile("g8");
								}
							}
							else{
								board.setEmptyTile("g8");
							}
						}
						else{
							board.setEmptyTile("g8");
						}
					}
					//check moving to the left
					if(board.emptyCheck(0, 3) && board.emptyCheck(0, 2) && board.emptyCheck(0, 1)){
						board.setOccuppiedTile(board.getPiece(start[1], start[0]), "c8");
						if(!board.findCheck(0, 2)){
							if(!board.emptyCheck(0, 0)){
								if(board.getPiece(0, 0) instanceof Rook){
									if(board.getPiece(0, 0).getMoved() == false){
										board.setOccuppiedTile(board.getPiece(0, 0), "d8");
										board.setEmptyTile(0, 0);
										return true;
									}
									else{
										board.setEmptyTile("c8");
									}
								}
								else{
									board.setEmptyTile("c8");
								}
							}
							else{
								board.setEmptyTile("c8");
							}
						}
						else{
							board.setEmptyTile("c8");
						}
					}
				}
				//for white king
				if(start[0] == 7 && start[1] == 4 && this.moved == false){
					//check moving to the right 
					//check if the tiles are empty
					if(board.emptyCheck(7, 5) && board.emptyCheck(7, 6)){
						board.setOccuppiedTile(board.getPiece(start[1], start[0]), "g1");
						if(!board.findCheck(7, 6)){
							if(!board.emptyCheck(7, 7)){
								if(board.getPiece(7, 7) instanceof Rook){
									if(board.getPiece(7, 7).getMoved() == false){
										board.setOccuppiedTile(board.getPiece(7, 7), "f1");
										board.setEmptyTile(7, 7);
										return true;
									}
									else{
										board.setEmptyTile("g1");
									}
								}
								else{
									board.setEmptyTile("g1");
								}
							}
							else{
								board.setEmptyTile("g1");
							}
						}
						else{
							board.setEmptyTile("g1");
						}
					}
					//check moving to the left
					if(board.emptyCheck(7, 3) && board.emptyCheck(7, 2) && board.emptyCheck(7, 1)){
						board.setOccuppiedTile(board.getPiece(start[1], start[0]), "c1");
						if(!board.findCheck(7, 2)){
							if(!board.emptyCheck(7, 0)){
								if(board.getPiece(7, 0) instanceof Rook){
									if(board.getPiece(7, 0).getMoved() == false){
										board.setOccuppiedTile(board.getPiece(7, 0), "d1");
										board.setEmptyTile(7, 0);
										return true;
									}
									else{
										board.setEmptyTile("c1");
									}
								}
								else{
									board.setEmptyTile("c1");
								}
							}
							else{
								board.setEmptyTile("c1");
							}
						}
						else{
							board.setEmptyTile("c1");
						}
					}
				}
			}
		}
		return false;
	}
	 @Override
	 public String toString(){
		 return getName();
	 }

}
