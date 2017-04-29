package de.Gartenschere.sw.gamestates;

import de.Gartenschere.sw.methods.countdowns.Lobbycountdown;

public class LobbyState extends GameState {
	
	public static final int MIN_PLAYERS = 2,
                            MAX_PLAYERS = 8;	
	
	private Lobbycountdown countdown;
			                

	@Override
	public void init() {
		countdown = new Lobbycountdown();
		
	}

	@Override
	public void end() {
		
		
	}

	public Lobbycountdown getCountdown(){
		return countdown;
	}
	
}

