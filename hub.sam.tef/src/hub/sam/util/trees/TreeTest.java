package hub.sam.util.trees;

import junit.framework.TestCase;

public class TreeTest extends TestCase {

	class MyTree extends AbstractChildTree<MyTree, String> {
		public MyTree(String element) {
			super(element);
		}

		@Override
		public String toString() {		
			return getElement();
		}				
	}
	
	private MyTree testTree = null;

	@Override
	protected void setUp() throws Exception {
		testTree = new MyTree("ROOT");
		MyTree alphChild = new MyTree("A");
		MyTree numChild = new MyTree("I");
		alphChild.addChild(new MyTree("a"));
		alphChild.addChild(new MyTree("b"));
		alphChild.addChild(new MyTree("c"));
		numChild.addChild(new MyTree("1"));
		numChild.addChild(new MyTree("2"));
		testTree.addChild(alphChild);
		testTree.addChild(numChild);
	}
	
	public void testDump() throws Exception {
		assertEquals(AbstractTree.dumpTree(testTree).trim(), "a b c A 1 2 I ROOT");		
	}
	
}
