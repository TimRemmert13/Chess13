package game;

public class Player {
	
	private String color;
	
	private boolean turn = false;
	
	public Player(String color){
		this.color = color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public boolean getTurn(){
		return this.turn;
	}
	
	public void toggleTurn(){
		if(this.turn == false){
			this.turn = true;
		}
		else{
			this.turn = false;
		}
	}
	
	public String toString(){
		return this.color;
	}

}
