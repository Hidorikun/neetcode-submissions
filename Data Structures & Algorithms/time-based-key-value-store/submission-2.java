class TimeMap {
    private HashMap<String, List<Pair<Integer, String>>> map; 

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        return binarySearch(map.get(key), timestamp);
    }


    private String binarySearch(List<Pair<Integer, String>> list, int target) {
        int l = -1; 
        int r = list.size();

        while (r - l > 1) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).getKey() <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l > -1 ? list.get(l).getValue() : "";
    }
}
