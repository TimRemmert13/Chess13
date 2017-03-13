package pieces;

import game.Player;
import game.Tile;

public class Queen extends Piece{
	public Queen(String name, Player p){
		super(name, p);
	}
	//leaving blank for now will implement later
	 public boolean validPath(String s){
		 return false;
	 }
	 public String getType(){
		 return "Queen";
	 }
	 @Override
	 public String toString(){
		 return getName();
	 }

}
