public class Wizard extends Player{
    private int spell;
    private SpellLibrary spellLibrary;
    
    public Wizard(int health,int strength,int lives,int spell){
        super(health,strength,lives);
        this.spell=spell;
    }
    
    public Wizard(int health,int strength,int lives,int spell, SpellLibrary spellLibrary){
        super(health,strength,lives);
        this.spell=spell;
        this.spellLibrary = spellLibrary;
    }
    
    public int getSpell(){
        return spell;
    }
    
    public void setSpell(int spell){
        this.spell=spell;
    }
    
    public void setSpellLibrary(SpellLibrary spellLibrary) {
        this.spellLibrary = spellLibrary;
    }
    
    public Elf convertToElf(){
        return new Elf(getHealth(), getStrength(), getLives(), this.spell);
    }
    
    public String castRandomSpell() {
        return "Casting " + spellLibrary.getRandomSpell();
    }
}
