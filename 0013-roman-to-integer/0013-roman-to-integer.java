class Solution {
    public int romanToInt(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = value(s.charAt(i));

            if (i + 1 < s.length()) {

                int next = value(s.charAt(i + 1));

                if (current < next) {
                    ans -= current;
                } else {
                    ans += current;
                }

            } else {
                ans += current;
            }
        }

        return ans;
    }

    static int value(char r) {

        if (r == 'I')
            return 1;

        if (r == 'V')
            return 5;

        if (r == 'X')
            return 10;

        if (r == 'L')
            return 50;

        if (r == 'C')
            return 100;

        if (r == 'D')
            return 500;

        if (r == 'M')
            return 1000;

        return 0;
    }
}