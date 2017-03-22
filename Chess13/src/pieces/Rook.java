package pieces;

import game.Board;
import game.Player;
import game.Tile;

public class Rook extends Piece{
	
	boolean moved = false;
	
	public Rook(String name, Player p){
		super(name, p);
	}
	
	public void setMoved(){
		this.moved = true;
	}
	
	public boolean getMoved(){
		return this.moved;
	}
	
	@Override
	 public boolean validPath(Board board,String s){
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
			//not on desired tile yet
			while(x != dest[0]){
				if(!board.emptyCheck(x, dest[1])){
					return false;
				}
				else{
					x --;
				}
			}
			//check if this is the tile we want
			if(board.emptyCheck(x, dest[1])){
				return true;
			}
			else if(board.getPiece(x, dest[1]).getPlayer() != this.getPlayer()){
				return true;
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
			//not on desired tile yet
			while(x != dest[0]){
				if(!board.emptyCheck(x, dest[1])){
					return false;
				}
				else{
					x ++;
				}
			}
			//check if this is the tile we want
			if(board.emptyCheck(x, dest[1])){
				return true;
			}
			else if(board.getPiece(x, dest[1]).getPlayer() != this.getPlayer()){
				return true;
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
			//not on desired tile yet
			while(y != dest[1]){
				if(!board.emptyCheck(dest[0], y)){
					return false;
				}
				else{
					y ++;
				}
			}
			//check if this is the tile we want
			if(board.emptyCheck(dest[0], y)){
				return true;
			}
			else if(board.getPiece(dest[0], y).getPlayer() != this.getPlayer()){
				return true;
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
			//not on desired tile yet
			while(y != dest[1]){
				if(!board.emptyCheck(dest[0], y)){
					return false;
				}
				else{
					y --;
				}
			}
			//check if this is the tile we want
			if(board.emptyCheck(dest[0], y)){
				return true;
			}
			else if(board.getPiece(dest[0], y).getPlayer() != this.getPlayer()){
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
