public class Soldier extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Soldier(){
        this.damage = 4; // Initialize damage to 4
        this.health = 10;
        this.characteristic = new String[]{"Forest","Land","Road"};

        //moverange fehlt noch
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

    public static void main(String[] args) {
        Fighterplain soldier1 = new Fighterplain();
        System.out.println("Soldier damage: " + soldier1.getDamage() + " Soldier health: " +soldier1.getHealth()); // Output: Soldier damage: 4
        


}
}