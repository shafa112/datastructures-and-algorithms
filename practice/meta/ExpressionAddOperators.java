package meta;
import java.util.*;

/*
    https://leetcode.com/problems/expression-add-operators/description/
* */
public class ExpressionAddOperators {

    public static void main(String[] args) {
        String num = "00";
        int target = 0;
        System.out.println(addOperators(num,target));


    }

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num,0,"",0,0,result,target);
        return result;
    }

    private static void dfs(String num, int index, String result_so_far, long sum_so_far, long prev_num, List<String> result, int target) {

        if(index >= num.length()) {
            if(sum_so_far == target) result.add(result_so_far);
            return;
        }

        for(int i = index; i < num.length(); ++i) {
            String curr_num = num.substring(index,i+1);
            long currNum = Long.parseLong(curr_num);

            if(result_so_far.isEmpty())
                dfs(num,i+1,curr_num,currNum,currNum,result, target);
            else {
                dfs(num,i+1,result_so_far+"*"+curr_num,sum_so_far-prev_num+(currNum*prev_num),currNum*prev_num,result,target);
                dfs(num,i+1,result_so_far+"+"+curr_num,sum_so_far+currNum,currNum,result,target);
                dfs(num,i+1,result_so_far+"-"+curr_num,sum_so_far-currNum,-currNum,result,target);
            }
            if(num.charAt(index) == '0') break;
        }
    }
}