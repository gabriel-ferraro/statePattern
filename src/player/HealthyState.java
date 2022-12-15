package player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Estado de saude normal do personagem.
*/
public class HealthyState extends ICharState {
	
	public HealthyState(Player player) {
		super(player);
		this.player.setAppearance(new ImageIcon(new ImageIcon("src/images/regularDoomGuy.gif").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
	}

	@Override
	public void heal() {
		System.out.println(this.player.getName() + " is already healthy");
	}

	@Override
	public void takeDamage() {
		this.player.recieveDamage();
		if(this.player.getHp() <= 50) {
			this.player.setState(new EndangeredState(this.player));
		}
	}

	@Override
	public void takePoison() {
		this.player.recievePoison();
		this.player.setState(new PoisonedState(this.player));
	}
	
	@Override
	public String toString() {
		return "healthy";
	}
}
