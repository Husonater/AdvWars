
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
                    case "forest":
                        System.out.println("Characteristic is Forest");
                        return true;
                    case "land":
                        System.out.println("Characteristic is Land");
                        return true;
                    case "road":
                        System.out.println("Characteristic is Road");
                        return true;
                    default:
                        System.out.println("Unknown characteristic");
                        return false;
                }
            } else {
                System.out.println("Input does not match any characteristic");
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
