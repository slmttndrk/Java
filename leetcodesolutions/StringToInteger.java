package leetcodesolutions;

class Solution8 {
    public int myAtoi(String s) {
        String prefix="", number="";
        Long nbr=0L;
        int i;

        for(i=0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                prefix = s.substring(0, i);
                break;
            }
            if((s.charAt(i) != ' ') && (s.charAt(i) != '-') && (s.charAt(i) != '+')){
                return 0;
            }
        }

        if(prefix.contains("-") || prefix.contains("+")){
            if(prefix.charAt(prefix.length() - 1) != '-' && prefix.charAt(prefix.length() - 1) != '+'){
                return 0;
            }
        }
        if(prefix.contains("--") || prefix.contains("++") || prefix.contains("+-") || prefix.contains("-+")){
            return 0;
        }

        for(int j=i; j < s.length(); j++){
            if(Character.isDigit(s.charAt(j))){
                number += s.charAt(j);
            } else{
                break;
            }
        }

        if(number.length() == 19 && number.charAt(number.length() - 1) > '7' && number.charAt(0) != '0'){
            return prefix.contains("-") ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(number.length() > 19 && number.charAt(0) != '0'){
            return prefix.contains("-") ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        for(int k=0; k < number.length(); k++){
            nbr = (number.charAt(k) - '0') + nbr * 10;
        }

        if(prefix.contains("-")){
            nbr = -nbr;
        }

        if(nbr > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }else if(nbr < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return nbr.intValue();
        }

    }
}

public class StringToInteger {
}
