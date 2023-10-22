package com.alamin;
import java.util.LinkedList;

public class CustomHashMap<K, V> {
        private static final int DEFAULT_CAPACITY = 16; 
        private static final double LOAD_FACTOR = 0.75;
        private LinkedList<Pair<K, V>>[] table;
        private int size;

         public CustomHashMap() {
            this.table = new LinkedList[DEFAULT_CAPACITY];
            for (int i = 0; i < DEFAULT_CAPACITY; i++) {
                this.table[i] = new LinkedList<>();
            }
         }


        public CustomHashMap(int capacity) {
            table = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int getBucketIndex(K key) {
            int hashCode = key.hashCode();
            return hashCode % table.length;
        }

        public void put(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Pair<K, V>> bucket = table[bucketIndex];

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    return;
                }
            }

            bucket.add(new Pair<>(key, value));
            size++;

            if ((double) size / table.length > LOAD_FACTOR) {
                resize();
            }
        }

        public V get(K key) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Pair<K, V>> bucket = table[bucketIndex];

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }

            return null;
        }

        public void remove(K key) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Pair<K, V>> bucket = table[bucketIndex];

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    bucket.remove(pair);
                    size--;
                    return;
                }
            }
        }

        public int size() {
            return size;
        }

        private void resize() {
            int newCapacity = table.length * 2;
            LinkedList<Pair<K, V>>[] newTable = new LinkedList[newCapacity];

            for (int i = 0; i < newCapacity; i++) {
                newTable[i] = new LinkedList<>();
            }

            for (LinkedList<Pair<K, V>> bucket : table) {
                for (Pair<K, V> pair : bucket) {
                    int newBucketIndex = pair.key.hashCode() % newCapacity;
                    newTable[newBucketIndex].add(pair);
                }
            }

            table = newTable;
        }

    }
