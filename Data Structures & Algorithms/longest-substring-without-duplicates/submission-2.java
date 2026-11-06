class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0; 
        int count = 0;
        int left = -1; 
        
        Map<Character, Integer> lastIndexOf = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastIndexOf.getOrDefault(c, -1) <= left) {
                // no duplicate or outside current window
                count++;
            } else {
                // duplicate in our window
                left = lastIndexOf.get(c);
                count = right - left;
            }

            lastIndexOf.put(c, right);
            max = Math.max(count, max);
        }

        return max;
    }
}
