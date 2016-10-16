package com.jakibah.infinyvale;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.lwjgl.opengl.Display;

public class World {

	private File file;
	private String world;
	private boolean newworld;
	private int loadedchunk;
	private BufferedWriter worldwriter = null;
	private Chunk ChunktoLoad;
	private boolean First = true;

	public World(String world) throws IOException {
		this.world = world;
		file = new File("worlds/" + world + ".world");
		if (!file.exists()) {
			newworld = true;
			file.createNewFile();
			worldwriter = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);

			worldwriter.write("loadedchunk: " + 0);
			worldwriter.flush();

		} else {
			worldwriter = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			newworld = false;

			List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			loadedchunk = Integer.parseInt(lines.get(0).substring(13, lines.get(0).length()));

		}

	}

	public void Update() throws IOException {
		HandlePlayerScreen();
		List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		if (!lines.contains("chunk: " + loadedchunk + " (")) {
			// one character is 1 byte 1 chunk = 917 bytes = 0,917 kb = 0,000917
			// mb
			// 1 gb world = 1090513 chunks
			// 1 mb world = 1090 chunks

			System.out.println(loadedchunk);
			worldwriter.newLine();
			ChunktoLoad = new Chunk(loadedchunk);
			worldwriter.write("chunk: " + loadedchunk + " (");
			worldwriter.newLine();
			worldwriter.write("map: ");

			for (int i = 0; i < ChunktoLoad.getMap().length; i++) {
				for (int j = 0; j < ChunktoLoad.getMap()[i].length; j++) {
					int towrite = 0;
					Tile t = ChunktoLoad.map[i][j];
					switch (t.getType()) {
					case Test:
						towrite = 0;
						break;
					case Test2:
						towrite = 1;
						break;

					}
					worldwriter.write(towrite + ", ");
					System.out.println("Loading new Chunk");
				}
			}
			First = false;

			worldwriter.flush();
		} else {
			if (First == true) {
				int x = lines.indexOf("chunk: " + loadedchunk + " (");
				x = x + 1;
				String s = lines.get(x);
				s = s.substring(5, s.length() - 2);
				char[] c = s.toCharArray();
				int TilesWide = Display.getWidth() / 32;
				int TileHeight = Display.getHeight() / 32;
				int[][] newMap = new int[TilesWide][TileHeight];
				int towrite = 0;
				int chartowrite = 0;
				
				for (int i = 0; i < newMap.length; i++) {
					for (int j = 0; j < newMap[i].length; j++) {
						Character character = c[chartowrite];
						chartowrite = chartowrite + 3;
							if (character != ',' && character != ' ') {
								towrite = Integer.parseInt(character.toString());
								newMap[i][j] = towrite;

							
						}
					}
				}

				ChunktoLoad = new Chunk(newMap, loadedchunk);
				First = false;

			}
		}

		ChunktoLoad.Update();
		// System.out.println(ChunktoLoad.getID());
	}

	

	public void HandlePlayerScreen() {
		if (Game.p.getX() >= Display.getWidth()) {
			Game.p.setX(1);
			loadedchunk++;
			First = true;
		}
		if (Game.p.getX() <= -32) {
			Game.p.setX(Display.getWidth() - 32);
			loadedchunk--;
			First = true;
		}
		if (Game.p.getY() <= -32) {
			Game.p.setY(Display.getHeight() - 32);
			loadedchunk = loadedchunk + 100;
			First = true;
		}
		if (Game.p.getY() >= Display.getHeight()) {
			Game.p.setY(1);
			loadedchunk = loadedchunk - 100;
			First = true;
		}
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

	public Chunk getChunktoLoad() {
		return ChunktoLoad;
	}

	public void setChunktoLoad(Chunk chunktoLoad) {
		ChunktoLoad = chunktoLoad;
	}

}
