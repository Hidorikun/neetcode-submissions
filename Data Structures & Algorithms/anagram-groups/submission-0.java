class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String s : strs) {
            String sortedWord = sorted(s);

            if (!groups.containsKey(sortedWord)) {
                groups.put(sortedWord, new ArrayList<>());
            }

            groups.get(sortedWord).add(s);
        }

        groups.values().forEach(list -> result.add(list));

        return result;
    }

    private String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
