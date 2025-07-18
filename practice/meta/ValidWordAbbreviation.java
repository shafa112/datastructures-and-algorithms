package meta;

public class ValidWordAbbreviation {

    public static void main(String[] args) {
        String word = "a";
        String abbr = "2";
        System.out.println(validWordAbbreviation(word,abbr));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        if(word.equals(abbr)) return true;
        int i = 0;
        int j = 0;
        while( i < word.length() && j < abbr.length()) {
            if(word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
            } else {
                if(Character.isDigit(abbr.charAt(j))) {
                    //check if leading 0
                    if(abbr.charAt(j) == '0') return false;
                    else {
                        //form the number
                        int length = 0;
                        while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                            length = length*10 + (abbr.charAt(j) - '0');
                            ++j;
                        }
                        System.out.println("length is : "+length);
                        i = i + length;

                    }
                } else return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
