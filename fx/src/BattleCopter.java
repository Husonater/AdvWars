public class BattleCopter extends  Air{
    


    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public BattleCopter(){
        this.damage = 6; // Initialize damage to 4
        this.health = 10;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Fighterplain fighterplain1 = new Fighterplain();
        System.out.println("Soldier damage: " + fighterplain1.getDamage() + " Soldier health: " +fighterplain1.getHealth()); // Output: Soldier damage: 4


}
}