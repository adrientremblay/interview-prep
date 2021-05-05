package Structural.Decorator;

interface Component {
    public void execute();
}

/**
 * Concrete Componenet
 */
class Robot implements Component {
    @Override
    public void execute() {
        System.out.println("Beep Boop I am a robot");
    }
}

/**
 * Base Decorator
 */
abstract class RobotModule implements Component {
    private Component wrappee;

    public RobotModule(Component wrappee) {
       this.wrappee = wrappee;
    }


    @Override
    public void execute() {
        wrappee.execute();
    }
}

class GatlingGunModule extends RobotModule {
    public GatlingGunModule(Component wrappee) {
        super(wrappee);
    }

    @Override
    public void execute() {
        super.execute();
        System.out.println("Spinning up the gatling gun!");
    }
}

class JetpackModule extends RobotModule {
   public JetpackModule(Component wrappee) {
       super(wrappee);
   }

   @Override
   public void execute() {
       super.execute();
       System.out.println("Firing jetpack in 3... 2... 1...");
   }
}

class Client {
    public static void main(String args[]) {
       Component robot = new Robot();
       robot = new GatlingGunModule(robot);
       robot = new JetpackModule(robot);
       robot.execute();
    }
}
