package de.Gartenschere.sw.methods.countdowns;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


import de.Gartenschere.sw.gamestates.LobbyState;
import de.Gartenschere.sw.main.Main;
import de.Gartenschere.sw.methods.var;

public class Lobbycountdown extends Countdown{
	
	private int seconds = 60;
	private int taskID, idleID;
	public boolean isIdiling = false, isRunning = false;

	@Override
	public void start() {
		isRunning = true;
          taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {

			@Override
			public void run() {
			       seconds--;
			       for(Player a : var.playing) {
			    	   a.setExp((float) seconds / 60);
			    	   a.setLevel(seconds);
			    	   }
			         switch (seconds){ 
			         case 60: case 30: case 15: case 10: case 5: case 3: case 2:
			        	 Bukkit.broadcastMessage(var.pr+ "§a Das Spiel startet in §6"+seconds+ "§a Sekunden!" );
			        	 for(Player a : var.playing)a.playSound(a.getLocation(),Sound.LAVA_POP, 1, 1);
			        	 break;
			         case 1:
			        	 Bukkit.broadcastMessage(var.pr+ "§a Das Spiel startet in §6"+seconds+ "§a Sekunde!" );
			        	 for(Player a : var.playing)a.playSound(a.getLocation(),Sound.LAVA_POP, 1, 1);
			        	 break;
			         case 0:
			        	 Bukkit.broadcastMessage(var.pr+ "§a Das Spiel startet!" );
			        	 //Spiel Startet!
			        	 break;
			        	 default:
			        		 break;
			        	 
			         }      	 
			        
			}
         
				
          }, 0, 20*1);
   
 }
	
	public void idle() {
		isIdiling = true;
		idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),new Runnable(){

			@Override
			public void run() {
			      
				int missing  = LobbyState.MIN_PLAYERS- var.playing.size();
	 
			
			if (missing == 1){
			Bukkit.broadcastMessage(var.pr+" §7 Zum Spielstart fehlt noch §c1 §7 Spieler!");
			
			} else {
				Bukkit.broadcastMessage(var.pr+" §7 Zum Spielstart fehlen noch §c" +missing+"§7 Spieler!");
			}}                                                                                                                                                                                      	
			}, 0, 20*15);

	}
	
		
		public void stopIdle(){
			if(isIdiling){
				isIdiling = false;
				Bukkit.getScheduler().cancelTask(idleID);
			}
		}
			
			public void stopCountdown() {
				if(isRunning) {
					isRunning = false;
					Bukkit.getScheduler().cancelTask(taskID);
					seconds = 60;
					 for(Player a : var.playing){a.setLevel(0);a.setExp(0);}
						
				}

	
	}
			public int getSeconds() {
				return seconds;
			}
			
		public void setSeconds(int seconds) {
				this.seconds = seconds;
			}
@Override
	public void stop() {
	isIdiling = false;
    isRunning = false;

		seconds = 60;
Bukkit.getScheduler().cancelTask(taskID);
Bukkit.getScheduler().cancelTask(idleID);
		
	}

}
