class Solution {
    public static String append(String s, int a){
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<a; i++){
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }
    public static String modify(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i<sb.length()){
            if (sb.charAt(i) == '0'){
                String str = sb.substring(1);
                sb = new StringBuilder(str);
            }else {
                break;
            }
        }
        return sb.toString().length()==0 ? "0":sb.toString();
    }
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if(len1 > len2){
            num2 = append(num2, len1-len2);
        }else{
            num1 = append(num1, len2-len1);
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for(int i=num1.length()-1; i>=0; i--){
            int a = Integer.parseInt(num1.charAt(i)+"");
            int b = Integer.parseInt(num2.charAt(i)+"");
            int sum = a+b+carry;
            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            }else {
                carry = 0;
            }
            sb.append(sum+"");
        }
        sb.append(carry+"");
        sb = sb.reverse();
        String s = modify(sb.toString());
        return s;
    }
}
