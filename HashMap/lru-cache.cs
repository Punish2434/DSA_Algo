| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| get(key)  | O(1)            | O(capacity)      |
| put(key)  | O(1)            | O(capacity)      |


public class LRUCache {

    private int capacity; 
    private Dictionary<int, LinkedListNode<(int key, int value)>> map; 
    private LinkedList<(int key, int value)> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new Dictionary<int, LinkedListNode<(int key, int value)>>();
        this.list = new LinkedList<(int key, int value)>();
    }
    
    public int Get(int key) {
        if(!map.ContainsKey(key))
        return -1;

        var node = map[key];
        list.Remove(node);
        list.AddFirst(node);

        return node.Value.value;
    }
    
    public void Put(int key, int value) {
        if(map.ContainsKey(key))
        {
             var node = map[key];
             list.Remove(node);
             list.AddFirst(new LinkedListNode<(int, int)>((key, value)));
             map[key] = list.First;
        }
        else
        {
            if(list.Count == capacity)
            {
                var lastNode = list.Last;
                map.Remove(lastNode.Value.key);
                list.RemoveLast();
            }

            var newNode = new LinkedListNode<(int, int)>((key, value));
            list.AddFirst(newNode);
            map[key] = newNode;
        }

    }
}
