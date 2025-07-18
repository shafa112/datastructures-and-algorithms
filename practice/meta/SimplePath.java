package meta;

import java.util.*;

public class SimplePath {

    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplePath(path));
    }

    public static String simplePath(String path) {
        ArrayDeque<String> s = new ArrayDeque<>();
        String curr = "";
        for(int i = 0; i < path.length(); ++i) {
            curr = "";
            while( i < path.length() && path.charAt(i) != '/') {
                curr += path.charAt(i);
                ++i;
            }

            if(curr.equals("..")) {
                if(!s.isEmpty()) s.removeLast();
            } else if( curr != "" && !curr.equals(".")) {
                s.addLast(curr);
            }
        }

        if(s.isEmpty()) return "/";
        String result = "";
        while(!s.isEmpty()) {
            result += "/" + s.removeFirst();
        }
        return result;
    }
}
