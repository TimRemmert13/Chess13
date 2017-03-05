package game;

import pieces.Piece;

public class Tile {
	
	private String location;
	
	private Piece piece;
	
	private String color;
	
	public Tile(String loc, Piece p, String col){
		this.location = loc;
		this.piece = p;
		this.color = col;
	}
	public void setColor(String color){
		this.color = color;
	}
	
	public void setLoc(String location){
		this.location = location;
	}
	public void setPiece(Piece p){
		this.piece = p;
	}
	public String getColor(){
		return this.color;
	}
	public String getLoc(){
		return this.location;
	}
	public Piece getPiece(){
		return this.piece;
	}
	public String toString(){
		return this.location;
	}
	

}
