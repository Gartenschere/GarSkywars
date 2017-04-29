package de.Gartenschere.sw.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.Gartenschere.sw.gamestates.GameStateHandler;
import de.Gartenschere.sw.gamestates.LobbyState;
import de.Gartenschere.sw.methods.var;

public class EVENTquit implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		Player p = e.getPlayer();
		
		if(GameStateHandler.getCurrentGameState() instanceof LobbyState) {
			LobbyState ls = (LobbyState) GameStateHandler.getCurrentGameState();
			
			var.playing.remove(p);
			Bukkit.broadcastMessage(var.pr+ " §7Der Spieler §a" +p.getDisplayName()+" §7hat das Spiel verlassen. ["+var.playing.size()+ "/" +LobbyState.MAX_PLAYERS+"§7]");
			if (var.playing.size() < LobbyState.MIN_PLAYERS) {
				if(ls.getCountdown().isRunning == true) {
					ls.getCountdown().stopCountdown();
					ls.getCountdown().idle();

				}
			}
		
	}
}

		}