package leetcodesolutions;

class Solution5 {
    public String longestPalindrome(String s) {

        String sub = "";
        String temp = "";

        for(int i=0; i<s.length(); i++){
            int j = s.length()-1;

            while(j>=i){
                if(s.charAt(i) == s.charAt(j)) {
                    temp = s.substring(i, j+1);
                    if(isPalindrome(temp)){
                        sub = temp.length() > sub.length() ? temp : sub;
                    }
                }
                j--;
            }
        }
        return sub;
    }

    public Boolean isPalindrome(String s) {
        int size = s.length();

        for(int i=0; i<size/2; i++){
            if(s.charAt(i) != s.charAt((size-i)-1)) return false;
        }

        return true;
    }
}

public class LongestPalindromicSubstring {

}
