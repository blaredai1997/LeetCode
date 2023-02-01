class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char[] keyArray = key.toCharArray();
        char counter = 'a';
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != ' ' && !map.containsKey(keyArray[i])) {
                map.put(keyArray[i], counter++);
            }
        }
        char[] msgArray = message.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < msgArray.length; i++) {
            if (msgArray[i] != ' ') {
                res.append(map.get(msgArray[i]));
            } else {
                res.append(' ');
            }
        }
        return res.toString();
    }
}