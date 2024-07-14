//klasse verbindet GUI mit den Methoden von den Klassen bis jz kann ich nocht nicht sagen was alles rein kommt, z.B GUI 1 greift 2 an, dann konvertiert Gamehandler so das die 
//Methode firefight aufgerufen wurde und angewandt 
public class Gamehandler {

    int kartenwahl;

    public static void main(String[] args) {
        
    }
    
    public int Fight(Troops attackingunit, Troops defenseunit){
        int newHealth = defenseunit.getHealth() - attackingunit.getUnitDamage();
        defenseunit.setHealth(newHealth);
        if (newHealth > 0){
            return newHealth;
        }else{ 
            defenseunit = null;
            return 0;
        }
    }

    public int get_Kartenwahl(){
        return kartenwahl;
    }

    
    

}
