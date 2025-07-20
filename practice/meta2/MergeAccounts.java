package meta2;

import java.util.*;

public class MergeAccounts {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //Build map of email and their owner and also merge the common owners using unionfind
        UnionFind uf = new UnionFind(accounts.size());
        Map<String,Integer> map = new HashMap<>();
        for(int k = 0; k < accounts.size(); ++k) {
            for(int i = 1; i < accounts.get(k).size(); ++i) {
                if(map.containsKey(accounts.get(k).get(i))) {
                    if(!uf.isConnected(map.get(accounts.get(k).get(i)),k)) {
                        uf.union(map.get(accounts.get(k).get(i)),k);
                    }
                } else {
                    map.put(accounts.get(k).get(i),k);
                }
            }
        }

        // merge step: create map of unique owners indices and their emails
        Map<Integer,List<String>> result = new HashMap<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            int value = uf.root(entry.getValue());
            if(result.containsKey(value)) {
                result.get(value).add(key);
            } else {
                List<String> l = new ArrayList<>();
                l.add(key);
                result.put(value,l);
            }
        }

        // sort the emails for each owner
        List<List<String>> output = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: result.entrySet()) {
            Collections.sort(entry.getValue());
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(entry.getKey()).get(0));
            ls.addAll(entry.getValue());
            output.add(ls);
        }
        return output;
    }

    class UnionFind {
        int[] parent;
        int[] children;

        public UnionFind(int N) {
            parent = new int[N];
            children = new int[N];
            for(int i = 0; i < N; ++i) parent[i] = i;
        }

        int root(int i) {
            while(i != parent[i]) i = parent[i];
            return i;
        }

        void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if(p == q) {
                return;
            }

            if(children[p] >= children[q]) {
                parent[q] = p;
                children[p] += children[q] + 1;
            } else {
                parent[p] = q;
                children[q] += children[p] + 1;
            }
        }

        boolean isConnected(int i, int j) {
            return root(i) == root(j);
        }
    }
}
