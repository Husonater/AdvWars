public class MapObject {
    private int x;
    private int y;
    private ObjectType type;

    public MapObject(int x, int y, ObjectType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ObjectType getType() {
        return type;
    }
}

