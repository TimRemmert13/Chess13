package pieces;

import game.Player;
import game.Board; 
import game.Tile;

public class Bishop extends Piece {
	public Bishop(String name, Player p){
		super(name, p);
	}
	
	@Override
	public boolean validPath(Board board, String input){
		int start[] = board.map(input.substring(0, 2));
		int dest[] = board.map(input.substring(3,5));
		//case 1: moving diagonally up to the left
		if(start[0] > dest[0] && start[1] > dest[1]){
			int x = start[0] - 1;
			int y = start[1] - 1;
			if(dest[0] == x && dest[1] == y){
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
			while(x != dest[0] && y != dest[1]){
				//if this is not the desired tile to move to
					if(!board.emptyCheck(x,y)){
						return false;
					}
					else{
						x --;
						y --;
					}
				}
				//if this is the tile we want to move to
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		//case 2: moving diagonally down to the right
		if(start[0] < dest[0] && start[1] < dest[1]){
			int x = start[0] + 1;
			int y = start[1] + 1;
			if(dest[0] == x && dest[1] == y){
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
			while(x != dest[0] && y != dest[1]){
				//if this is not the desired tile to move to
					if(!board.emptyCheck(x,y)){
						return false;
					}
					else{
						x ++;
						y ++;
					}
				}
				//if this is the tile we want to move to
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		//case 3: moving diagonally down to the left
		if(start[0] < dest[0] && start[1] > dest[1]){
			int x = start[0] + 1;
			int y = start[1] - 1;
			if(dest[0] == x && dest[1] == y){
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
			while(x != dest[0] && y != dest[1]){
				//if this is not the desired tile to move to
					if(!board.emptyCheck(x,y)){
						return false;
					}
					else{
						x ++;
						y --;
					}
				}
				//if this is the tile we want to move to
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
		//case 4: moving diagonally up to the right
		if(start[0] > dest[0] && start[1] < dest[1]){
			int x = start[0] - 1;
			int y = start[1] + 1;
			if(dest[0] == x && dest[1] == y){
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
					return true;
				}
			}
			while(x != dest[0] && y != dest[1]){
				//if this is not the desired tile to move to
					if(!board.emptyCheck(x,y)){
						return false;
					}
					else{
						x --;
						y ++;
					}
				}
				//if this is the tile we want to move to
				if(board.emptyCheck(x, y)){
					return true;
				}
				else if (board.getPiece(x, y).getPlayer() != this.getPlayer()){
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
