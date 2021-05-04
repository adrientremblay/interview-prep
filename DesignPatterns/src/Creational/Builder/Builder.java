package Creational.Builder;

interface Builder {
    public void reset();
    public void buildFoundation();
    public void buildWalls();
    public void buildRoof();
    public void buildTower();
}

class Castle {
    private boolean hasFoundation;
    private boolean hasWalls;
    private boolean hasRoof;
    private boolean hasTower;

    public void setHasFoundation(boolean hasFoundation) {
        this.hasFoundation = hasFoundation;
    }

    public void setHasWalls(boolean hasWalls) {
        this.hasWalls = hasWalls;
    }

    public void setHasRoof(boolean hasRoof) {
        this.hasRoof = hasRoof;
    }

    public void setHasTower(boolean hasTower) {
        this.hasTower = hasTower;
    }
}

class CastleBuilder implements Builder {
    private Castle castle;

    public  CastleBuilder() {
        reset();
    }

    @Override
    public void reset() {
        castle = new Castle();
    }

    @Override
    public void buildFoundation() {
        castle.setHasFoundation(true);
    }

    @Override
    public void buildWalls() {
        castle.setHasWalls(true);
    }

    @Override
    public void buildRoof() {
        castle.setHasRoof(true);
    }

    @Override
    public void buildTower() {
        castle.setHasTower(true);
    }

    public Castle getCastle() {
        return castle;
    }
}

class Manor {
    private boolean hasFoundation;
    private boolean hasWalls;
    private boolean hasRoof;
    private boolean hasTower;

    public void setHasFoundation(boolean hasFoundation) {
        this.hasFoundation = hasFoundation;
    }

    public void setHasWalls(boolean hasWalls) {
        this.hasWalls = hasWalls;
    }

    public void setHasRoof(boolean hasRoof) {
        this.hasRoof = hasRoof;
    }

    public void setHasTower(boolean hasTower) {
        this.hasTower = hasTower;
    }
}


class ManorBuilder implements Builder {
    private Manor manor;

    public ManorBuilder() {
        reset();
    }

    @Override
    public void reset() {
        manor = new Manor();
    }

    @Override
    public void buildFoundation() {
        manor.setHasFoundation(true);
    }

    @Override
    public void buildWalls() {
        manor.setHasWalls(true);
    }

    @Override
    public void buildRoof() {
        manor.setHasRoof(true);
    }

    @Override
    public void buildTower() {
        manor.setHasTower(true);
    }

    public Manor getManor() {
        return manor;
    }
}

class Director {
    public void directTower(Builder builder) {
        builder.buildFoundation();
        builder.buildTower();
    }
}

class Client {
    public static void main(String args[]) {
        // building a castle directly using the Builder
        CastleBuilder jonathan = new CastleBuilder();
        jonathan.buildFoundation();
        jonathan.buildTower();
        Castle TowerCastle = jonathan.getCastle();
        jonathan.reset();

        Director jim = new Director();
        jim.directTower(jonathan);
        Castle TowerCastle2 = jonathan.getCastle();
        jonathan.reset();
    }
}
