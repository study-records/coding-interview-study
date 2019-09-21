public class SOL {
    public String compress(String str) {
        String compressedStr = "";
        int count = 0;
        for ( int i = 0; i < str.length(); i++) {
            count++;

            if( i + 1 >= str.length() || str.charAt(i) != str.charAt(i +1)) {
                compressedStr += "" + str.charAt(i) + count;
                count = 0;
            }
        }
        return compressedStr.length() < str.length() ? compressedStr : str;
    }

    public static void main(String[] args) {
        system.out.println("start");
        SOL sol = new SOL();
        system.out.println(sol.compress("aaaabbcc"));
    }
}