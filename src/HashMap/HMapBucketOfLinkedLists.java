import java.util.Iterator;

public class HMapBucketOfLinkedLists<K, V> implements MapInterface<K, V> {
    private LinkedList<MapEntry<K, V>>[] buckets;
    private int numPairs;
    private int capacity;
    private double load;

    private final int DEFCAP = 1000; // default capacity
    private final double DEFLOAD = 0.75; // default load

    public HMapBucketOfLinkedLists() {
        this(1000, 0.75);
    }

    public HMapBucketOfLinkedLists(int initCap, double initLoad) {
        if (initCap <= 0 || initLoad <= 0)
            throw new IllegalArgumentException("Invalid capacity or load factor");

        capacity = initCap;
        load = initLoad;
        numPairs = 0;
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++)
            buckets[i] = new LinkedList<>();
    }

    public V put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        MapEntry<K, V> entry = new MapEntry<>(key, value);

        int bucketIndex = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[bucketIndex];

        for (MapEntry<K, V> mapEntry : bucket) {
            if (mapEntry.getKey().equals(key)) {
                V oldValue = mapEntry.getValue();
                mapEntry.setValue(value);
                return oldValue;
            }
        }

        bucket.addLast(entry);
        numPairs++;

        if ((double) numPairs / capacity > load)
            enlarge();

        return null;
    }

    public V get(K key) {
        if (key == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        int bucketIndex = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[bucketIndex];

        for (MapEntry<K, V> mapEntry : bucket) {
            if (mapEntry.getKey().equals(key))
                return mapEntry.getValue();
        }

        return null;
    }

    public V remove(K key) {
        throw new UnsupportedOperationException("HMapBucketOfLinkedLists does not support remove.");
    }

    public boolean contains(K key) {
        if (key == null)
            throw new IllegalArgumentException("Maps do not allow null keys.");

        int bucketIndex = getBucketIndex(key);
        LinkedList<MapEntry<K, V>> bucket = buckets[bucketIndex];

        for (MapEntry<K, V> mapEntry : bucket) {
            if (mapEntry.getKey().equals(key))
                return true;
        }

        return false;
    }

    public boolean isEmpty() {
        return numPairs == 0;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return numPairs;
    }

    public Iterator<MapEntry<K, V>> iterator() {
        return new MapIterator();
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private void enlarge() {
        capacity *= 2;

        LinkedList<MapEntry<K, V>>[] newBuckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++)
            newBuckets[i] = new LinkedList<>();

        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            for (MapEntry<K, V> mapEntry : bucket) {
                int bucketIndex = getBucketIndex(mapEntry.getKey());
                newBuckets[bucketIndex].addLast(mapEntry);
            }
        }

        buckets = newBuckets;
    }

    private class MapIterator implements Iterator<MapEntry<K, V>> {
        private int bucketIndex;
        private Iterator<MapEntry<K, V>> bucketIterator;

        public MapIterator() {
            bucketIndex = 0;
            bucketIterator = buckets[bucketIndex].iterator();
        }

        public boolean hasNext() {
            if (bucketIterator.hasNext())
                return true;

            for (int i = bucketIndex + 1; i < capacity; i++) {
                if (!buckets[i].isEmpty())
                    return true;
            }

            return false;
        }

        public MapEntry<K, V> next() {
            if (bucketIterator.hasNext())
                return bucketIterator.next();

            while (++bucketIndex < capacity) {
                if (!buckets[bucketIndex].isEmpty()) {
                    bucketIterator = buckets[bucketIndex].iterator();
                    return bucketIterator.next();
                }
            }

            throw new IndexOutOfBoundsException("No more elements in the iteration.");
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupported remove attempted on MapIterator.");
        }
    }
}
