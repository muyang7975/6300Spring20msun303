package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is a Georgia Tech provided code example for use in assigned private GT repositories. Students and other users of this template
 * code are advised not to share it with other students or to make it available on publicly viewable websites including
 * repositories such as github and gitlab.  Such sharing may be investigated as a GT honor code violation. Created for CS6300.
 *
 * This is an test class for a simple class that represents a string, defined
 * as a sequence of characters.
 *
 * You should implement your tests in this class.  Do not change the test names.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //Test Purpose: This is the first instructor example test.
    @Test
    public void testMostCommonChar1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals('t', mycustomstring.mostCommonChar());
    }

    //Test Purpose: This test checks whether method mostCommonChar ​suitably throws a ​NullPointerException​ if the current string is null
    @Test(expected = NullPointerException.class)
    public void testMostCommonChar2() {
        mycustomstring.setString(null);
        mycustomstring.mostCommonChar();
    }

    //Test Purpose: This test checks whether methods returns the first to appear in the string If two alphabetic characters appear an equal number of times
    @Test
    public void testMostCommonChar3() {
        mycustomstring.setString("aa11bb22ccdd");
        assertEquals('a', mycustomstring.mostCommonChar());
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the string contains no alphabetic characters
    @Test (expected = NullPointerException.class)
    public void testMostCommonChar4() {
        mycustomstring.setString("1234567 $*?");
        mycustomstring.mostCommonChar();
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the string has not been set to a value
    @Test(expected = NullPointerException.class)
    public void testMostCommonChar5() {
        mycustomstring.mostCommonChar();
    }

    //Test Purpose: This test cheks whether the method could reproduce the example in the method requirement description
    @Test
    public void testMostCommonChar6() {
        mycustomstring.setString("My lucky numbers are 5, 25, and 12.");
        assertEquals('m', mycustomstring.mostCommonChar());
    }

    //Test Purpose: This is the second instructor example test.
    @Test
    public void testFilterLetters1() {
        mycustomstring.setString("1234!!! H3y, L3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("24Hy,L'pu0med6sinhisrn6", mycustomstring.filterLetters(3, false));
    }

    //Test Purpose: This the third instructor example test.
    @Test
    public void testFilterLetters2() {
        mycustomstring.setString("1234!!! H3y, L3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("1!!!  t t  11t  t t1!11!1", mycustomstring.filterLetters(3, true));
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the current string is null and more = True
    @Test(expected = NullPointerException.class)
    public void testFilterLetters3()  {
        mycustomstring.setString(null);
        mycustomstring.filterLetters(3, true);
    }

    //Test Purpose: THis test checks whether the method throws IllegalArgumentException If n is not an integer > 0 and more = True
    @Test(expected = IllegalArgumentException.class)
    public void testFilterLetters4() {
        mycustomstring.setString("aabbcc");
        mycustomstring.filterLetters(0, true);
    }

    //Test Purpose: This test cheks whether the method could reproduce the example in the method requirement description
    @Test
    public void testFilterLetters5() {
        mycustomstring.setString("HELLO 98, byebye 2");
        assertEquals("HO98,2", mycustomstring.filterLetters(2, false));
    }

    //Test Purpose: This test cheks whether the method could reproduce the example in the method requirement description
    @Test
    public void testFilterLetters6() {
        mycustomstring.setString("HELLO 98, byebye 2");
        assertEquals("E  ee ", mycustomstring.filterLetters(2, true));
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the current string has not been set and more = True
    @Test(expected = NullPointerException.class)
    public void testFilterLetters7() {
        mycustomstring.filterLetters(3, true);
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the current string has not been set and more = False
    @Test(expected = NullPointerException.class)
    public void testFilterLetters8() {
        mycustomstring.filterLetters(3, false);
    }

    //Test Purpose: This test checks whether the method throws a NullPointerException if the current string is null and more = false
    @Test(expected = NullPointerException.class)
    public void testFilterLetters9() {
        mycustomstring.setString(null);
        mycustomstring.filterLetters(3, false);
    }

    //Test Purpose: THis test checks whether the method throws IllegalArgumentException If n is not an integer > 0 and more = false
    @Test(expected = IllegalArgumentException.class)
    public void testFilterLetters10() {
        mycustomstring.setString("aabbcc");
        mycustomstring.filterLetters(0, false);
    }

    //Test Purpose: This test cheks whether the method works if the string contains only nonletters and begin with empty space
    @Test
    public void testFilterLetters11() {
        mycustomstring.setString(" 98, 2");
        assertEquals("98,2", mycustomstring.filterLetters(2, false));
    }

    //Test Purpose: This test cheks whether the method works if the string contains only nonnumbers
    @Test
    public void testFilterLetters12() {
        mycustomstring.setString("HELLO, byebye");
        assertEquals("Eee", mycustomstring.filterLetters(2, true));
    }


    //Test Purpose: This is the fourth instructor example test.
    @Test
    public void testNumberLengthsInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(17, 27);
        assertEquals("I'd b3tt3r put 51me 3 d21ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test Purpose: This is the fifth instructor example test, demonstrating a test for an exception.  Your exceptions should be tested in this format.
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testNumberLengthsInSubstring2() {
        mycustomstring.numberLengthsInSubstring(2, 10);
    }

    //Test Purpose: This test is to test whether the function works when the substrings to be replaced start with number, end with number
    @Test
    public void testNumberLengthsInSubstring3() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(6, 16);
        assertEquals("I'd b1tt1r put 10me 123 d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test Purpose: This test is to test whether the function works when the substrings to be replaced start with nonnumber, end with nonnumber
    @Test
    public void testNumberLengthsInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(2, 10);
        assertEquals("I'd b1tt1r put 50me 123 d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test Purpose: This test is to test whether the function works when the substrings to be replaced  start with nonnumber, end with number
    @Test
    public void testNumberLengthsInSubstring5() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(2, 23);
        assertEquals("I'd b1tt1r put 2me 3 d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test Purpose: This test is to test whether the function works when the substrings to be replaced  start with number, end with nonnumber
    @Test
    public void testNumberLengthsInSubstring6() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(6, 24);
        assertEquals("I'd b1tt1r put 2me 3 d161ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test Purpose: This test checks whether the method throws IllegalArgumentException if start position < 1
    @Test(expected = IllegalArgumentException.class)
    public void testNumberLengthsInSubstring7() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(0, 24);
    }

    //Test Purpose: This test checks whether the method throws IllegalArgumentException if start position > end position
    @Test(expected = IllegalArgumentException.class)
    public void testNumberLengthsInSubstring8() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(27, 24);
    }

    //Test Purpose: This test checks whether the method throws MyIndexOutOfBoundsException if end position > string length and 1 <= start <= end
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testNumberLengthsInSubstring9() {
        mycustomstring.setString("I'd b3tt3r put 50me 123 d161ts in this 5tr1n6, right?");
        mycustomstring.numberLengthsInSubstring(27, 100);
    }

    // Test Purpose: This test checks whether the method could reproduce the example in the method requirement description
    @Test
    public void testNumberLengthsInSubstring10() {
        mycustomstring.setString("326 abc 123");
        mycustomstring.numberLengthsInSubstring(1, 11);
        assertEquals("3 abc 3", mycustomstring.getString());
    }

}
