package com.jakibah.infinyvale.enums;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public enum Race {
	
	Human("human");
	
	public String namelist;
	
	Race(String namelist){
		this.namelist = namelist;
	}

	public String getNamelist() {
		return namelist;
	}

	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}
	public String getName(Race r, String gender){
		File f = new File("names/" + r.getNamelist() + "/" + gender + ".names");
		
		List<String> lines = null;
		try {
			lines = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		return lines.get(rand.nextInt(lines.size()));
		
	}

}
