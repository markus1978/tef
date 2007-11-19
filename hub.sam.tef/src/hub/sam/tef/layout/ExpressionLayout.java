package hub.sam.tef.layout;


public class ExpressionLayout extends AbstractLayoutManager {

	public static final int EMTPY = 1;
	public static final int SPACE = 2;
	public static final int SPACE_SEPARATOR = 3;
	
	@Override
	public String getSpace(int role) throws UnknownWhitespaceRole {
		switch (role) {
		case EMTPY:
			return "";
		case SPACE:
			return " ";
		case SPACE_SEPARATOR:
			return " ";
		case -1:
			return " ";
		default:
			throw new UnknownWhitespaceRole();
		}
	}
	
}
