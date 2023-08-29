package leetcodesolutions;

class Solution6 {
    public String convert(String s, int numRows) {
        int[] index = new int[s.length()];
        String res ="";

        int i = 0, r = 0;
        boolean isAscending = true;

        if(numRows < 2) return s;
        else{
            while(i<s.length())
            {
                index[i] = r;

                if(isAscending){
                    r++;
                }
                else{
                    r--;
                }

                if(r % numRows == 0 && isAscending == true){
                    isAscending = false;
                    r -= 2;

                }

                if(r % numRows == 0 && isAscending == false){
                    isAscending = true;
                }

                i++;
            }

            r = 0;

            while(r<numRows){
                for(int in=0; in<s.length();in++){
                    if(index[in] == r){
                        res += s.charAt(in);
                    }
                }
                r++;
            }

            return res;
        }
    }
}

public class ZigzagConversion {
}
