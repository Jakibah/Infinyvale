package com.jakibah.infinyvale;

public class Main {
	
	public static String state = "Game";

	public static void main(String[] args) {
		Canvas.CreateCanvas(640, 480, "Infinyvale", 60);

	}
	public static void Start(){
		//Menu.Start();
		Game.Start();
		
	}
	public static void Update(){
		if(state.equals("Menu")){
			//Menu.Update();
		}
		if(state.equals("Game")){
			Game.Update();
		}
	}
	
	public static void Stop(){
		//Menu.Stop();
		Game.Stop();
	}
	
	

}
