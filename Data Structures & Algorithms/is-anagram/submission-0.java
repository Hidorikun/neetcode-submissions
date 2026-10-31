class Solution {
    public boolean isAnagram(String wordA, String wordB) {
        if (wordA.length() != wordB.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (char c : wordA.toCharArray()) counts.put(c, counts.getOrDefault(c, 0) + 1);
        for (char c : wordB.toCharArray()) counts.put(c, counts.getOrDefault(c, 0) - 1);

        return counts.values()
            .stream()
            .noneMatch(c -> c != 0);
    }
}
