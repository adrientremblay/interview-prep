package Structural;

import java.util.ArrayList;

class TreeType {
    private String name;
    private String leafColor;
    private int averageAge;

    public TreeType(String name, String leafColor, int averageAge) {
        this.name = name;
        this.leafColor = leafColor;
        this.averageAge = averageAge;
    }

    public String getName() {
        return name;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public int getAverageAge() {
        return averageAge;
    }
}

class Tree {
    private TreeType type;
    private int x;
    private int y;

    public Tree(TreeType type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }
}

class TreeTypeFactory {
    private ArrayList<TreeType> types = new ArrayList<TreeType>();

    public TreeType getType(String name, String leafColor, int averageAge) {
        for (TreeType type : types) {
            if (type.getName().equals(name) && type.getLeafColor().equals(leafColor) && type.getAverageAge() == averageAge) {
                return type;
            }
        }

        TreeType type = new TreeType(name, leafColor, averageAge);
        types.add(type);
        return type;
    }
}

class Forest {
    private ArrayList<Tree> trees = new ArrayList<Tree>();
    private TreeTypeFactory typeFactory = new TreeTypeFactory();

    public void plantTree(int x, int y, String name, String leafColor, int averageAge) {
        trees.add(new Tree(typeFactory.getType(name, leafColor, averageAge), x, y));
    }
}

class Client {
    public static void main(String args[]) {
       Forest deepDarkWoods = new Forest();
       deepDarkWoods.plantTree(500, 250, "Haunted Oak", "brown", 279);
       deepDarkWoods.plantTree(200, 250, "Haunted Oak", "brown", 279);
       deepDarkWoods.plantTree(300, 150, "Haunted Oak", "brown", 279);
    }
}