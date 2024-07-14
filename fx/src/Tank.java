
public class Tank extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Tank(int l, int b){
        this.damage = 6; // Initialize damage to 4
        this.health = 15;
        this.moverange = 3;
        this.x =l;
        this.y =b;
        //moverange fehlt noch
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
    
}