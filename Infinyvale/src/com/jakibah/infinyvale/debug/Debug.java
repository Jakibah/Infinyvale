package com.jakibah.infinyvale.debug;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Debug {
	public static boolean keydown = false;
	public static boolean open = false;
	public static boolean debugmode = true;
	
	
	public static void Update(){
		if(debugmode){
		if (!keydown && Keyboard.isKeyDown(Keyboard.KEY_F)) {
			open = true;
			keydown = true;
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_F)) {
            open = false;
			keydown = false;
		}
		if(Runtime.getRuntime().freeMemory() < 1000){
			System.out.println("Memory leaking!!!");
		}
		if(open){
			System.out.println("LWJGL version: " + Sys.getVersion());
			System.out.println("64x: " + Sys.is64Bit());
			System.out.println("Java location: " + System.getProperty("java.home"));
			System.out.println("Java version: " + System.getProperty("java.version"));
			System.out.println("Os name: " + System.getProperty("os.name"));
			System.out.println("Os version: " + System.getProperty("os.version"));
			System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
			System.out.println("Used memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
			System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
			System.out.println("Cpu: " + System.getenv("PROCESSOR_IDENTIFIER"));
			System.out.println("Cpu cores: " + System.getenv("NUMBER_OF_PROCESSORS"));
			System.out.println("Gpu: " + Display.getAdapter());
			System.out.println();
			
			
			
			
		}
		}
	}

}
