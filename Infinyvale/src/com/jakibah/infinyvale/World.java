package com.jakibah.infinyvale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class World {

	private File file;
	private String world;
	private boolean newworld;
	private int loadedchunk;
	private BufferedWriter worldwriter = null;
	private Chunk ChunktoLoad;

	public World(String world) throws IOException {
		this.world = world;
		file = new File("worlds/" + world + ".world");
		if (!file.exists()) {
			newworld = true;
			file.createNewFile();
			worldwriter = Files.newBufferedWriter(file.toPath(),
					StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			
			worldwriter.write("loadedchunk: " + 0);
			worldwriter.flush();

		} else {
			worldwriter = Files.newBufferedWriter(file.toPath(),
					StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			newworld = false;

			List<String> lines = Files.readAllLines(file.toPath(),
					StandardCharsets.UTF_8);
			loadedchunk = Integer.parseInt(lines.get(0).substring(13,
					lines.get(0).length()));

		}

	}

	public void Update() throws IOException {
		List<String> lines = Files.readAllLines(file.toPath(),
				StandardCharsets.UTF_8);
		if(!lines.contains("chunk: " + loadedchunk)){
			System.out.println(loadedchunk);
			worldwriter.newLine();
			ChunktoLoad = new Chunk(loadedchunk);
			worldwriter.write("chunk: " + loadedchunk);worldwriter.newLine();
			worldwriter.write("map: " + ChunktoLoad.getMap());
			worldwriter.flush();
		}
		ChunktoLoad.Update();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getWorld() {
		return world;
	}

	public boolean isNewworld() {
		return newworld;
	}

	public int getLoadedchunk() {
		return loadedchunk;
	}

	public void setLoadedchunk(int loadedchunk) {
		this.loadedchunk = loadedchunk;
	}

}
