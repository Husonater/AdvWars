public class Soldier extends  Ground{
    

    
    //Konstruktor um ein Objekt zu erzeugen, fuer dumme: das macht Soldat 1 und 2 usw.
    public Soldier(int l , int b){
        this.damage = 4; // Initialize damage to 4
        this.health = 10;
        this.moverange = 4;
        this.x =l;
        this.y =b;

        //moverange fehlt noch
    }

    public int getUnitDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }
    public int getx(){
        return x;
    }
       



}