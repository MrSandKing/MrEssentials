package com.mrsandking.mressentials.utils;

import java.util.List;

import com.mrsandking.mressentials.MrEssentials;

public class ProtectedWorldsUtils {
	
	public static List<String> protectedworlds;
	
	private static boolean prot;
	
	public static List<String> getProtectedWorlds() {
		return protectedworlds;
	}
	
	public static void loadProtectedWorlds() {
		protectedworlds = MrEssentials.getInstance().getConfig().getStringList("protected-worlds");
	}
	
	public static boolean getProtect() {
		return prot;
	}
	
	public static void setProtect(boolean protect) {
		prot = protect;
	}
	
}
