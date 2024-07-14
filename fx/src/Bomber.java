public class Bomber extends  Air{
    


    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Bomber(int l ,int b){
        this.damage = 8; // Initialize damage to 4
        this.health = 14;
        this.moverange =5;
        this.x =l;
        this.y =b;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

}