package meta;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        String curr = "";
        int i = 0;
        while (i < path.length()) {
            System.out.println("processing curr: "+curr);
            if (path.charAt(i) == '/') {

                if (curr.equals("..")) {
                    if (!dq.isEmpty()) dq.removeLast();
                } else if (curr != "" && !curr.equals(".")) {
                    System.out.println("adding in stack: "+curr);
                    dq.addLast(curr);
                }
                curr = "";
            } else {
                curr += path.charAt(i) + "";
            }
            ++i;
        }
        if (!curr.equals("..") && curr != "" && curr != "." && curr != "") {
            System.out.println("adding in stack: "+curr);
            dq.addLast(curr);
        }
        if(curr.equals("..") && !dq.isEmpty()) dq.removeLast();


        String result = "";
        while (!dq.isEmpty()) {
            result += "/" + dq.remove();
        }

        //System.out.println("Result is: " + result);
        if(result == "") return "/";
        return result;
    }

}
