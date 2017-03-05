package pieces;

import game.Player;
import game.Tile;

public class Bishop extends Piece {
	public Bishop(String name, Tile tile, Player p){
		super(name, tile, p);
	}
	//leaving blank for now will implement later
	 public boolean validPath(String s){
		 return false;
	 }
	 public String getType(){
		 return "Bishop";
	 }

}
