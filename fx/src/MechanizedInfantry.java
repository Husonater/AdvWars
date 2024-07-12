
public class MechanizedInfantry extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public MechanizedInfantry(){
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
        MechanizedInfantry mechanizedInfantry1 = new MechanizedInfantry();
        System.out.println("Soldier damage: " + mechanizedInfantry1.getDamage() + " Soldier health: " +mechanizedInfantry1.getHealth()); // Output: Soldier damage: 4


}
}