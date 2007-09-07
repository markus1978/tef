package hub.sam.tef.reconciliation.syntax;

public class BlockLayout extends AbstractLayoutManager {

	public static final int EMPTY = 1;
	public static final int SPACE = 2;
	public static final int BEGIN_BLOCK = 3;
	public static final int INDENT = 4;
	public static final int END_BLOCK = 5;
	public static final int STATEMENT = 6;
	
	private int indent = 0;
		
	@Override
	public void setup() {
		indent = 0;
	}

	@Override
	public String getSpace(int role) {
		switch (role) {
		case -1:
			return " ";
		case EMPTY:
			return "";
		case SPACE:
			return " ";
		case BEGIN_BLOCK:
			indent++;
			return "\n";
		case END_BLOCK:
			indent--;
			return "";
		case INDENT:
			StringBuffer result = new StringBuffer("");
			for (int i = 0; i < indent; i++) {
				result.append("    ");
			}
			return result.toString();
		case STATEMENT:
			return "\n";
		default:
			throw new RuntimeException("assert");
		}
	}	

}
