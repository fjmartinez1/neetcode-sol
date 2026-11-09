class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();

        for (String s : strs) {
            encodedStr.append(s.length()).append("!").append(s);
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int j = 0; // this signifies where the number starts

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '!') {
                continue;
            }

            int sLength = Integer.valueOf(str.substring(j, i));
            decodedStrs.add(str.substring(i + 1, i + 1 + sLength));
            j = i + 1 + sLength; // signifies where new number starts
            i += sLength;
        }

        return decodedStrs;
    }
}
