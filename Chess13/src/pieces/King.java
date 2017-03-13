package pieces;

import game.Player;
import game.Tile;

public class King extends Piece{
	 
	public King(String name, Player p){
		super(name, p);
	}
	//leaving blank for now will implement later
	 public boolean validPath(String s){
		 return false;
	 }
	 public String getType(){
		 return "King";
	 }
	 @Override
	 public String toString(){
		 return getName();
	 }

}
