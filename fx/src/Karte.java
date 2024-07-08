import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Karte extends Application {

    private static final String IMAGE_PATH = "file:resources/images/LittleIsland.png";
    private static final double MAP_WIDTH = 800; // Desired width of the map image
    private static final double MAP_HEIGHT = 600; // Desired height of the map image
    private Image mapImage;
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

        // Load the map image and set its dimensions
        mapImage = new Image(IMAGE_PATH, MAP_WIDTH, MAP_HEIGHT, false, true);

        // Initialize terrainMap with example data (for demonstration)
        initializeTerrainMap();

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

            int gridX = (int) (mouseX / (MAP_WIDTH / 10)); // 10 is the number of columns (adjust as needed)
            int gridY = (int) (mouseY / (MAP_HEIGHT / 10)); // 10 is the number of rows (adjust as needed)

            // Display the terrain type behind the clicked grid
            displayTerrainType(gridX, gridY);
        });

        // Create a scene with the stacked layout, sized to match the map
        Scene scene = new Scene(stackPane, MAP_WIDTH, MAP_HEIGHT);

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

    // Helper method to initialize terrainMap with example data
    private void initializeTerrainMap() {
        terrainMap = new TerrainType[10][10]; // Assuming 10x10 grid (adjust as needed)
        // Example initialization; customize as needed
        for (int row = 0; row < terrainMap.length; row++) {
            for (int col = 0; col < terrainMap[row].length; col++) {
                if (row < 3 && col < 3) {
                    terrainMap[row][col] = TerrainType.WATER;
                } else if (row < 6 && col < 6) {
                    terrainMap[row][col] = TerrainType.LAND;
                } else if (row < 9 && col < 9) {
                    terrainMap[row][col] = TerrainType.ROAD;
                } else {
                    terrainMap[row][col] = TerrainType.FOREST;
                }
            }
        }
    }

    // Helper method to display terrain type behind the clicked grid
    private void displayTerrainType(int gridX, int gridY) {
        if (gridX >= 0 && gridX < terrainMap.length && gridY >= 0 && gridY < terrainMap[0].length) {
            TerrainType terrainType = terrainMap[gridX][gridY];
            System.out.println("Clicked on grid position (" + gridX + ", " + gridY + ") - Terrain: " + terrainType);
            // Show the terrain type (for demonstration, you can customize this part)
            // Text terrainLabel = new Text(terrainType.toString());
            // StackPane.setAlignment(terrainLabel, javafx.geometry.Pos.CENTER);
            // StackPane.setMargin(terrainLabel, new javafx.geometry.Insets(MAP_HEIGHT / 10 * gridY, 0, 0, MAP_WIDTH / 10 * gridX));
            // stackPane.getChildren().add(terrainLabel);
        }
    }

    // Helper method to center the stage on the screen
    private void centerStage(Stage stage, double width, double height) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double centerX = (screenBounds.getWidth() - width) / 2;
        double centerY = (screenBounds.getHeight() - height) / 2;
        stage.setX(centerX);
        stage.setY(centerY);
    }
}