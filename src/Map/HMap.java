package Map;

// Implements a map using an array-based hash table, linear probing collision
// resolution.
//
// The remove operation is not supported. Invoking it will result in the
// unchecked UnsupportedOperationException being thrown.
//
// A map provides (K = key, V = value) pairs, mapping the key onto the value.
// Keys are unique. Keys cannot be null.
//
// Methods throw IllegalArgumentException if passed a null key argument.
//
// Values can be null, so a null value returned by put or get does
// not necessarily mean that an entry did not exist.

import java.util.*;

public class HMap<K, V> implements MapInterface<K,V> {
    protected MapEntry[] map;

    protected final int DEFCAP = 1000;     // default capacity
    protected final double DEFLOAD = 0.75; // default load

    protected int origCap;  // original capacity
    protected int currCap;  // current capacity
    protected double load;

    protected int numPairs = 0;    // number of pairs in this map

    public HMap() {
        map =  new MapEntry[DEFCAP];
//          map = new HMap[DEFCAP];
        origCap = DEFCAP;
        currCap = DEFCAP;
        load = DEFLOAD;
    }

    public HMap(int initCap, double initLoad) {
//          map = new HMap[initCap];
        map = new MapEntry[initCap];
        origCap = initCap;
        currCap = initCap;
        load = initLoad;
    }


    private void enlarge(){
        // Increments the capacity of the map by an amount
        // equal to the original capacity.
        // create a snapshot iterator of the map and save current size
        Iterator<MapEntry<K,V>> i = iterator();
        int count = numPairs;

        // create the larger array and reset variables
        map = new MapEntry[currCap + origCap];
//          map = new HMap[currCap+origCap];
        currCap = currCap + origCap;
        numPairs = 0;

        // put the contents of the current map into the larger array
        MapEntry entry;
//        for (int n = 1; n <= count; n++) {
        while (i.hasNext()){
            entry = i.next();
            this.put((K)entry.getKey(), (V)entry.getValue());
        }
    }


    public V get(K k){
        // If an entry in this map with a key k exists then the value associated
        // with that entry is returned; otherwise null is returned.
        if (k == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        V temp = null;

        int location = Math.abs(k.hashCode()) % mapCapacity();

        for(int j=0;j<mapCapacity();j++){
            int nextLocation = (location + j * j) % mapCapacity();
            if(map[nextLocation] == null){
                break;
            }else if (map[nextLocation].getKey().equals(k)){
                temp = (V)map[nextLocation].getValue();
                break;
            }
        }
        return temp;
    }

    public V remove(K k){
        V temp = null;
        if(k == null) {
            throw new IllegalArgumentException("null keys not supported.");
        }
        else if(currCap == 0){
            System.out.println("HashMap is empty.");
            return null;
        }
        else{
            int location = Math.abs(k.hashCode()) % mapCapacity();
            for(int j=0;j<mapCapacity();j++){
                int nextLocation = (location + j * j) % mapCapacity();
                if(map[nextLocation] != null && map[nextLocation].getKey().equals(k)){
                    temp = (V)map[nextLocation].getValue();
                    map[nextLocation] = null;
                    break;
                }
            }
        }
        return temp;
    }

    public boolean contains(K k)
    // Returns true if an entry in this map with key k exists;
    // Returns false otherwise.
    {
        if (k == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        int location = Math.abs(k.hashCode()) % currCap;
        while (map[location] != null)
            if (map[location].getKey().equals(k))
                return true;
            else
                location = (location + 1) % currCap;

        // if get this far then no current entry is associated with k
        return false;
    }

    public boolean isEmpty()
    // Returns true if this map is empty; otherwise, returns false.
    {
        return (numPairs == 0);
    }

    public boolean isFull()
    // Returns true if this map is full; otherwise, returns false.
    {
        return false;  // An HMap is never full
    }

    public int mapCapacity(){
        return map.length;
    }
    public int size()
    // Returns the number of entries in this map.
    {
        return numPairs;
    }

    private class MapIterator implements Iterator<MapEntry<K,V>>{
        // Provides a snapshot Iterator over this map.
        // Remove is not supported and throws UnsupportedOperationException.
        private ArrayList<MapEntry> list = new ArrayList<>();
        private int previousPos = -1; // previous position returned from list

        public MapIterator() {
            for(int i=0;i<map.length;i++){
                if(map[i] == null){
                    continue;
                }
                list.add(map[i]);
            }
        }

        public boolean hasNext(){
            // Returns true if the iteration has more entries; otherwise returns false.
            return (previousPos < (list.size() - 1)) ;
        }

        public MapEntry<K,V> next(){
            // Returns the next entry in the iteration.
            // Throws NoSuchElementException - if the iteration has no more entries
            if (!hasNext())
                throw new IndexOutOfBoundsException("illegal invocation of next " +
                        " in HMap iterator.\n");
            previousPos++;
            return list.get(previousPos);
        }

        public void remove(){
            // Throws UnsupportedOperationException.
            // Not supported. Removal from snapshot iteration is meaningless.
            throw new UnsupportedOperationException("Unsupported remove attempted on "
                    + "HMap iterator.\n");
        }
    }

    public Iterator<MapEntry<K,V>> iterator()
    // Returns a snapshot Iterator over this map.
    // Remove is not supported and throws UnsupportedOperationException.

    {
        return new MapIterator();
    }

    public V put(K k, V v){ //using quadratic probing.
        if (k == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
        int location = Math.abs(k.hashCode()) % mapCapacity();
        V temp = null;
        if (map[location] == null ) { // k was not in map
            insert(location, entry);
        }

        else {
            for(int j=0;j<mapCapacity();j++){
                int nextLocation = (location + j * j) % mapCapacity();
                if(map[nextLocation] == null){
                    insert(nextLocation,entry);
                    break;
                }else if (map[nextLocation].getKey().equals(k)){
                    temp = (V)map[nextLocation].getValue();
                    insert(nextLocation , entry);
                    break;
                }
            }

        }
        return temp;

    }
    public void insert(int location , MapEntry entry){
        map[location] = entry;
        numPairs++;
        if ( numPairs/currCap > load){
            enlarge();
        }
    }

    @Override
    public String toString() {
        String toReturn = "MAP\n------------------------------------\n";
        if(mapCapacity()==0){
            return "No entries found!";
        }
        for(int i=0;i<currCap;i++){
            if(map[i]==null)
                continue;
            toReturn += String.format("[%-2d] | %-8s -> | %-14s|\n",i,map[i].getKey().toString(),map[i].getValue().toString());
        }
        return toReturn+"------------------------------------";
    }

    public static void main(String[] args) {
        System.out.println("Hashmap building using quadratic probing......\n");
        testHMap();
        //700 50 85 73 101 92 76
    }

    public static void testHMap(){
        HMap map = buildHMap();
        System.out.println("------------");
        System.out.println("Displaying map :\n");
        System.out.println(map.toString());
        System.out.println("DEMO:");
        int choice = 0;
        while (!(choice == 4)){
            System.out.println("\nEnter your choice? :\n" +
                    "1. Search for entries in map\n" +
                    "2. Remove entries from map\n" +
                    "3. Display map\n" +
                    "4. Exit");
            System.out.print(">> your choice? ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice==1){
                searchEntry(map);
            }
            else if( choice == 2){
                removeEntry(map);
            }
            else if(choice == 3){
                System.out.println(map.toString());
            }
            else if(choice == 4){
                break;
            }
            else {
                System.out.println("Invalid choice....");
            }
            System.out.println();
        }
        System.out.println("Resultant map:\n");
        System.out.println(map.toString());
    }

    private static void searchEntry(HMap map) {
        System.out.print(">>Enter the key(name) : ");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        Object result = map.get(key);
        if(result != null){
            System.out.println("Search result : "+key + " -> "+result.toString());
        }else {
            System.out.println("No such keys found in hashMap.");
        }
    }

    private static void removeEntry(HMap map) {
        System.out.print(">>Enter the key(name) :");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        Object value = map.remove(key);
        if(value!=null){
            System.out.println(key+" -> "+value+ " removed!");
        }else {
            System.out.println("no such record present!\n");
        }
    }

    public static HMap buildHMap(){
        System.out.println("Creating map -> HMap(initCap=20 ,initLoad=0.8)...");
        HMap map = new HMap(20,0.8);
        System.out.println("Saturating map with following <key,value> pairs:");
        System.out.println("Inserting <Abdullah , 123>"); map.put("Abdullah" , 231567890);
        System.out.println("Inserting <Saeed , 421>");map.put("Saeed" , 421567890);
        System.out.println("Inserting <Saleem , 890>");map.put("Salem" , 490567890);
        System.out.println("Inserting <John , 876>");map.put("Mohamed" , 232567876);
        System.out.println("Inserting <Joseph , 911>");map.put("Abdel" , 235678911);
        System.out.println("Inserting <Yousef , 570>");map.put("Yousef" , 571562890);
        System.out.println("Inserting <Hamad , 120>");map.put("Hamad" , 123567890);
        return map;

    }

}

