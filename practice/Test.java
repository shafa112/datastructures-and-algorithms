public class Test {

    public static void main(String[] args) {
        int a = 123;
        String numberString = String.valueOf(a);
        System.out.println(numberString);
        char[] ch = numberString.toCharArray();
        System.out.println(ch[2]-'0');
        //System.out.println(1<<2);
    }
}
