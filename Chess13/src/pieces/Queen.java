package pieces;

import game.Board;
import game.Player;
import game.Tile;

public class Queen extends Piece{
	public Queen(String name, Player p){
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
