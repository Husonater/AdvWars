//klasse verbindet GUI mit den Methoden von den Klassen bis jz kann ich nocht nicht sagen was alles rein kommt, z.B GUI 1 greift 2 an, dann konvertiert Gamehandler so das die 
//Methode firefight aufgerufen wurde und angewandt 
public class Gamehandler {

    int kartenwahl;

    
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

    public void main(String[] args) {
        Fighterplain soldier1 = new Fighterplain();
        System.out.println(Fight(soldier1, soldier1));
        get_Kartenwahl();
    }

    public int get_Kartenwahl(){
        return kartenwahl;
    }

}
