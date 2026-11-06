class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (equals(map1, map2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char j = s2.charAt(i - s1.length());
            char c = s2.charAt(i);

            if (map2.get(j) - 1 == 0) {
                map2.remove(j);
            } else {
                map2.put(j, map2.get(j) -1);
            }
            
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if (equals(map1, map2)) {
                return true;
            }
        }

        return false;
    }

    private boolean equals(Map<Character, Integer> a, Map<Character, Integer> b) {
        if (a.keySet().size() != b.keySet().size()) {
            return false;
        }

        for (Character c : a.keySet()) {
            if (!a.get(c).equals(b.getOrDefault(c, null))) {
                return false;
            }
        }

        return true;
    }
}
