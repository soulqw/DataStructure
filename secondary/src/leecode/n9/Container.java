package leecode.n9;

import java.util.ArrayList;
import java.util.List;

public class Container {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int result = 0;
        while (x != 0) {
            if ((result * 10) / 10 != result) {
                return false;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return origin == result;
    }

}
