

class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // Find the delimiter '#'
            int j = str.indexOf('#', i);
            // Parse the length of the next string
            int length = Integer.parseInt(str.substring(i, j));
            
            // Extract the substring of size 'length' right after '#'
            String s = str.substring(j + 1, j + 1 + length);
            result.add(s);
            
            // Move pointer past the extracted string
            i = j + 1 + length;
        }
        
        return result;
    }
}