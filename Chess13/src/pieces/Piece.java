package pieces;

import game.Player;
import game.Tile;

public abstract class Piece {
	
	  private String name;
	  
	  private Tile tile;
	  
	  private Player player;
	  
	  public Piece(String name, Tile tile, Player p){
		  this.name = name;
		  this.tile = tile;
		  this.player = player;
	  }
	  
	  public void setName(String s){
		   this.name = s;
	  }
	  
	  public void setPlayer(Player p){
		  this.player = p;
	  }
	  
	  public void setTile(Tile t){
		  this.tile = t;
	  }
	  
	  public String getName(){
		  return this.name;
	  }
	  
	  public Tile getTile(){
		  return this.tile;
	  }
	  
	  public Player getPlayer(){
		  return this.player;
	  }
	  
	  public abstract String getType();
	  
	  public abstract boolean validPath(String s);

}
