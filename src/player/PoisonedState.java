package player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Estado de saude envenenado
*/
public class PoisonedState extends ICharState {

	PoisonedState(Player player) {
		super(player);
		this.player.setAppearance(new ImageIcon(new ImageIcon("src/images/poisonedDoomGuy.gif").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
	}

	@Override
	public void heal() {
		this.player.recoverHealth();
		if(this.player.getHp() > 50) {
			this.player.setState(new HealthyState(this.player));
		}
	}

	@Override
	public void takeDamage() {
		this.player.recieveDamage();
		if(this.player.getHp() <= 50 && this.player.getHp() >= 1) {
			this.player.setState(new EndangeredState(this.player));
		} else if(this.player.getHp() <= 0) {
			this.player.setState(new DeadState(this.player));
		}
	}

	@Override
	public void takePoison() {
		System.out.println("Already poisoned!");
	}

	@Override
	public String toString() {
		return "poisoned";
	}
}
