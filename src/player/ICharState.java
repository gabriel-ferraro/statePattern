package player;

/**
 * Interface provedora dos metodos que todos estados concretos de player devem implementar.
*/
public abstract class ICharState {
	
	Player player;
	
	ICharState(Player player){
		this.player = player;
	}
	
	public abstract void heal();
	public abstract void takeDamage();
	public abstract void takePoison();
	public abstract String toString();
}
