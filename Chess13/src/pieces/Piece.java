package pieces;

import game.Player;
import game.Tile;

public abstract class Piece {
	
	  private String name;
	  
	  private Player player;
	  
	  public Piece(String name, Player p){
		  this.name = name;
		  this.player = player;
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
	  
	  public abstract String getType();
	  
	  public abstract boolean validPath(String s);
	  
	  public abstract String toString();

}
