package pieces;

import game.Board;
import game.Player;
import game.Tile;

public class Knight extends Piece{
	public Knight(String name, Player p){
		super(name, p);
	}
	
	@Override
	 public boolean validPath(Board board,String s){
		int start[] = board.map(s.substring(0, 2));
		int dest[] = board.map(s.substring(3,5));
		//case 1: moving down and to the left
		if(dest[0] == start[0]+2 && dest[1] == start[1] -1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 2: moving down and to the right
		if(dest[0] == start[0]+2 && dest[1] == start[1] +1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 3: moving up and to the left
		if(dest[0] == start[0]-2 && dest[1] == start[1] -1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 4: moving up and to the right
		if(dest[0] == start[0]-2 && dest[1] == start[1] +1){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 5: Moving to the left and down
		if(dest[0] == start[0]+1 && dest[1] == start[1] -2){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 6: Moving to the right and down
		if(dest[0] == start[0]+1 && dest[1] == start[1] + 2){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 7: Moving to the right and up
		if(dest[0] == start[0]-1 && dest[1] == start[1] +2){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		//case 8: Moving to the left and up
		if(dest[0] == start[0]-1 && dest[1] == start[1] -2){
			if(board.emptyCheck(dest[0], dest[1])){
				return true;
			}
			else if(board.getPiece(dest[0], dest[1]).getPlayer() != this.getPlayer()){
				return true;
			}
		}
		return false;
	}
	 
	 @Override
	 public String toString(){
		 return getName();
	 }

}
