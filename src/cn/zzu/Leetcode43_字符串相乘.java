package cn.zzu;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/15 上午11:09
 */
public class Leetcode43_字符串相乘 {
    public String multiply(String num1, String num2) {
        if (num1==null || num2==null||num1.length() ==0 ||num2.length() ==0  )
            return "";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] res = new int[n1+n2];

        for(int i = n1-1; i >= 0; --i) {
            for(int j = n2-1; j >= 0; --j) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                // 先加低位判断是否有新的进位  判断上一次低位的乘积是否有进位  该位置总和加上进位
                mul += res[i+j+1];
                res[i+j] = res[i+j] + mul / 10;
                res[i+j+1] = mul % 10;
            }
        }
        int index = 0;
        while (index<res.length-1 && res[index]==0) {
            index++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i =index ;i<=res.length-1;i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    //大数相加
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0){
            if(i>=0)
                carry += num1.charAt(i--)-'0';
            if(j>=0)
                carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            //保存进位
            carry /= 10;
        }
        if(carry !=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
