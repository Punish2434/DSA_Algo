/*         Scroll below to see JAVA code and C# also        */
/*
 
    Company Tags                : GOOGLE
    Leetcode Link               : https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
*/


/ C++ ****************************************************************************************************************/
//Using DSU
//T.C : O(m log m) - sorting edges
//      O(m * α(n)) union-find operations takes O(α(n)) time.The loop over all edges takes O(m) time, with each find and union operation inside the loop taking O(α(n)) time.
//S.C : O(n)
class DSU {
    private:
        vector<int> parent;
        vector<int> rank;
        int components;

    public : 
        
        DSU(int n) {
            parent.resize(n+1);
            rank.resize(n+1);
            components = n;
            for(int i = 1; i<=n; i++) {
                parent[i] = i;
            }
        }
    
        int find (int x) {
            if (x == parent[x]) 
                return x;

            return parent[x] = find(parent[x]);
        }

        void Union (int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) 
                return;

            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if(rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
            components--;
        }
    
        bool isSingle() {
            return components == 1;
        }
};

class Solution {
public:
    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {
        
        auto lambda = [&](vector<int>& v1, vector<int>& v2) {
            return v1[0] > v2[0];
        };
        
        sort(begin(edges), end(edges), lambda);
        DSU Alice(n);
        DSU Bob(n);
        
        int addedEdge = 0;
        
        for (auto &edge: edges) { // For each edge -
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if(type == 3) {
                bool add = false;
                
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.Union(u, v);
                    add = true;
                }
                
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.Union(u, v);
                    add = true;
                }
                
                if(add)
                    addedEdge++;
                
            } else if(type == 2) {
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.Union(u, v);
                    addedEdge++;
                }
            } else {
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.Union(u, v);
                    addedEdge++;
                }
            }
        }
        
        
        if(Alice.isSingle() && Bob.isSingle()) {
            return edges.size() - addedEdge;
        }
        
        return -1;
    }
};



/ JAVA ****************************************************************************************************************/
//Using DSU
//T.C : O(m log m) - sorting edges
//      O(m * α(n)) union-find operations takes O(α(n)) time.The loop over all edges takes O(m) time, with each find and union operation inside the loop taking O(α(n)) time.
//S.C : O(n)
class DSU {
    private int[] parent;
    private int[] rank;
    private int components;

    public DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        components = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) 
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) 
            return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        components--;
    }

    public boolean isSingle() {
        return components == 1;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);

        int addedEdge = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {
                boolean add = false;

                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    add = true;
                }

                if (Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    add = true;
                }

                if (add)
                    addedEdge++;

            } else if (type == 2) {
                if (Bob.find(u) != Bob.find(v)) {
                    Bob.union(u, v);
                    addedEdge++;
                }
            } else {
                if (Alice.find(u) != Alice.find(v)) {
                    Alice.union(u, v);
                    addedEdge++;
                }
            }
        }

        if (Alice.isSingle() && Bob.isSingle()) {
            return edges.length - addedEdge;
        }

        return -1;
    }
}
/ C# ****************************************************************************************************************/
//Using DSU
//T.C : O(m log m) - sorting edges
//      O(m * α(n)) union-find operations takes O(α(n)) time.The loop over all edges takes O(m) time, with each find and union operation inside the loop taking O(α(n)) time.
//S.C : O(n)
public class Solution {
    public int MaxNumEdgesToRemove(int n, int[][] edges) {
        // Union-Find / Disjoint Set Union data structure
        class DSU {
            private int[] parent, rank;

            public DSU(int size) {
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            public int Find(int x) {
                if (parent[x] != x) {
                    parent[x] = Find(parent[x]);
                }
                return parent[x];
            }

            public bool Union(int x, int y) {
                int rootX = Find(x);
                int rootY = Find(y);
                if (rootX != rootY) {
                    if (rank[rootX] > rank[rootY]) {
                        parent[rootY] = rootX;
                    } else if (rank[rootX] < rank[rootY]) {
                        parent[rootX] = rootY;
                    } else {
                        parent[rootY] = rootX;
                        rank[rootX]++;
                    }
                    return true;
                }
                return false;
            }
        }

        DSU dsuAlice = new DSU(n + 1);
        DSU dsuBob = new DSU(n + 1);

        int edgesUsed = 0;

        // Process type 3 edges first
        foreach (var edge in edges) {
            if (edge[0] == 3) {
                if (dsuAlice.Union(edge[1], edge[2]) | dsuBob.Union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Process type 1 edges for Alice and type 2 edges for Bob
        foreach (var edge in edges) {
            if (edge[0] == 1) {
                if (dsuAlice.Union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            } else if (edge[0] == 2) {
                if (dsuBob.Union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }

        // Check if both Alice and Bob can fully traverse the graph
        int aliceParent = dsuAlice.Find(1);
        int bobParent = dsuBob.Find(1);
        for (int i = 2; i <= n; i++) {
            if (dsuAlice.Find(i) != aliceParent || dsuBob.Find(i) != bobParent) {
                return -1;
            }
        }

        return edges.Length - edgesUsed;
    }
}
