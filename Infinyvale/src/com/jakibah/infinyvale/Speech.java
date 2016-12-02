package com.jakibah.infinyvale;

import java.util.ArrayList;
import java.util.Random;

import com.jakibah.infinyvale.enums.Race;

public class Speech {
	
	
	static ArrayList<ArrayList<String>> HumanMale = new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>> HumanFemale = new ArrayList<ArrayList<String>>();
	
	public static void Start(){
		
		//create array
		ArrayList<String> HaveANiceDay = new ArrayList<String>();
		
		//add text
		HaveANiceDay.add("Have a nice day my friend.");
		
		//adding to database
		HumanMale.add(HaveANiceDay);
		HumanFemale.add(HaveANiceDay);
	}
	
	public static ArrayList<String> get(Race r, String gender){
		Random rand = new Random();
		if(r == Race.Human && gender == "male"){
			return HumanMale.get(rand.nextInt(HumanMale.size()));
		}
		if(r == Race.Human && gender == "female"){
			return HumanFemale.get(rand.nextInt(HumanFemale.size()));
		}
		return null;
		
	}

}
