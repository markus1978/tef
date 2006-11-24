package editortest.controller;

import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;
import editortest.model.IModelElement;
import editortest.model.ModelEventListener;

/**
 * This is a special model event listener for views that may be hidden in the future.
 * This listener registeres a {@link ITextStatusListener} at a given text and will
 * remove itself from the model is will be attached to.
 */
public abstract class TransientTextModelEventListener extends ModelEventListener {

	private boolean active;
	
	public TransientTextModelEventListener(final IModelElement model, Text text) {
		active = !text.isHidden();		
		text.addTextStatusListener(new ITextStatusListener() {
			public void hidden() {
				if (active) {
					model.removeChangeListener(TransientTextModelEventListener.this);
					active = false;
				}
			}

			public void shown() {
				if (!active) {
					model.addChangeListener(TransientTextModelEventListener.this);
					active = true;
				}
			}			
		});
	}
	
	public boolean isActive() {
		return active;
	}
		
}
