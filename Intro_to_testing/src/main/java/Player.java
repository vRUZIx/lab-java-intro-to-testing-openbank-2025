public abstract class Player {
    private int health;
    private  int strength;
    private final int defaulHealth;
    private int lives;
    public Player(int health,int strength,int lives){
        this.health=health;
        this.strength=strength;
        this.lives=lives;
        defaulHealth=health;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health) {
        this.health=health;
    }
    public int getStrength(){
        return strength;
    }
    public void setStrength(int strength){
        this.strength=strength;
    }
    public int getLives(){
        return lives;
    }
    public void setLives(int lives){
        this.lives=lives;
    }
    public void decrementLive(){
        if(lives>0){
        lives--;
        health=defaulHealth;
        }
        else {
            System.out.println("This character is dead");
        }
    }
    public void attack(Player playerToAttack){
        playerToAttack.setHealth(playerToAttack.getHealth() - this.strength);
        playerToAttack.checkHealth();
    }
    public void checkHealth(){
        if(this.health <= 0){
            decrementLive();
        }
    }
}
