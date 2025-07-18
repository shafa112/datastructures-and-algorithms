package meta2;

import java.util.*;

public class SimplifyPath {

    public static void main(String[] args) {
        String s = "/home/";
        System.out.println(simplifyPath(s));
    }

    public static String simplifyPath(String path) {
        String curr = "";
        int i = 0;
        Deque<String> dq = new ArrayDeque<>();
        while( i < path.length()) {
            if(path.charAt(i) == '/') {
                if(curr.equals("..")) {if(!dq.isEmpty()) dq.removeLast();}
                else if(!curr.equals("") && !curr.equals(".")) {
                    System.out.println("adding: "+curr);
                    dq.addLast(curr);
                }
                curr = "";
            } else {
                curr += path.charAt(i) + "";
            }
            ++i;
        }

        System.out.println("curr is: "+curr);
        System.out.println("dq last is: "+dq.peekLast());

        if(!curr.equals("..") && !curr.equals("") && !curr.equals(".")) dq.addLast(curr);
        if(curr.equals("..")) if(!dq.isEmpty()) dq.removeLast();


        String result = "";
        while(!dq.isEmpty()) {
            result += "/" + dq.remove();
        }

        if(result.length()==0) return "/";
        return result;
    }
}
