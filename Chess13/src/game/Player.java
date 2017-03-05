package game;

public class Player {
	
	private String color;
	
	public Player(String color){
		this.color = color;
	}
	
	public void setPlayer(String color){
		this.color = color;
	}
	
	public String getPlayer(){
		return this.color;
	}
	
	public String toString(){
		return this.color;
	}

}
