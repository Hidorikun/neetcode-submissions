class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0; 
        int max = 0; 

        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            int maxFreq = getMaxFreq(map);

            while (r - l + 1 - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    private int getMaxFreq(Map<Character, Integer> map) {
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            max = Math.max(max, map.getOrDefault(c, 0));
        }

        return max;
    }
}
