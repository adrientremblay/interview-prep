package Creational.AbstractFactory;

interface Footman {
    public void SwingWeapon();
}

interface Bowman {
    public void ShootArrow();
}

interface Horseman {
    public void Charge();
}

abstract class Barracks {
    public abstract Footman trainFootman();
    public abstract Bowman trainBowman();
    public abstract Horseman trainHorseman();
}

class ManAtArms implements Footman {
    @Override
    public void SwingWeapon() {
        System.out.println("a Man-At-Arms swings their sword");
    }
}

class LongbowMan implements Bowman {
    @Override
    public void ShootArrow() {
        System.out.println("a longbowman shoots an arrow");
    }
}

class Knight implements Horseman {
    @Override
    public void Charge() {
        System.out.println("a knight charges");
    }
}

class CastleBarracks extends Barracks {
    @Override
    public Footman trainFootman() {
        return new ManAtArms();
    }

    @Override
    public Bowman trainBowman() {
        return new LongbowMan();
    }

    @Override
    public Horseman trainHorseman() {
        return new Knight();
    }
}

class Client {
    public static void main(String args[]) {
        CastleBarracks castleBlack = new CastleBarracks();
        Footman steve = castleBlack.trainFootman();
        Bowman jeff = castleBlack.trainBowman();
        Horseman jenny = castleBlack.trainHorseman();

        steve.SwingWeapon();
        jeff.ShootArrow();
        jenny.Charge();
    }
}
