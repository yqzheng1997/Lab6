package shiyan1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testTest {

    test t=new test();
    test.graph g=new test.graph("D:/lab1test/lab1test.txt");

    @Test
    public void testQueryBridgeWords() {
        assertEquals(g.queryBridgeWords("services", "resep")," ");
        assertEquals(g.queryBridgeWords("in", "big"),"the ");
        assertEquals(g.queryBridgeWords("more", "format")," ");
        assertEquals(g.queryBridgeWords("the", "of"),"format study meaning ");
        assertEquals(g.queryBridgeWords("a", "and"),null);
        assertEquals(g.queryBridgeWords("in", "c"),null);
    }

}
