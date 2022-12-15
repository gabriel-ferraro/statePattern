package main;

import client.JFrameClient;
import player.Player;

public class Main {

	public static void main(String[] args){
		Player player = new Player();
		
		JFrameClient frame = new JFrameClient(player);
		frame.charStateWindow();
	}
}
