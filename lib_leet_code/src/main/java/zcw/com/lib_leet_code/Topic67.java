package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2021/7/6.<br><br>
 *
 * 二进制求和
 */
public class Topic67 {
    public static void main(String[] args) {
        Topic67 instance = new Topic67();

        System.out.println(instance.addBinary("11", "1"));
        System.out.println(instance.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        boolean carry = false;

        StringBuilder result = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        while (indexA >= 0 && indexB >= 0) {
            char chA = a.charAt(indexA);
            char chB = b.charAt(indexB);
            if(!carry && chA == '0' && chB == '0') {
                result.insert(0, '0');
                carry = false;
            }
            else if ((!carry && chA == '0' && chB == '1') ||
                    (!carry && chA == '1' && chB == '0') ||
                    (carry && chA == '0' && chB == '0')) {
                result.insert(0, '1');
                carry = false;
            }
            else if((!carry && chA == '1' && chB == '1') ||
                    (carry && chA == '0' && chB == '1') ||
                    (carry && chA == '1' && chB == '0')) {
                result.insert(0, '0');
                carry = true;
            }
            else {
                result.insert(0, '1');
                carry = true;
            }

            indexA--;
            indexB--;
        }

        while (indexA >= 0) {
            char ch = a.charAt(indexA);
            if(carry) {
                if(ch == '1') {
                    result.insert(0, '0');
                    carry = true;
                }
                else {
                    result.insert(0, '1');
                    carry = false;
                }
            }
            else {
                result.insert(0, ch);
            }

            indexA--;
        }

        while (indexB >= 0) {
            char ch = b.charAt(indexB);
            if(carry) {
                if(ch == '1') {
                    result.insert(0, '0');
                    carry = true;
                }
                else {
                    result.insert(0, '1');
                    carry = false;
                }
            }
            else {
                result.insert(0, ch);
            }

            indexB--;
        }

        if(carry) {
            result.insert(0, "1");
        }

        return result.toString();
    }
}
