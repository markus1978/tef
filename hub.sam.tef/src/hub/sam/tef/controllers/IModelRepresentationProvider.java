package hub.sam.tef.controllers;

import hub.sam.tef.models.IModel;
import hub.sam.tef.templates.LayoutManager;

public interface IModelRepresentationProvider {
	public IModel getModel();
	public LayoutManager getLayoutManager();
}
