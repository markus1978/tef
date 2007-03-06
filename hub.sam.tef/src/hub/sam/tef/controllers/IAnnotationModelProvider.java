package hub.sam.tef.controllers;

import hub.sam.tef.TEFAnnotation;

public interface IAnnotationModelProvider {
	
	public void addAnnotation(TEFAnnotation annotation);
	
	public void removeAnnotation(TEFAnnotation annotation);
}
