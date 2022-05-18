class TimeData {
    int timestamp;
    String value;
    public TimeData(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String, List<TimeData>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key))
            map.put(key, new ArrayList<>());
        map.get(key).add(new TimeData(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        List<TimeData> data = map.get(key);
        int l = 0, r = data.size()-1;
        while (l<r) {
            int mid = (l+r)/2;
            if (data.get(mid).timestamp==timestamp)
                return data.get(mid).value;
            else if (data.get(mid).timestamp>timestamp)
                r = mid - 1;
            else {
                if (data.get(mid+1).timestamp>timestamp)
                    return data.get(mid).value;
                l = mid + 1;
            }
        }
        // l = r
        return (data.get(l).timestamp<=timestamp ? data.get(l).value : "");
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */