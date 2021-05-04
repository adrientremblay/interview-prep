import java.util.Arrays;
import java.util.List;

// BNF
// <sandwich> ::= <bread> <condimentList> <ingredientList> <condimentList> <bread>
// <condimentList> ::= { <condiment> }
// <ingredientList> ::= { <ingredient> }
// <bread> ::= <whiteBread> | <wheatBread>
// <condiment> ::= <mayoCondiment> | <mustardCondiment> | <ketchupCondiment>
// <ingredient> ::= <lettuceIngredient> | <tomatoIngredient> | <chickenIngredient>

interface Expression {
    void interpret(Context context);
}

class Sandwich implements Expression {
    Bread topBread;
    CondimentList topCondiments;
    IngredientList ingredients;
    CondimentList bottomCondiments;
    Bread bottomBread;

    public Sandwich(Bread topBread, CondimentList topCondiments, IngredientList ingredients, CondimentList bottomCondiments, Bread bottomBread) {
        this.topBread = topBread;
        this.topCondiments = topCondiments;
        this.ingredients = ingredients;
        this.bottomCondiments = bottomCondiments;
        this.bottomBread = bottomBread;
    }

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "|");
        topBread.interpret(context);
        context.setOutput(context.getOutput() + "|");
        context.setOutput(context.getOutput() + "<--");
        topCondiments.interpret(context);
        context.setOutput(context.getOutput() + "-");
        ingredients.interpret(context);
        context.setOutput(context.getOutput() + "-");
        bottomCondiments.interpret(context);
        context.setOutput(context.getOutput() + "->>");
        context.setOutput(context.getOutput() + "|");
        bottomBread.interpret(context);
        context.setOutput(context.getOutput() + "|");
        System.out.println(context.getOutput());
    }

}

class IngredientList implements Expression {
    List<Ingredient> ingredients;

    public IngredientList(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void interpret(Context context) {
        for (var ingredient : ingredients) {
            ingredient.interpret(context);
        }
    }
}


interface Ingredient extends Expression {
}

class TomatoIngredient implements Ingredient {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Tomato  ");
    }
}

class LettuceIngredient implements Ingredient {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Lettuce  ");
    }
}

class ChickenIngredient implements Ingredient {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Chicken  ");
    }
}

class CondimentList implements Expression {
    List<Condiment> condiments;

    public CondimentList(List<Condiment> condiments) {
        this.condiments = condiments;
    }

    @Override
    public void interpret(Context context) {
        for (var ingredient : condiments) {
            ingredient.interpret(context);
        }
    }
}

interface Condiment extends Expression {
}

class MayoCondiment implements Condiment {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Mayo  ");
    }
}

class MustardCondiment implements Condiment {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Mustard  ");
    }
}

class KetchupCondiment implements Condiment {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Ketchup  ");
    }
}

interface Bread extends Expression {
}

class WhiteBread implements Bread {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  White-Bread  ");

    }
}

class WheatBread implements Bread {

    @Override
    public void interpret(Context context) {
        context.setOutput(context.getOutput() + "  Wheat-Bread  ");

    }
}

class Context {
    private String output = "";

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}

public class Interpreter {
    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich(
                new WheatBread(),
                new CondimentList(Arrays.asList(new Condiment[]{new MayoCondiment(), new MustardCondiment()})),
                new IngredientList(Arrays.asList(new Ingredient[]{new LettuceIngredient(), new ChickenIngredient()})),
                new CondimentList(Arrays.asList(new Condiment[]{new KetchupCondiment()})),
                new WheatBread()
        );

        sandwich.interpret(new Context());
    }
}
