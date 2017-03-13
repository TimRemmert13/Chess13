package game;

import pieces.Piece;

public abstract class Tile {
	
	protected final String coordinate;
	
	public Tile(String coordinate){
		this.coordinate = coordinate;
	}
	 public abstract boolean isEmpty();
	 
	 public abstract Piece getPiece();
	 
	 public static final class EmptyTile extends Tile{
		 
		 public EmptyTile(String coordinate){
			 super(coordinate);
		 }
		 
		 @Override
		 public boolean isEmpty(){
			 return true;
		 }
		 
		 @Override
		 public Piece getPiece(){
			 return null;
		 }
	 }
	 
	 public static final class OccupiedTile extends Tile{
		 
		 private Piece piece;
		 
		 public OccupiedTile(String coordinate, Piece piece){
			 super(coordinate);
			 this.piece = piece;
		 }
		 
		 @Override 
		 public boolean isEmpty(){
			 return false;
		 }
		 
		 @Override
		 public Piece getPiece(){
			 return this.piece;
		 }
	 }

}
