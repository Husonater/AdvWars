//klasse verbindet GUI mit den Methoden von den Klassen bis jz kann ich nocht nicht sagen was alles rein kommt, z.B GUI 1 greift 2 an, dann konvertiert Gamehandler so das die 
//Methode firefight aufgerufen wurde und angewandt 
public class Gamehandler {

    int kartenwahl;
    
    public static void main(String[] args) {
        
    }
    public static boolean moverangeadaption(Troops troop, int x, int y, String terrainType){
        
        
        if (Troops.CharacteristicChecker.isValidCharacteristic(troop.getCharacticis(), terrainType ) == true){
            if (moverangeCalculation(x, y, troop) == true){
                troop.setx(x);
                troop.sety(y);
                return true;
            }else{
                return false;
            }
            
    }
return true;}
    
    public static int Fight(int x, int y,Troops attackingunit, Troops defenseunit){
        if (Gamehandler.moverangeCalculation(x, y, attackingunit) == true){
        int newHealth = defenseunit.getHealth() - attackingunit.getUnitDamage();
        defenseunit.setHealth(newHealth);
        System.out.println("neue HP "+newHealth);
        if (newHealth > 0){
            return newHealth;
        }else{ 
            defenseunit = null;
            return 0;
        }}else {
            return 0;
        }
    }

    public int get_Kartenwahl(){
        return kartenwahl;
    }
    public static boolean moverangeCalculation(int x, int y, Troops troop){
        
            int minX = troop.x - troop.moverange;
            int maxX = troop.x + troop.moverange;
            int minY = troop.y - troop.moverange;
            int maxY = troop.y + troop.moverange;
            
            if (x >= minX && x <= maxX && y >= minY && y <= maxY){
                
                return true;
            }else{
                return false;
            }
    }

    
    

}
