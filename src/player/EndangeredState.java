package player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Estado de saude "ferido".
*/
public class EndangeredState extends ICharState {

	public EndangeredState(Player player) {
		super(player);
		this.player.setAppearance(new ImageIcon(new ImageIcon("src/images/hurtDoomGuy.jpg").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
	}

	@Override
	public void heal() {
		this.player.recoverHealth();
		this.player.curePoison();
		if(this.player.getHp() > 50) {
			this.player.setState(new HealthyState(this.player));
		}
	}

	@Override
	public void takeDamage() {
		this.player.recieveDamage();
		if(this.player.getHp() <= 0) {
			this.player.setState(new DeadState(this.player));
		}
	}

	@Override
	public void takePoison() {
		this.player.recievePoison();
		if(this.player.getHp() <= 0) {
			this.player.setState(new DeadState(this.player));
		} 
		this.player.setState(new PoisonedState(this.player));
	}

	@Override
	public String toString() {
		return "endangered";
	}
}
