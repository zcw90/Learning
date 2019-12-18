package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/7/8.<br><br>
 */
public class Topic12 {

    public static void main(String[] args) {
        Topic12 instance = new Topic12();

        System.out.println("3: " + instance.intToRoman(3));
        System.out.println("4: " + instance.intToRoman(4));
        System.out.println("9: " + instance.intToRoman(9));
        System.out.println("58: " + instance.intToRoman(58));
        System.out.println("1994: " + instance.intToRoman(1994));
        System.out.println("3999: " + instance.intToRoman(3999));

        System.out.println("3: " + instance.intToRoman2(3));
        System.out.println("4: " + instance.intToRoman2(4));
        System.out.println("9: " + instance.intToRoman2(9));
        System.out.println("58: " + instance.intToRoman2(58));
        System.out.println("1994: " + instance.intToRoman2(1994));
        System.out.println("3999: " + instance.intToRoman2(3999));

        System.out.println("3: " + instance.intToRoman3(3));
        System.out.println("4: " + instance.intToRoman3(4));
        System.out.println("9: " + instance.intToRoman3(9));
        System.out.println("58: " + instance.intToRoman3(58));
        System.out.println("1994: " + instance.intToRoman3(1994));
        System.out.println("3999: " + instance.intToRoman3(3999));
    }

    public String intToRoman(int num) {
        if(num < 1 || num > 3999) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        // 计算千位
        int count = num / 1000;
        if(count != 0) {
            for(int i = 0; i < count; i++) {
                builder.append("M");
            }
        }

        // 计算百位
        count = (num % 1000) / 100;
        set(count, 'C', 'D', 'M', builder);

        // 计算十位
        count = (num % 100) / 10;
        set(count, 'X', 'L', 'C', builder);

        // 计算个位
        count = num % 10;
        set(count, 'I', 'V', 'X', builder);

        return builder.toString();
    }

    /**
     * 设置罗马数字
     * @param count
     * @param symbol1
     * @param symbol2
     * @param symbol3
     * @param builder
     */
    private void set(int count, char symbol1, char symbol2, char symbol3, StringBuilder builder) {
        if(count != 0) {
            if(count < 4) {
                for(int i = 0; i < count; i++) {
                    builder.append(symbol1);
                }
            }
            if(count == 4) {
                builder.append(symbol1);
                builder.append(symbol2);
            }
            if(count == 5) {
                builder.append(symbol2);
            }
            if(count > 5 && count < 9) {
                builder.append(symbol2);
                for(int i = 0; i < count - 5; i++) {
                    builder.append(symbol1);
                }
            }
            if(count == 9) {
                builder.append(symbol1);
                builder.append(symbol3);
            }
        }
    }

    public String intToRoman2(int num) {
        if(num < 1 || num > 3999) {
            return "";
        }

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public String intToRoman3(int num) {
        if(num < 1 || num > 3999) {
            return "";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                builder.append(numbers[i]);
            }
        }

        return builder.toString();
    }
}
