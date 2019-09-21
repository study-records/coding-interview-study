import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CompressStringTest {

    @org.junit.Test
    public void compressString() {
        assertThat(CompressString.compressString("aabcccccaaa"), equalTo("a2b1c5a3"));
    }
}