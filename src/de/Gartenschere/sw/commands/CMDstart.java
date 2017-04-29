package de.Gartenschere.sw.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Gartenschere.sw.gamestates.GameStateHandler;
import de.Gartenschere.sw.gamestates.LobbyState;
import de.Gartenschere.sw.methods.var;

public class CMDstart implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("start")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("game.forcestart")) {
					if(args.length == 0) {
						if(GameStateHandler.getCurrentGameState() instanceof LobbyState) {
							LobbyState ls = (LobbyState) GameStateHandler.getCurrentGameState();
							if(ls.getCountdown().getSeconds() > 10) {	
								ls.getCountdown().setSeconds(5);
								p.sendMessage(var.pr+"§cDer Spielstart wurde beschleunigt!");
							
						} else {
							p.sendMessage(var.pr+"§cDu kannst das laufende Spiel nicht starten!");
						
	
						}	} else {
								p.sendMessage(var.pr+"§cDu kannst in den letzten 5 Sekunden nicht mehr starten!");
								
								
							}
						}
					} else {
						p.sendMessage(var.pr+"§cBitte verwende /start!");
					}
					
				} else {
					Player p = (Player) sender;
					p.sendMessage(var.noperm);
				}
			}
		
	

		
		return false;
	}


}