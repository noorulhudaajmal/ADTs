public class Test {
    public static void main(String[] args) {
        HMapBucketOfLinkedLists<Integer, String> map = new HMapBucketOfLinkedLists<Integer,String>();

        // Inserting values
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");

        // Check values availability
        System.out.println(map.get(1)); // Output: One
        System.out.println(map.get(3)); // Output: Three
        System.out.println(map.get(5)); // Output: Five

        System.out.println(map.contains(2)); // Output: true
        System.out.println(map.contains(6)); // Output: false

        // size
        System.out.println(map.size()); // Output: 5

        // isEmpty check
        System.out.println(map.isEmpty()); // Output: false

        // iterator
        for (MapEntry<Integer, String> entry : map) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
