
public abstract class Troops {

    // Anfang Attribute
    int moverange;
    int damage;
    int health;
    String[] characteristic; // welche Felder von welcher Truppe betreten werden darf (eigenschaften)

    

    public static class CharacteristicChecker {

        public static boolean isValidCharacteristic(String[] characteristics, String input) {
            for (String charac : characteristics) {
                if (charac.equalsIgnoreCase(input)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean checkCharacteristic(Troops troop, String input) {
            if (isValidCharacteristic(troop.getCharacticis(), input)) {
                switch (input.toLowerCase()) { // Ensure the input is handled case-insensitively
                    case "water":
                        return true;
                    case "land":
                        return true;
                    case "road":
                        return true;
                    case "forest":
                        return true;
                    default:
                        return false;
                }
            } else {
                return false;
            }
        }
        public static void main(String[] args) {
            Soldier soldier = new Soldier();
            System.out.println(checkCharacteristic(soldier, "foest")); // Test the method, should print true and "Characteristic is Forest"
            System.out.println(checkCharacteristic(soldier, "road"));    // Test with an invalid input, should print false and "Input does not match any characteristic"
            System.out.println(isValidCharacteristic(soldier.getCharacticis(), "frest"));
        }
    }


    // Ende Attribute

    public static void main(String[] args) {
        firefight();

    }
    // Anfang Methoden 


    //Methode fuer den Kampf zwischen Units
    public static void firefight(){


    }
    // hier sollten die stats von den truppen abgerufen werden und an den Gamehandler weitergeben werden (current hp, dmg, remaing move range)
    public void getStats(){

    }
    public String[] getCharacticis() {
        return characteristic;
    }

    


    // Ende Methoden
} // end of Troops