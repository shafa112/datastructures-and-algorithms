package meta;

import java.util.ArrayList;
import java.util.List;

public class DotProductSparseVectors {

    List<Pair> l = new ArrayList<>();

    DotProductSparseVectors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0) {
                l.add(new Pair(i,nums[i]));
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(DotProductSparseVectors vec) {
        List<Pair> l1 = this.l;
        List<Pair> l2 = vec.l;
        int dotProduct = 0;

        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {
            Pair p1 = l1.get(i);
            Pair p2 = l2.get(j);

            if (p1.index == p2.index) {
                dotProduct += (p1.value*p2.value);
            } else if (p1.index < p2.index) ++i;
            else ++j;

        }
        return dotProduct;
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index= index;
            this.value = value;
        }
    }
}
