package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotGeeksLander {

    public static int[] findBots(String a[], int n){
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;++i) {
            char[] ch = a[i].toCharArray();
            int count = getCount(ch);
            System.out.println("count::"+count);
            if(isPrime(count)) System.out.println(1);
            else System.out.println(0);
        }

        int[] ans = new int[l.size()];
        for(int i =0;i<l.size();++i){
            ans[i]=l.get(i);
        }
        return ans;
    }

    public static int getCount(char[] ch) {
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<ch.length;i=i+2) {
            m.put(ch[i],i);
        }
        return m.size();
    }

    public static boolean isPrime(int n) {
        int c=0;
        if(n==0 || n==1) return false;
        if(n==2) return true;
        for(int i =1;i<=n;++i) {
            if(n%i==0)c++;
        }
        if(c>2)return false;
        return true;
    }

    public static void main(String[] args) {
        String[] usernames = {"abcdef", "pqrs", "xyzuvabb", "aaaaaa"};
        findBots(usernames,usernames.length);
    }


}
