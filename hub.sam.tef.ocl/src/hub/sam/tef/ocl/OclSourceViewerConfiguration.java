package hub.sam.tef.ocl;

import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.source.ISourceViewer;

import hub.sam.tef.TEFSourceViewerConfiguration;

public class OclSourceViewerConfiguration extends TEFSourceViewerConfiguration {

	/**
	 * Normal TEFAutoEditStrategy is disabled, because only needed for TEF Phase 1 editors. It
	 * was used to reject unwanted user changes. But these changes have to be displayed in Phase 2.
	 */
	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[] {};
	}

}
