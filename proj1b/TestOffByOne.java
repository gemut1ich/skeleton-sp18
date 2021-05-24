import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static OffByOne obo = new OffByOne();
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void testEqualChars(){
        assertTrue(obo.equalChars('x', 'y'));
        assertFalse(obo.equalChars('a', 'n'));
        assertFalse(obo.equalChars('a', 'a'));
        assertFalse(obo.equalChars('(',','));
        assertTrue(obo.equalChars('(',')'));

    }
}
