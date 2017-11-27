
 package shiyan1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import shiyan1.test.bridge;
import shiyan1.test.createGraph;

public class testTest {

	@Before
	public void setUp() throws Exception {
		createGraph cg=new createGraph();
		cg.inout();
	}

	@Test
	public void test() {
		bridge b = new bridge();
		assertEquals(b.main("on", "tonight")," ");
		assertEquals(b.main("the", "my"),"on ");
		assertEquals(b.main("and", "cold")," ");
		assertEquals(b.main("on", "snow"),"the my ");
		assertEquals(b.main("a", "and"),null);
		assertEquals(b.main("the", "c"),null);
	}

}
 /*
package shiyan1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import shiyan1.test7.createGraph;
import shiyan1.test7.shortestPath;

public class test7Test2 {

	@Before
	public void setUp() throws Exception {
		createGraph cg=new createGraph();
		cg.inout();
	}

	@Test
	public void test() {
		shortestPath sp = new shortestPath();
		  assertEquals(sp.main("the", "one"),"thebigdatatimeservitizationbecomesone");//�����·����
	       
	       // assertEquals(sp.main("word", ""),null);//ֻ����һ�����ʵ�
	       // assertEquals(sp.main("word", "in"),"");//û��·����
	       // assertEquals(sp.main("��", "��"),null);//�Ƿ��ַ�
	      //  assertEquals(sp.main("", ""),null);//����0������
	}

}*/
