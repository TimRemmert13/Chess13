package pieces;

import game.Player;
import game.Tile;

public class Bishop extends Piece {
	public Bishop(String name, Player p){
		super(name, p);
	}
	//leaving blank for now will implement later
	 public boolean validPath(String s){
		 return false;
	 }
	 public String getType(){
		 return "Bishop";
	 }
	 @Override
	 public String toString(){
		 return getName();
	 }

}
