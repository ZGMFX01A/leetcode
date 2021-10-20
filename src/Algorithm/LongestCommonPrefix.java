package Algorithm;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        String res = shortest;
        for (int i = 0; i < shortest.length(); i++) {
            for (String str : strs) {
                if (!str.startsWith(res)) {
                    res = res.substring(0, res.length() - 1);
                }
            }
        }
        return res;

    }

}
