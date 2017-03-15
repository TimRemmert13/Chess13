package pieces;

import game.Player;
import game.Board;
import game.Tile;

public class Pawn extends Piece{
	
	public Pawn(String name, Player p){
		super(name, p);
	}
	
	@Override
	 public boolean validPath(Board board, String input){
		int start[] = board.map(input.substring(0, 2));
		int dest[] = board.map(input.substring(3,5));
		if(this.getPlayer().getColor() == "black"){
			//starting position pawn can jump a space
			if(start[0] == 1){
				if(dest[0] == start[0] +1){
					if(board.emptyCheck(start[0]+1, start[1])){
						return true;
					}
				}
					if(dest[0] == start[0] +2){
						if(board.emptyCheck(start[0]+1, start[1]) && board.emptyCheck(start[0] +1,  start[1])){
							return true;
						}
					}
				}
			
				// not starting position pawn
				else if (dest[0] == start[0] +1){
					if(board.emptyCheck(start[0]+1, start[1])){
						return true;
					}	
			}
			// taking another players piece
			if(dest[0] == start[0] +1 && dest[1] == start[1]+1){
				if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
					return true;
				}
				else{
					return false;
				}
			}
			
		}
		if(this.getPlayer().getColor() == "white"){
			//starting position pawn can jump a space
			if(start[0] == 6){
				if(dest[0] == start[0] -1){
					if(board.emptyCheck(start[0]-1, start[1])){
						return true;
					}
				}
					else if(dest[0] == start[0] -2){
						if(board.emptyCheck(start[0]-1, start[1]) && board.emptyCheck(start[0] -1,  start[1])){
							return true;
						}
					}
				}
				// not starting position pawn
				else if (dest[0] == start[0] -1){
					if(board.emptyCheck(start[0]-1, start[1])){
						return true;
					}	
			}
			// taking another players piece
			if(dest[0] == start[0] -1 && dest[1] == start[1]-1){
				if(board.getPlayer(dest[0], dest[1]) != this.getPlayer()){
					return true;
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
