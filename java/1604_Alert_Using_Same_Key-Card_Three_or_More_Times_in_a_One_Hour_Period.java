class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            int h = (keyTime[i].charAt(0) - '0') * 10 + (keyTime[i].charAt(1) - '0');
            int m = (keyTime[i].charAt(3) - '0') * 10 + (keyTime[i].charAt(4) - '0');
            map.get(name).add(60 * h + m);
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            ArrayList<Integer> time = map.get(key);
            Collections.sort(time);
            if (time.size() > 2) {
                if (!check(time)) {
                    res.add(key);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    public boolean check(ArrayList<Integer> time) {
        for (int i = 2; i < time.size(); i++) {
            int first = time.get(i - 2);
            int second = time.get(i);
            if (second - first <= 60) {
                return false;
            }
        }
        return true;
    }
}