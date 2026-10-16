class Solution {

    public String encode(List<String> strs) {
        StringBuilder key = new StringBuilder();
        if(strs.size() == 0) {
            return Character.toString((char)258);
        }
        for(String s : strs) {
            key.append(s.length()).append("#").append(s);
        }
        return key.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str.equals(Character.toString((char)258))) {
            return new ArrayList<>();
        }
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int start = j+1;
            int end = start + length;

            result.add(str.substring(start, end));

            i=end;
        }
        return result;
    }
}
