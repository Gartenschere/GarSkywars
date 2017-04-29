package de.Gartenschere.sw.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.Gartenschere.sw.gamestates.GameStateHandler;
import de.Gartenschere.sw.gamestates.LobbyState;
import de.Gartenschere.sw.methods.var;

public class EVENTjoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
	
	Player p = e.getPlayer();
	e.setJoinMessage(null);
	if(GameStateHandler.getCurrentGameState() instanceof LobbyState) {
		LobbyState ls = (LobbyState) GameStateHandler.getCurrentGameState();
		
		var.playing.add(p);
		Bukkit.broadcastMessage(var.pr+ " §7Der Spieler §a" +p.getDisplayName()+" §7ist beigetreten. ["+var.playing.size()+ "/" +LobbyState.MAX_PLAYERS+"§7]");
		if(var.playing.size() >= LobbyState.MIN_PLAYERS) {
			if(ls.getCountdown().isRunning == false) {
				ls.getCountdown().stopIdle();
				ls.getCountdown().start();
			
				
			}
   }
		if(var.playing.size() < LobbyState.MIN_PLAYERS) {
			if(ls.getCountdown().isIdiling == false) {
				ls.getCountdown().idle();
				
			}
		}
 }

}
}