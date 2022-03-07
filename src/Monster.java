import java.util.Random;
import java.math.*;

public class Monster {

	private String name;
	private double health;
	private double strength;
	
	public Monster() {
		this.name = "";
		this.health = 0;		//default constructor
		this.strength = 0;
	}
	
	
	public Monster(String name, double health, double strength)
	{
		this.name = name;
		this.health = health;		//constructor for monster with parameters
		this.strength = strength;
	}

	public String getName() {			//getters and setters for each element
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}
	
	
	
	public void takeDamage(double damage)		// the methods used to run the battle
	{
		setHealth(getHealth()-damage);
	}
	
	public double attack() {
		/*
		Random random = new Random();
		double randomNumber = random.nextDouble(getStrength());
		return randomNumber;	*/
		double damage = Math.random() * getStrength();
		return damage;
	}
	
	public boolean isAlive()
	{
		if (getHealth() <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	
	public String toString()		// method to help print monster info
	{
		return  getName() + " (health: "+ String.format("%.2f", getHealth()) + ", strength: " + String.format("%.2f", getStrength()) + ")";
	}
	
}
