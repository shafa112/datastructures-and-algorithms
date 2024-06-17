package datastructure.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class PushDominos {

    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }

    public static String pushDominoes(String dominoes) {
        char[] a = dominoes.toCharArray();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'L' || a[i] == 'R') q.add(i);
        }

        while (!q.isEmpty()) {
            int currIndex = q.remove();
            if (a[currIndex] == 'L') {
                if (currIndex > 0 && a[currIndex - 1] == '.') {
                    a[currIndex - 1] = 'L';
                    q.add(currIndex - 1);
                }
            } else if (a[currIndex] == 'R') {
                if (currIndex + 1 < a.length && a[currIndex + 1] == '.') {
                    if (currIndex + 2 < a.length && (a[currIndex + 2] == 'R' || a[currIndex + 2] == '.')) {
                        a[currIndex + 1] = 'R';
                        q.add(currIndex + 1);
                    } else if(currIndex + 2 < a.length && a[currIndex + 2] == 'L') {
                        if(a[q.peek()]=='L') q.remove();
                    } else if (currIndex + 2 >= a.length) {
                        a[currIndex + 1] = 'R';
                        q.add(currIndex + 1);
                    }
                }

            }
        }

        String str = new String(a);
        return str;
    }
}
