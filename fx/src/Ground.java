
public abstract class Ground extends Troops {
    int status = 0;

    public int getStatus() {
        return status;
    }

    // Static nested class for checking characteristics
    public static class CharacteristicChecker {

        public static boolean isValidCharacteristic(String[] characteristics, String input) {
            for (String charac : characteristics) {
                if (charac.equalsIgnoreCase(input)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean checkCharacteristic(Soldier soldier, String input) {
            if (isValidCharacteristic(soldier.getCharacticis(), input)) {
                switch (input.toLowerCase()) { // Ensure the input is handled case-insensitively
                    case "WATER":
                        return true;
                    case "LAND":
                        return true;
                    case "ROAD":
                        return true;
                    case "FOREST":
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
            System.out.println(checkCharacteristic(soldier, "Forest")); // Test the method, should print true and "Characteristic is Forest"
            System.out.println(checkCharacteristic(soldier, "Sea"));    // Test with an invalid input, should print false and "Input does not match any characteristic"
        }
    }
}
