package Structural.Composite;

interface Package {
   public int sum();
}

/**
 * Leaf
 */
class Item implements Package {
   private int price;

   public Item(int price) {
      this.price = price;
   }

   @Override
   public int sum() {
      return price;
   }
}

/**
 * Composite
 */
class Box implements Package {
    private Package[] children;

    public Box(Package... children) {
       this.children = children;
    }

   @Override
   public int sum() {
       int sum = 0;
       for (Package child : children) {
           sum += child.sum();
       }
       return sum;
   }
}

class Client {
    public static void main(String args[]) {
        Item toyCar = new Item(5);
        Item battery = new Item(1);
        Item iPhone = new Item(500);
        Box smallBox = new Box(toyCar, battery, iPhone);
        Item keyboard = new Item(100);
        Box bigBox = new Box(smallBox, keyboard);
        System.out.println(bigBox.sum());
    }
}



