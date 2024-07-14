
public class MobileArtillery extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public MobileArtillery(int l, int b){
        this.damage = 7; // Initialize damage to 4
        this.health = 10;
        this.moverange = 5;

        //moverange fehlt noch
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }


}