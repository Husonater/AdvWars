//javac --module-path C:\javaprj\javafx-sdk-23\lib --add-modules javafx.controls,javafx.fxml -d bin C:\javaprj\AdvWar\fx\src\Karte.java  

//java --module-path C:\javaprj\javafx-sdk-23\lib --add-modules javafx.controls,javafx.fxml -cp bin  C:\javaprj\AdvWar\fx\src\Karte.java 

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Karte extends Application {

    int l;
    int b;

    private static final String LITTLE_ISLAND_IMAGE_PATH = "file:resources/images/LittleIsland.png";
    private static final String EON_SPRINGS_IMAGE_PATH = "file:resources/images/EonSprings.png";
    private static final String PISTON_DAM_IMAGE_PATH = "file:resources/images/PistonDam.png";

    private static final double MAP_WIDTH = 800; // Desired width of the map image
    private static final double MAP_HEIGHT = 600; // Desired height of the map image

    private TerrainType[][] terrainMap; // Terrain information for each cell
    private ImageView mapView; // Declare mapView as a class attribute
    private StackPane stackPane; // Declare stackPane as a class attribute

    // Enumeration for different terrain types
    public enum TerrainType {
        WATER, // Example terrain types; customize as needed
        LAND,
        ROAD,
        FOREST,
        MOUNTAIN
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Advance Wars: Little Island");
        // Create the main menu with buttons to select the maps
        Button littleIslandButton = new Button("Little Island");
        
        littleIslandButton.setOnAction(e -> showMap(primaryStage, LITTLE_ISLAND_IMAGE_PATH, () -> loadMap(Maps.LittleIsland), l=10, b=19));

        Button eonSpringsButton = new Button("Eon Springs");
        eonSpringsButton.setOnAction(e -> showMap(primaryStage, EON_SPRINGS_IMAGE_PATH, () -> loadMap(Maps.EonSprings), l=17, b=19));

        Button pistonDamButton = new Button("Piston Dam");
        pistonDamButton.setOnAction(e -> showMap(primaryStage, PISTON_DAM_IMAGE_PATH, () -> loadMap(Maps.PistonDam), l=19, b=19));

        VBox menu = new VBox(10, littleIslandButton, eonSpringsButton, pistonDamButton);
        menu.setAlignment(Pos.CENTER);

        Scene menuScene = new Scene(menu, MAP_WIDTH, MAP_HEIGHT);
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void showMap(Stage primaryStage, String imagePath, Runnable initializeTerrainMap, int l, int b) {
        // Load the map image and set its dimensions
        Image mapImage = new Image(imagePath, MAP_WIDTH, MAP_HEIGHT, false, true);

        // Initialize terrainMap with example data (for demonstration)
        initializeTerrainMap.run();

        // Create ImageView with the map image
        mapView = new ImageView(mapImage);
        mapView.setFitWidth(MAP_WIDTH); // Set the width of the ImageView to the desired width of the map
        mapView.setFitHeight(MAP_HEIGHT); // Set the height of the ImageView to the desired height of the map
        mapView.setSmooth(false); // Disable smoothing for sharper image rendering
        mapView.setPreserveRatio(false); // Don't preserve aspect ratio to avoid stretching

        // StackPane to stack the map image and terrain labels
        stackPane = new StackPane();
        stackPane.getChildren().add(mapView);

        // Handle mouse clicks on the StackPane
        stackPane.setOnMouseClicked(event -> {
            // Calculate the grid position based on click coordinates
            double mouseX = event.getX();
            double mouseY = event.getY();

            int gridX = (int) (mouseX / (MAP_WIDTH / b)); // 20 is the number of columns
            int gridY = (int) (mouseY / (MAP_HEIGHT / l)); // 20 is the number of rows

            // Display the terrain type behind the clicked grid
            displayTerrainType(gridX, gridY);
        });
        

        // Create a back button to return to the main menu
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> primaryStage.setScene(primaryStage.getScene()));

        VBox vbox = new VBox(stackPane, backButton);
        VBox.setMargin(backButton, new Insets(10));
        vbox.setAlignment(Pos.TOP_CENTER);

        // Create a scene with the stacked layout, sized to match the map
        Scene scene = new Scene(vbox, MAP_WIDTH, MAP_HEIGHT);

        // Set the scene to the stage
        primaryStage.setScene(scene);

        // Calculate desired window size including window decorations
        double windowWidth = MAP_WIDTH + 16; // 16 is the approximate width of window decorations
        double windowHeight = MAP_HEIGHT + 39; // 39 is the approximate height of window decorations

        // Set the stage size to match the map size plus window decorations
        primaryStage.setWidth(windowWidth);
        primaryStage.setHeight(windowHeight);

        // Center the stage on the screen
        centerStage(primaryStage, windowWidth, windowHeight);

        // Show the stage
        primaryStage.show();
    }

    enum Maps{
        EonSprings,
        LittleIsland,
        PistonDam
    }

    private void loadMap(Maps chosenMap) {
        try{
            String mapFile = "";

            switch (chosenMap){
                case EonSprings:
                    mapFile = "resources/files/EonSprings.csv";
                    terrainMap = new TerrainType[19][17];
                    break;
                case LittleIsland:
                    mapFile = "resources/files/LittleIsland.csv";
                    terrainMap = new TerrainType[10][19];
                    break;
                case PistonDam:
                    mapFile = "resources/files/PistonDam.csv";
                    terrainMap = new TerrainType[14][26];
                    break;
                default:
                    System.out.println("Map nicht vorhanden");
            }

            BufferedReader reader = new BufferedReader(new FileReader(mapFile));

            String line = null;

            for(int columns = 0; columns < terrainMap.length-1; columns++){
                line = reader.readLine();
                String[] rowString = line.split(",");
                for(int rows = 0; rows < terrainMap[0].length-1; rows++){
                    terrainMap[columns][rows] = TerrainType.valueOf(rowString[rows]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    // Method to center the stage on the screen
    private void centerStage(Stage stage, double windowWidth, double windowHeight) {
        // Get the screen bounds
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Calculate the centered position for the stage
        double centerX = screenBounds.getMinX() + (screenBounds.getWidth() - windowWidth) / 2;
        double centerY = screenBounds.getMinY() + (screenBounds.getHeight() - windowHeight) / 2;

        // Set the stage position
        stage.setX(centerX);
        stage.setY(centerY);
    }

    // Method to display the terrain type at the specified grid coordinates
    private void displayTerrainType(int gridX, int gridY) {
        if (terrainMap != null && gridX >= 0 && gridX < terrainMap.length && gridY >= 0 && gridY < terrainMap[0].length) {
            TerrainType terrainType = terrainMap[gridX][gridY];
            System.out.println("Terrain type at grid position (" + gridX + ", " + gridY + "): " + terrainType);
            // You can add further logic here to visually display the terrain type if needed
        } else {
            System.out.println("Invalid grid position: (" + gridX + ", " + gridY + ")");
        }
    }
}