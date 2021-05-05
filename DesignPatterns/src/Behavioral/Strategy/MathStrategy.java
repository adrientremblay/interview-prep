package Behavioral.Strategy;

interface MathStrategy {
    int execute(int a, int b);
}

class AddStrategy implements MathStrategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}

class SubtractStrategy implements MathStrategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}

class Context {
    private MathStrategy strategy;

    public void setStrategy(MathStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int a, int b) {
       return strategy.execute(a, b);
    }
}

class Client {
    public static void main(String args[]) {
        Context context = new Context();

        context.setStrategy(new AddStrategy());
        System.out.println(context.executeStrategy(10, 5));

        context.setStrategy(new SubtractStrategy());
        System.out.println(context.executeStrategy(10, 5));
    }
}