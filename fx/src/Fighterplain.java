public class Fighterplain extends  Air{
    


    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Fighterplain(int l, int b){
        this.damage = 6; // Initialize damage to 4
        this.health = 12;
        this.moverange = 7;
        
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
    public String[] getCharacticis() {
        return characteristic;
    }

}