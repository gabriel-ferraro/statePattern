package player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Estado para personagem morto.
*/
public class DeadState extends ICharState {

	public DeadState(Player player) {
		super(player);
		this.player.setAppearance(new ImageIcon(new ImageIcon("src/images/deadDoomGuy.gif").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
	}

	@Override
	public void heal() {
		System.out.println("no way to heal the dead");
	}

	@Override
	public void takeDamage() {
		System.out.println("nothing left to be damaged");
	}

	@Override
	public void takePoison() {
		System.out.println("you can't poison a dead " + this.player.getName());
	}

	@Override
	public String toString() {
		return "dead";
	}
}
