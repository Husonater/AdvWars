
public class AntiAir extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public AntiAir(){
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
        Fighterplain soldier1 = new Fighterplain();
        System.out.println("Soldier damage: " + soldier1.getDamage() + " Soldier health: " +soldier1.getHealth()); // Output: Soldier damage: 4


}
}