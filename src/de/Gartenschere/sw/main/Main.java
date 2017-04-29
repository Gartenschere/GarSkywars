package de.Gartenschere.sw.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.Gartenschere.sw.commands.CMDstart;
import de.Gartenschere.sw.gamestates.GameState;
import de.Gartenschere.sw.gamestates.GameStateHandler;
import de.Gartenschere.sw.gamestates.LobbyState;
import de.Gartenschere.sw.listeners.EVENTjoin;
import de.Gartenschere.sw.listeners.EVENTquit;
import de.Gartenschere.sw.methods.var;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	
	public void onEnable() {
	   plugin = this;
	   new GameStateHandler();
	   GameStateHandler.setGameState(GameState.LOBBY_STATE);
	   init();
	   System.out.println("[Skywars] Das Plugin wurde fehlerfrei gestartet!");
	   for(Player p : Bukkit.getOnlinePlayers()) { var.playing.add(p);
		   
	   }
	   
	}

	   public void onDisable() {
			LobbyState ls = (LobbyState) GameStateHandler.getCurrentGameState();
			ls.getCountdown().stop();
	   
			
	 
		 
		   System.out.println("[Skywars] Das Plugin wurde fehlerfrei gestoppt!");
		   

}
	private void init() {
		
		this.getCommand("start").setExecutor(new CMDstart());
		
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents((Listener) new EVENTjoin(), this);
		pm.registerEvents((Listener) new EVENTquit(), this);
		
		
	}
  
	public static Main getPlugin() {
		return plugin;
	}
	
}
	