package src.solution;

public class CompressStrings {

    public String compress(String testStr) {
        String[] strArr = testStr.split("");
        StringBuilder resultStr = new StringBuilder();

        String currentStr = "";
        String nextStr = "";

        int cnt = 0;
        int strArrSize = strArr.length;

        for (int i = 0; i < strArrSize; i++) {
            cnt++;
            nextStr = (i == strArrSize - 1) ? null : strArr[i + 1];
            currentStr = strArr[i];

            if (nextStr == null || !currentStr.equals(nextStr)) {
                resultStr.append(currentStr + Integer.toString(cnt));
                cnt = 0;
            }
        }

        // 기존 문자열보다 길 경우 기존 문자열 반환
        return resultStr.length() > testStr.length() ? testStr : resultStr.toString();
    }
}