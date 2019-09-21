import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TestExmpleTest {

    @org.junit.Test
    public void compressString() {
        // 초기 셋팅
        String input01 = "aabbccccc";
        String output01 = "a2b2c5";
        String input02 = "ccaddaaaaaaa";
        String output02 = "c2a1d2a7";
        // 테스트
        assertThat(TestExmple.compressString(input02), equalTo(output02));
        assertThat(TestExmple.compressString(input01), equalTo(output01));
    }
}