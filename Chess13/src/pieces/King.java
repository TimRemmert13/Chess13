package pieces;

import game.Player;
import game.Board;

public class King extends Piece{
	 
	public King(String name, Player p){
		super(name, p);
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
		return false;
	 }
	 @Override
	 public String toString(){
		 return getName();
	 }

}
