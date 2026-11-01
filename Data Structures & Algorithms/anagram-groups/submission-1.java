class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
 
        for (String s : strs) {
            String sortedWord = sorted(s);

            groups.putIfAbsent(sortedWord, new ArrayList<>());
            groups.get(sortedWord).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    private String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
