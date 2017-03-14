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
		 return false;
	 }

	 @Override
	 public String toString(){
		 return getName();
	 }

}
