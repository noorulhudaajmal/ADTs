package Collection.Bag;

public class Demo {
    public static void main(String[] args) {
        testBag();
    }

    private static void testBag(){
        BagInterface fruits = new BagSortedArrayCollection();
        BagInterface colors = new BagLinkedCollection();

        System.out.println("Testing BagSortedArrayCollection.java");
        // Test 1 Initial
        System.out.println("Test 1:\nExpected: null, Acutal: " + fruits.grab());

        // Test 2 Grab
        System.out.println("Test 2:");
        fruits.add("Apple");
        fruits.add("Orange");

        System.out.println("Apple added\nOrange added");
        System.out.println("fruits.grab()");
        System.out.println("1. "+fruits.grab());
        System.out.println("2. "+fruits.grab());
        System.out.println("Size = "+colors.size());


        System.out.println("Test 3:");
        // Test 3 count(target)

        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Pineapple");
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Strawberry");
        System.out.println("Apple added\nOrange added\nPineapple added\n" +
                "Orange added\nApple added\nStrawberry added");

        System.out.println("Apple count = "+fruits.count("Apple"));
        System.out.println("Size = "+fruits.size());

        System.out.println("Test 4:");
        // Test 4 removeAll(target)
        System.out.println("Removing apples....");
        fruits.removeAll("Apple");
        System.out.println("Fruits contains apples ? "+fruits.contains("Apple"));
        System.out.println("Size = "+fruits.size());


        System.out.println("Test 5:");
        // Test 5 clear()
        System.out.println("Clearing bag....");
        fruits.clear();
        System.out.println("Fruits contains Orange ? "+fruits.contains("Orange"));
        System.out.println("Size = "+fruits.size());


        System.out.println("Test 6:");
        // Test 6 toString()
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Pineapple");
        System.out.println("Apple added\nOrange added\nPineapple added");
        System.out.println("Fruits bag = \n"+fruits.toString());

        System.out.println("\nTesting BagLinkedCollection.java");
        System.out.println("Test 7:");

        // Test 7 toString()
        colors.add("Red");
        colors.add("Blue");
        colors.add("White");
        System.out.println("Red added\nBlue added\nWhite added");
        System.out.println("Colors bag = \n"+colors.toString());

        System.out.println("Test 8:");
        // Test 8 grab()
        System.out.println("colors.grab()");
        System.out.println("1. "+colors.grab());
        System.out.println("2. "+colors.grab());
        System.out.println("3. "+colors.grab());
        System.out.println("Size = "+colors.size());


        System.out.println("Test 9:");
        // Test 9 count(target)
        colors.add("White");
        colors.add("Green");
        System.out.println("White added\nGreen added");
        System.out.println("White count = "+colors.count("White"));
        System.out.println("Blue count = "+colors.count("Blue"));

        System.out.println("Test 10:");
        // Test 10 removeAll(target)
        System.out.println("Removing all green...");
        colors.removeAll("Green");
        System.out.println("Size = "+colors.size());

        System.out.println("Test 11:");
        // Test 11 clear()
        System.out.println("clearing colors bag...");
        colors.clear();
        System.out.println("Size = "+colors.size());
    }

}
