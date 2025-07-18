package meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList,0);
    }

    public int depthSum(List<NestedInteger> nestedList, int level) {
        int deptSum = 0;
        for (int i = 0; i < nestedList.size(); ++i) {
            NestedInteger nestedInteger = nestedList.get(i);
            if(nestedInteger.isInteger()) deptSum += nestedInteger.getInteger()*(level+1);
            else {
                deptSum += depthSum(nestedList,level+1);
            }
        }
        return deptSum;
    }


    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
