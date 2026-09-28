import uk.ac.leedsbeckett.oop.*;

public class NewLoco extends Locomotive {

    private int locoId;

    public NewLoco(GameWorld gameWorld, int startX, int startY) throws LayoutException {
        super(gameWorld, startX, startY);
        setAnimationStepPixels(2);
    }

    public void setLocoId(int idToStore) {
        locoId = idToStore;
    }

    public String toString() {
        int currentCellX = getCellPosition().getX();
        int currentCellY = getCellPosition().getY();
        return "NewLoco " + locoId + " at x=" + currentCellX + " y=" + currentCellY;
    }

    public void tick() {
        super.tick();
        if (isRunning()) {
            System.out.println(toString());
        }
    }
}
