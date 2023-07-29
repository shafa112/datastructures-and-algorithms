package datastructure.misc;

public class ReverseString {

    public static void main(String[] args) {

        String str = "abcd";
        System.out.println(reverse(str,str.length()-1));

    }

    public static String reverse(String str, int index) {

        if(index==0) return str.charAt(index)+"";
        return str.charAt(index) + reverse(str,index-1);

    }
}
