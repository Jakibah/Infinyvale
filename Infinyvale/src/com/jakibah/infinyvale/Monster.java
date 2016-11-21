package com.jakibah.infinyvale;

public abstract class Monster {

	protected int x, y, texturefactor, basedamage, health;
	protected Item drop;

	public Monster(int x, int y, int texturefactor, int basedamage, int health, Item drop) {
		this.x = x;
		this.y = y;
		this.texturefactor = texturefactor;
		this.basedamage = basedamage;
		this.health = health;
		this.drop = drop;
	}

	public void Update() {
		AI();
		if (health <= 0) {
			Die();
		}

	}
   
	public void Die() {
		// Override me
	}

	public void AI() {
        // Override me
	}
	
	public void Damage(int damage){
		this.health = this.health - 1;
	}
	public void Heal(int toheal){
		this.health = this.health + toheal;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTexturefactor() {
		return texturefactor;
	}

	public void setTexturefactor(int texturefactor) {
		this.texturefactor = texturefactor;
	}

	public int getBasedamage() {
		return basedamage;
	}

	public void setBasedamage(int basedamage) {
		this.basedamage = basedamage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Item getDrop() {
		return drop;
	}

	public void setDrop(Item drop) {
		this.drop = drop;
	}

	

}
