class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        if (n == 1) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            int min = Math.min(w1.length(), w2.length());
            boolean isSorted = false;
            for (int j = 0; j < min; j++) {
                if (order.indexOf(w1.charAt(j)) < order.indexOf(w2.charAt(j))) {
                    isSorted = true;
                    break;
                } else if (order.indexOf(w1.charAt(j)) > order.indexOf(w2.charAt(j))) {
                    return false;
                }
            }
            if (!isSorted && w1.length() > w2.length()) {
                return false;
            }
        }
        return true;
    }
}