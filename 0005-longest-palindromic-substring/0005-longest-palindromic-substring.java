import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String checkPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                left-=1;
                right+=1;
            } else{
                break;
            }
        }
        if (left+1>right) return null;
        return s.substring(left+1,right);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String answer=s.substring(0,1);
        for(int i=0;i<len-1;i++){
            String oddCase = checkPalindrome(s,i,i);
            String evenCase = checkPalindrome(s,i,i+1);
            if(answer.length()<evenCase.length()){
                answer=evenCase;
            }
            if(oddCase!=null && answer.length()<oddCase.length() ){
                answer=oddCase;
            }
        }
        return answer;
    }
}