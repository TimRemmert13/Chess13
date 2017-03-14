package pieces;

import game.Player;
import game.Board;

public class King extends Piece{
	 
	public King(String name, Player p){
		super(name, p);
	}
	
	@Override
	 public boolean validPath(Board board, String s){
		 return false;
	 }
	 @Override
	 public String toString(){
		 return getName();
	 }

}
