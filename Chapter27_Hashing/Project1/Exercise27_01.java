/*
(Implement MyMap using open addressing with linear probing)
Use the template at https://liveexample.pearsoncmg.com/test/Exercise27_01_13e.txt to rewrite a new concrete class MyHashMap that implements MyMap using open addressing with linear probing. For simplicity, use f(key) = key % size as the hash function, where size is the hash-table size. Initially, the hash-table size is 4. The table size is doubled whenever the load factor exceeds the threshold (0.5).
*/

import java.util.*;

public class Exercise27_01 {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer keys, input ends with a negative value: ");
        int key = input.nextInt();
        while (key >= 0) {
            map.put(key, key);
            key = input.nextInt();
        }

        System.out.print("Enter key1: ");
        int key1 = input.nextInt();
        System.out.println("Is " + key1 + " in the map? " + map.containsKey(key1));

        System.out.print("Enter key2: ");
        int key2 = input.nextInt();
        System.out.println("Is " + key2 + " in the map? " + map.containsKey(key2));

        System.out.println("The map size is " + map.size());

        map.remove(2);
        System.out.println("After removing key 2 from the map, is key 2 in the map? " + map.containsKey(2));
        System.out.println("The map size is " + map.size());
    }
}

interface MyMap<K, V> {
    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    Set<Entry<K, V>> entrySet();

    V get(K key);

    boolean isEmpty();

    Set<K> keySet();

    V put(K key, V value);

    void remove(K key);

    int size();

    Set<V> values();

    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
}

class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.5f;

    private int capacity;
    private float loadFactorThreshold;
    private int size = 0;
    private Entry<K, V>[] table;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY) {
            this.capacity = MAXIMUM_CAPACITY;
        } else {
            this.capacity = trimToPowerOf2(initialCapacity);
        }
        this.loadFactorThreshold = loadFactorThreshold;
        table = new Entry[capacity];
    }

    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        return capacity;
    }

    public void clear() {
        size = 0;
        removeEntries();
    }

    public boolean containsKey(K key) {
        if (get(key) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                set.add(table[i]);
            }
        }
        return set;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                set.add(table[i].key);
            }
        }
        return set;
    }

    public void remove(K key) {
        int index = hash(key.hashCode());
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index] = null;
                size--;
                break;
            }
            index = (index + 1) % capacity;
        }
    }

    public int size() {
        return size;
    }

    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                set.add(table[i].value);
            }
        }
        return set;
    }

    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private void removeEntries() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    private void rehash() {
        Set<Entry<K, V>> set = entrySet();
        capacity <<= 1;
        table = new Entry[capacity];
        size = 0;

        for (Entry<K, V> entry : set) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].key != null) {
                builder.append(table[i].toString());
            }
        }
        return builder.append("]").toString();
    }

    public V get(K key) {
        int index = hash(key.hashCode());

        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public V put(K key, V value) {
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }
            rehash();
        }

        int index = findEmptyIndex(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
            return value;
        } else {
            V oldValue = table[index].value;
            table[index].value = value;
            return oldValue;
        }
    }

    private int findEmptyIndex(K key) {
        int index = hash(key.hashCode());
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return index;
            }
            index = (index + 1) % capacity;
        }
        return index;
    }
}
