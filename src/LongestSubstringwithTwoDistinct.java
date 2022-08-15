public class LongestSubstringwithTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int len = 1;
        char[]ch = s.toCharArray();
        int finalterm = len;

        for(int i=1 ;i<ch.length;i++){
            if(ch[i-1]!=ch[i]){
                len++;
                finalterm = len;
                finalterm = Math.max(finalterm,len);
            }

        }
        return finalterm;
    }

    public static void main(String[] args) {

        LongestSubstringwithTwoDistinct ls = new LongestSubstringwithTwoDistinct();
        String st = "eceba";
        System.out.println(ls.lengthOfLongestSubstringTwoDistinct(st));

    }
}
