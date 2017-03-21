package pieces;

import game.Player;
import game.Tile;
import game.Board;

public abstract class Piece {
	
	  private String name;
	  
	  private Player player;
	  
	  public Piece(String name, Player p){
		  this.name = name;
		  this.player = p;
	  }

	public void setName(String s){
		   this.name = s;
	  }
	  
	  public void setPlayer(Player p){
		  this.player = p;
	  }
	  
	  public String getName(){
		  return this.name;
	  }
	  
	  public Player getPlayer(){
		  return this.player;
	  }
	  
	  public abstract boolean validPath(Board board, String input);
	 
	  
	  public abstract String toString();

}
