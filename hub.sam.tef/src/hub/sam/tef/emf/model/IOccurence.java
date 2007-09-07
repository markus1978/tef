package hub.sam.tef.emf.model;

import hub.sam.util.container.IWatchedDisposable;

public interface IOccurence extends IWatchedDisposable {
	
	public int getAbsolutOffset(int innerOffset);
	
	public int getLength();

}
