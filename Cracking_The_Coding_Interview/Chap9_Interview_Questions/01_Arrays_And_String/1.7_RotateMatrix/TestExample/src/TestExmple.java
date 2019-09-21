public class TestExmple {
    static String compressString(String string) {
        StringBuilder output = new StringBuilder();
        char[] chars = string.toCharArray();

        int count = 0;
        for (int i=0;i<chars.length;i++) {
            count++;
            if(i>=chars.length -1 || chars[i] != chars[i+1]) {
                output.append(chars[i]);
                output.append(count);
                count = 0;
            }
        }
        return output.length() > chars.length ? string : output.toString();
    }
}
