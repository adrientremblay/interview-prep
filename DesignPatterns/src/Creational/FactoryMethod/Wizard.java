package Creational.FactoryMethod;

interface Minion {
    public void attack();
}

abstract class Wizard {
    private String name;

    public Wizard(String name) {
        this.name = name;
    }

    public void command() {
        System.out.println("My name is " + name + "!");
        Minion minion = summonMinion();
        minion.attack();
    }

    public abstract Minion summonMinion();
}

class Zombie implements Minion {
    @Override
    public void attack() {
        System.out.println("ArgghhhHHhh!");
    }
}

class Necromancer extends Wizard {
    public Necromancer(String name) {
        super("Count " + name);
    }

    @Override
    public Minion summonMinion() {
        System.out.println("Summoning a ZOMBIE!");
        return new Zombie();
    }
}

class Client {
    public static void main(String[] args) {
        Necromancer ancano = new Necromancer("Ancano");
        ancano.command();
    }
}
