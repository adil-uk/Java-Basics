import uk.ac.leedsbeckett.oop.*;

public class MyRailway extends OOPrailwaySim {

    private boolean[] derailmentWarningShown = new boolean[10];

    private int currentScore = 0;
    private int ticksSinceLastLocoSpawn = 0;
    private int numberOfLocosSpawnedSoFar = 0;
    private int ticksTheStartAreaHasBeenClear = 0;

    public MyRailway() {
        super();
        setVisible(true);
        about("\nType newgame to start!\nAdil Ali");
        try {
            int startingX = getStartPosition().getX();
            int startingY = getStartPosition().getY();
            NewLoco firstSlowLoco = new NewLoco(getWorld(), startingX, startingY);
            int firstSlowLocoId = addLocomotive(firstSlowLoco);
            firstSlowLoco.setLocoId(firstSlowLocoId);
        } catch (Exception e) {
            displayMessage("Could not add default slow loco: " + e.getMessage(), WARNING);
        }
    }

    private boolean isNotANumber(String textToCheck) {
        try {
            Integer.parseInt(textToCheck);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isStartAreaClear() {
        int startingX = getStartPosition().getX();
        int startingY = getStartPosition().getY();
        for (int locoIndex = 0; locoIndex < getLocomotives().size(); locoIndex++) {
            Position currentLocoPosition = getLocomotives().get(locoIndex).getCellPosition();
            int currentLocoCellX = currentLocoPosition.getX();
            int currentLocoCellY = currentLocoPosition.getY();
            boolean locoIsNearStartX = (currentLocoCellX == startingX || currentLocoCellX == startingX - 1 || currentLocoCellX == startingX + 1);
            boolean locoIsNearStartY = (currentLocoCellY == startingY || currentLocoCellY == startingY - 1 || currentLocoCellY == startingY + 1);
            if (locoIsNearStartX && locoIsNearStartY) {
                return false;
            }
        }
        return true;
    }

    protected void onTick() {
        super.onTick();

        if (isSimulationRunning()) {
            currentScore = currentScore + 1;
            int totalVehiclesOnTrack = getVehicles().size();
            displayOutput("Score: " + currentScore + "  |  Vehicles on track: " + totalVehiclesOnTrack);

            if (isStartAreaClear()) {
                ticksTheStartAreaHasBeenClear = ticksTheStartAreaHasBeenClear + 1;
            } else {
                ticksTheStartAreaHasBeenClear = 0;
            }
            ticksSinceLastLocoSpawn = ticksSinceLastLocoSpawn + 1;

            if (ticksSinceLastLocoSpawn >= 100 && ticksTheStartAreaHasBeenClear >= 20) {
                spawnNewLoco();
            }
        }

        for (int locoIndex = 0; locoIndex < getLocomotives().size(); locoIndex++) {
            if (isDerailed(locoIndex)) {
                if (!derailmentWarningShown[locoIndex]) {
                    stopSimulation();
                    displayMessage("Loco " + (locoIndex + 1) + " derailed! Game over! Your score was: " + currentScore, WARNING);
                    derailmentWarningShown[locoIndex] = true;
                }
            } else {
                derailmentWarningShown[locoIndex] = false;
            }
        }
    }

    private void spawnNewLoco() {
        int startingX = getStartPosition().getX();
        int startingY = getStartPosition().getY();
        try {
            NewLoco spawnedLoco = new NewLoco(getWorld(), startingX, startingY);
            int spawnedLocoId = addLocomotive(spawnedLoco);
            spawnedLoco.setLocoId(spawnedLocoId);
            startLocomotive(spawnedLocoId);

            numberOfLocosSpawnedSoFar = numberOfLocosSpawnedSoFar + 1;

            int speedForNewLoco = 3;

            int numberOfCarriagesToAttach = 2;

            try {
                setLocomotiveSpeed(spawnedLocoId, speedForNewLoco);
            } catch (Exception e) {
                displayMessage(e.getMessage(), WARNING);
            }

            for (int carriageNumber = 0; carriageNumber < numberOfCarriagesToAttach; carriageNumber++) {
                try {
                    Carriage newCarriage = new Carriage(getWorld());
                    addCarriageToLocomotive(spawnedLocoId, newCarriage);
                } catch (Exception e) {
                    displayMessage(e.getMessage(), WARNING);
                }
            }

            ticksSinceLastLocoSpawn = 0;
            ticksTheStartAreaHasBeenClear = 0;

        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    public void processCommand(String command) {
        String[] wordsInCommand = command.trim().split(" ");
        String firstWord = wordsInCommand[0].toLowerCase();

        switch (firstWord) {
            case "about":
                about();
                break;
            case "start":
                handleStart();
                break;
            case "stop":
                handleStop();
                break;
            case "addloco":
                handleAddLoco(wordsInCommand);
                break;
            case "attachcarriage":
                handleAttachCarriage(wordsInCommand);
                break;
            case "detachcarriage":
                handleDetachCarriage(wordsInCommand);
                break;
            case "speed":
                handleSpeed(wordsInCommand);
                break;
            case "crossing":
                handleCrossing(wordsInCommand);
                break;
            case "addslowloco":
                handleAddSlowLoco(wordsInCommand);
                break;
            case "reset":
                handleReset();
                break;
            case "score":
                handleScore();
                break;
            case "newgame":
                handleNewGame();
                break;
            default:
                displayMessage("Unknown command", INFO);
        }
    }

    private void handleStart() {
        startSimulation();
        displayMessage("Simulation started", INFO);
    }

    private void handleStop() {
        stopSimulation();
        displayMessage("Simulation stopped", INFO);
    }

    private void handleAddLoco(String[] wordsInCommand) {
        GameWorld gameWorld = getWorld();

        if (wordsInCommand.length == 3) {
            if (isNotANumber(wordsInCommand[1]) || isNotANumber(wordsInCommand[2])) {
                displayMessage("x and y must be numbers", WARNING);
                return;
            }
            int xPosition = Integer.parseInt(wordsInCommand[1]);
            int yPosition = Integer.parseInt(wordsInCommand[2]);
            try {
                Locomotive newLoco = new Locomotive(gameWorld, xPosition, yPosition);
                addLocomotive(newLoco);
                displayMessage("Locomotive added at " + xPosition + " " + yPosition, INFO);
            } catch (LayoutException e) {
                displayMessage("No track at that position", WARNING);
            } catch (Exception e) {
                displayMessage(e.getMessage(), WARNING);
            }
        } else {
            int defaultX = getStartPosition().getX();
            int defaultY = getStartPosition().getY();
            try {
                Locomotive newLoco = new Locomotive(gameWorld, defaultX, defaultY);
                addLocomotive(newLoco);
                displayMessage("Locomotive added at default position", INFO);
            } catch (LayoutException e) {
                displayMessage("No track at that position", WARNING);
            } catch (Exception e) {
                displayMessage(e.getMessage(), WARNING);
            }
        }
    }

    private void handleAttachCarriage(String[] wordsInCommand) {
        GameWorld gameWorld = getWorld();
        if (wordsInCommand.length < 2) {
            displayMessage("Missing loco ID", WARNING);
            return;
        }
        if (isNotANumber(wordsInCommand[1])) {
            displayMessage("Loco ID must be a number", WARNING);
            return;
        }
        int targetLocoId = Integer.parseInt(wordsInCommand[1]);
        if (targetLocoId < 1 || targetLocoId > getLocomotives().size()) {
            displayMessage("No loco found", WARNING);
            return;
        }
        try {
            Carriage newCarriage = new Carriage(gameWorld);
            addCarriageToLocomotive(targetLocoId, newCarriage);
            displayMessage("Carriage attached to loco " + targetLocoId, INFO);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleDetachCarriage(String[] wordsInCommand) {
        if (wordsInCommand.length < 2) {
            displayMessage("Missing loco ID", WARNING);
            return;
        }
        if (isNotANumber(wordsInCommand[1])) {
            displayMessage("Loco ID must be a number", WARNING);
            return;
        }
        int targetLocoId = Integer.parseInt(wordsInCommand[1]);
        if (targetLocoId < 1 || targetLocoId > getLocomotives().size()) {
            displayMessage("No loco found", WARNING);
            return;
        }
        try {
            detachCarriageFromLocomotive(targetLocoId);
            displayMessage("Carriage detached from loco " + targetLocoId, INFO);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleSpeed(String[] wordsInCommand) {
        if (wordsInCommand.length < 3) {
            displayMessage("Missing params, e.g. speed 1 3", WARNING);
            return;
        }
        if (isNotANumber(wordsInCommand[1]) || isNotANumber(wordsInCommand[2])) {
            displayMessage("Loco ID and speed must be numbers", WARNING);
            return;
        }
        int targetLocoId = Integer.parseInt(wordsInCommand[1]);
        int newSpeed = Integer.parseInt(wordsInCommand[2]);
        if (targetLocoId < 1 || targetLocoId > getLocomotives().size()) {
            displayMessage("No loco found", WARNING);
            return;
        }
        if (newSpeed < 0) {
            displayMessage("Speed can't be negative", WARNING);
            return;
        }
        try {
            setLocomotiveSpeed(targetLocoId, newSpeed);
            displayMessage("Loco " + targetLocoId + " speed is set to " + newSpeed, INFO);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleCrossing(String[] wordsInCommand) {
        GameWorld gameWorld = getWorld();
        if (wordsInCommand.length < 2) {
            displayMessage("Missing crossing ID", WARNING);
            return;
        }
        if (isNotANumber(wordsInCommand[1])) {
            displayMessage("Crossing ID must be a number", WARNING);
            return;
        }
        int targetCrossingId = Integer.parseInt(wordsInCommand[1]);
        if (targetCrossingId < 1 || targetCrossingId > gameWorld.getCrossings().size()) {
            displayMessage("No crossing with ID " + targetCrossingId, WARNING);
            return;
        }
        try {
            toggleCrossing(targetCrossingId);
            displayMessage("Crossing " + targetCrossingId + " toggled", INFO);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleAddSlowLoco(String[] wordsInCommand) {
        GameWorld gameWorld = getWorld();
        int slowLocoX;
        int slowLocoY;
        if (wordsInCommand.length == 3) {
            if (isNotANumber(wordsInCommand[1]) || isNotANumber(wordsInCommand[2])) {
                displayMessage("x and y must be numbers", WARNING);
                return;
            }
            slowLocoX = Integer.parseInt(wordsInCommand[1]);
            slowLocoY = Integer.parseInt(wordsInCommand[2]);
        } else {
            slowLocoX = getStartPosition().getX();
            slowLocoY = getStartPosition().getY();
        }
        try {
            NewLoco newSlowLoco = new NewLoco(gameWorld, slowLocoX, slowLocoY);
            int newSlowLocoId = addLocomotive(newSlowLoco);
            newSlowLoco.setLocoId(newSlowLocoId);
            displayMessage("Slow locomotive added at " + slowLocoX + " " + slowLocoY, INFO);
        } catch (LayoutException e) {
            displayMessage("No track at that position", WARNING);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleReset() {
        try {
            resetSimulation();
            displayMessage("Simulation reset", INFO);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }
    }

    private void handleScore() {
        if (isSimulationRunning()) {
            displayMessage("Current score: " + currentScore, INFO);
        } else {
            displayMessage("Game is not running", WARNING);
        }
    }

    private void handleNewGame() {
        stopSimulation();

        int totalLocosCurrently = getLocomotives().size();
        for (int locoIndex = totalLocosCurrently; locoIndex >= 2; locoIndex--) {
            try {
                deleteCompleteLoco(locoIndex);
            } catch (Exception e) {
                displayMessage(e.getMessage(), WARNING);
            }
        }

        try {
            resetSimulation();
            captureVehiclesState();
        } catch (Exception e) {
            displayMessage("Could not reset: " + e.getMessage(), WARNING);
        }

        currentScore = 0;
        ticksSinceLastLocoSpawn = 0;
        numberOfLocosSpawnedSoFar = 0;
        ticksTheStartAreaHasBeenClear = 0;

        for (int locoIndex = 0; locoIndex < derailmentWarningShown.length; locoIndex++) {
            derailmentWarningShown[locoIndex] = false;
        }

        try {
            Carriage firstCarriage = new Carriage(getWorld());
            addCarriageToLocomotive(1, firstCarriage);
            Carriage secondCarriage = new Carriage(getWorld());
            addCarriageToLocomotive(1, secondCarriage);
            Carriage thirdCarriage = new Carriage(getWorld());
            addCarriageToLocomotive(1, thirdCarriage);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }

        try {
            setLocomotiveSpeed(1, 3);
        } catch (Exception e) {
            displayMessage(e.getMessage(), WARNING);
        }

        startSimulation(100);
        startLocomotive(1);

        displayMessage("New game started!", INFO);
    }

    public static void main(String[] args) {
        new MyRailway();
    }
}
