
public class MobileArtillery extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public MobileArtillery(){
        this.damage = 4; // Initialize damage to 4
        this.health = 10;
        //moverange fehlt noch
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        MobileArtillery mobileArtillery1 = new MobileArtillery();
        System.out.println("Soldier damage: " + mobileArtillery1.getDamage() + " Soldier health: " +mobileArtillery1.getHealth()); // Output: Soldier damage: 4


}
}