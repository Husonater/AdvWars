public class Bomber extends  Air{
    


    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Bomber(){
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
        Bomber bomber1 = new Bomber();
        System.out.println("Soldier damage: " + bomber1.getDamage() + " Soldier health: " +bomber1.getHealth()); // Output: Soldier damage: 4


}
}