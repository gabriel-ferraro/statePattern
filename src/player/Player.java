package player;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Classe de contexto com referencia para estados do personagem.
*/
public class Player {

	private float hp;
	private String name;
	private boolean poisoned;
	private ImageIcon appearance;
	private ICharState state;
	
	public Player() {
		this.setHp(100);
		this.setName("Doom guy");
		this.setState(new HealthyState(this));
		this.poisoned = false;
		this.setAppearance(new ImageIcon(new ImageIcon("src/images/regularDoomGuy.gif").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT)));
	}
	
	public void setState(ICharState state){
		this.state = state;
	}
	
	public String toString() {
		return (this.getName() + " is " + this.getState().toString() + "\t" + "HP: " + this.getHp() + "\tpoisoned: " + this.poisoned);
	}
	
	public void recoverHealth() {
		curePoison();
		this.setHp(this.getHp() + 50);
	}
	
	public void recieveDamage(){
		this.setHp(this.getHp() - 50);
	}
	
	public void recievePoison() {
		this.poisoned = true;
		this.setHp(this.getHp() - 10);
	}
	
	public void curePoison() {
		this.poisoned = false;
		if(this.getHp() <= 50 && this.getHp() > 0) {
			this.setState(new EndangeredState(this));
		} else if(this.getHp() > 50) {
			this.setState(new HealthyState(this));
		} else {
			this.setState(new DeadState(this));
		}
	}

	public void reviveCharacter() {
		if(this.getState() instanceof DeadState) {
			this.setHp(100);
			curePoison();
			this.setState(new HealthyState(this));
		} else {
			System.out.println(this.getName() + " is alive");
		}
	}

	public ImageIcon getAppearance() {
		return appearance;
	}

	public void setAppearance(ImageIcon appearance) {
		this.appearance = appearance;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public ICharState getState() {
		return state;
	}
}
