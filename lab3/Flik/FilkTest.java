import static org.junit.Assert.*;

import org.junit.Test;

public class FilkTest {
    @Test
    public void TestisSameNumber(){
        for (int j = 0, i = 0; i < 500; ++i, ++j) {
            assertTrue("Oops, wrong at " + i, Flik.isSameNumber(i, j));
        }
    }
}
