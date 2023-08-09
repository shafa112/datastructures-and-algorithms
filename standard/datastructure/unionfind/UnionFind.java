package datastructure.unionfind;

/**
 *
 * https://www.coursera.org/learn/algorithms-part1/lecture/RZW72/quick-union-improvements
 *
 * Union find satisfies equivalence relationship i.e.
 * Reflexive: p is connected to p
 * Symmetric: if p is connected to q, then q is connected to p
 * Transitive: if p is connected to q, and q is connected to r, then p is connected to r
 * <p>
 * <p>
 * Side Note: An equivalence relationship is one which satisfies reflexive, symmetric and transitive properties.
 */
public class UnionFind {

    private int[] parent;
    private int[] numOfChildren;

    public UnionFind(int N) {
        parent = new int[N];
        numOfChildren = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
    }

    // logN because of the way of union is balancing
    public int root(int i) {
        while (i != parent[i]) i = parent[i];
        return i;
    }

    public int rootInPathCompression(int i){
        while(i!=parent[i]){
            parent[i]=parent[parent[i]];
            i =parent[i];
        }
        return i;
    }

    // logN because root() complexity
    public void union(int p, int q) {
        //You can alternative use rootInPathCompression to achieve better performance
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (numOfChildren[i] < numOfChildren[j]) {
            parent[i] = j;
            numOfChildren[j] = numOfChildren[j] + numOfChildren[i] + 1;
        } else {
            parent[j] = i;
            numOfChildren[i] = numOfChildren[i] + numOfChildren[j] + 1;
        }
    }

    // find if connected
    // logN
    public boolean isConnected(int p, int q) {
        //You can alternative use rootInPathCompression to achieve better performance
        return root(p) == root(q);
    }
}
