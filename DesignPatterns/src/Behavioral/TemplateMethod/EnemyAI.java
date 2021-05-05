package Behavioral.TemplateMethod;

abstract class EnemyAI {
    public void takeTurn() {
       drinkPotions();
       speak();
       move();
       attack();
    }
    abstract void drinkPotions();
    abstract void attack();
    void move() {
        System.out.println("The monster lunges forward!");
    };
    abstract void speak();
}

class SkeletonAI extends EnemyAI {

    @Override
    void drinkPotions() {
        // skeletons do not drink potions
    }

    @Override
    void attack() {
        System.out.println("The skeleton swings his rusty cudgel");
    }

    @Override
    void speak() {
        System.out.println("The skeleton chatters his teeth menacingly");
    }
}

class Client {
    public static void main(String[] args) {
        SkeletonAI billy = new SkeletonAI();
        billy.takeTurn();
    }
}