using System;
using System.Collections.Generic;

public class LRUCache
{
    private int _capacity;
    private Dictionary<int, LinkedListNode<(int key, int value)>> _cache;
    private LinkedList<(int key, int value)> _lruList;

    public LRUCache(int capacity)
    {
        _capacity = capacity;
        _cache = new Dictionary<int, LinkedListNode<(int key, int value)>>();
        _lruList = new LinkedList<(int key, int value)>();
    }

    public int Get(int key)
    {
        if (_cache.ContainsKey(key))
        {
            var node = _cache[key];
            _lruList.Remove(node);
            _lruList.AddFirst(node); // Move to front as most recently used
            return node.Value.value;
        }
        return -1; // Key not found
    }

    public void Put(int key, int value)
    {
        if (_cache.ContainsKey(key))
        {
            // Update and move to front
            var existingNode = _cache[key];
            _lruList.Remove(existingNode);
        }
        else if (_cache.Count == _capacity)
        {
            // Remove least recently used (last)
            var lru = _lruList.Last;
            _cache.Remove(lru.Value.key);
            _lruList.RemoveLast();
        }

        // Insert new node at front
        var newNode = new LinkedListNode<(int key, int value)>((key, value));
        _lruList.AddFirst(newNode);
        _cache[key] = newNode;
    }
}



public class Program
{
    public static void Main()
    {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.Put(1, 1); // cache: {1=1}
        lRUCache.Put(2, 2); // cache: {1=1, 2=2}
        Console.WriteLine(lRUCache.Get(1)); // returns 1
        lRUCache.Put(3, 3); // evicts key 2, cache: {1=1, 3=3}
        Console.WriteLine(lRUCache.Get(2)); // returns -1 (not found)
        lRUCache.Put(4, 4); // evicts key 1, cache: {4=4, 3=3}
        Console.WriteLine(lRUCache.Get(1)); // returns -1 (not found)
        Console.WriteLine(lRUCache.Get(3)); // returns 3
        Console.WriteLine(lRUCache.Get(4)); // returns 4
    }
}

