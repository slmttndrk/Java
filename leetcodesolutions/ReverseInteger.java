package leetcodesolutions;

class Solution7 {
    public int reverse(int x) {
        Long xLong = (long) x;
        String res = "";
        boolean isNeg = (x<0) ? true : false;

        if(xLong == 0)
            return 0;

        if(isNeg)
            xLong *= -1;

        while(xLong != 0){
            res += Long.toString(xLong % 10);
            xLong = xLong / 10;
        }

        long reversed = (isNeg) ?  -(Long.parseLong(res)) : Long.parseLong(res);

        return (reversed < Math.pow(-2,31) || reversed > (Math.pow(2,31))-1 ) ?  0 : (int) reversed;
    }
}

public class ReverseInteger {
}
