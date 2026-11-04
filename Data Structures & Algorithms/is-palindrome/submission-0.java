class Solution {
    public boolean isPalindrome(String s) {
        String alphanumerical = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        for (int i = 0; i < alphanumerical.length() / 2; i++) {
            if (alphanumerical.charAt(i)
                != alphanumerical.charAt(alphanumerical.length() - i - 1)) {
                return false;
            }
        }
 
        return true;
    }
}
