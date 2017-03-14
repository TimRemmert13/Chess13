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
		 return false;
	 }
	 
	 @Override
	 public String toString(){
		 return getName();
	 }

}
