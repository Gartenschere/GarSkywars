package de.Gartenschere.sw.methods;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class var {
	
	public static final String pr = "§4[Skywars]",
			             noperm = pr + "§cNicht Genügend Rechte!";
	
	public static boolean canMove = true,
			              canAttack = false,
			              canBuild = false;
	
	
	public static File cfgFile = new File("plugins//SkyWars//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);
	
	public static ArrayList<Player> playing =new ArrayList<>();
	public static ArrayList<Player> Spectating =new ArrayList<>();
	
}
