package hub.sam.tef.editor.popup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public class PopupEditingReplaceCommand extends CompoundCommand {
	
	private static class PopupEditingReplaceCommandParameter extends CommandParameter {

		private final EObject originalObject;
		private final EObject newObject;		

		public PopupEditingReplaceCommandParameter(
				EObject originalObject, EObject newObject) {
			super(null);
			this.originalObject = originalObject;
			this.newObject = newObject;
		}				
	}
	
	public static Command create(EditingDomain domain, EObject originalObject,
			EObject newObject) {
		return domain.createCommand(PopupEditingReplaceCommand.class,
				new PopupEditingReplaceCommandParameter(originalObject,
						newObject));
	}

    protected static final String LABEL = "TEF popup editing replace command";
	protected static final String DESCRIPTION = "TEF popup editing replace command";
	
	private final EObject fOriginalObject;
	private final EObject fNewObject;
	private final EditingDomain editingDomain;

	public PopupEditingReplaceCommand(EditingDomain domain,
			CommandParameter parameter) {
		super(0, LABEL, DESCRIPTION);
		this.editingDomain = domain;
		this.fOriginalObject = ((PopupEditingReplaceCommandParameter)parameter).originalObject;
		this.fNewObject = ((PopupEditingReplaceCommandParameter)parameter).newObject;
	}
	
    @Override
	protected boolean prepare() {
		prepareCommand();
		return super.prepare();
	}
  
    @SuppressWarnings("unchecked")
	protected void prepareCommand() {
    	EObject container = fOriginalObject.eContainer();
		EList containerList = null;
		Command setReplaceCommand = null;
		if (container == null) {
			containerList = fOriginalObject.eResource().getContents();				
		} else {	
			EReference containmentFeature = fOriginalObject.eContainmentFeature();	
			if (containmentFeature.isMany()) {
				containerList = (EList)container.eGet(containmentFeature);
			} else { 									
				setReplaceCommand = SetCommand.create(editingDomain, container, 
						containmentFeature, fNewObject);					
			}
		}
		if (containerList != null) {
			setReplaceCommand = new ReplaceCommand(editingDomain, 
					containerList, fOriginalObject, fNewObject);
		}
		append(setReplaceCommand);		
	}

	@Override
	public void execute() {
		Collection<EObject> eObjects = new UniqueEList<EObject>();

		Object object = AdapterFactoryEditingDomain.unwrap(fOriginalObject);
		if (object instanceof EObject) {
			eObjects.add((EObject) object);
			for (Iterator<EObject> j = ((EObject) object).eAllContents(); j
					.hasNext();) {
				eObjects.add(j.next());
			}
		} else if (object instanceof Resource) {
			for (Iterator<EObject> j = ((Resource) object).getAllContents(); j
					.hasNext();) {
				eObjects.add(j.next());
			}
		}

		Map<EObject, Collection<EStructuralFeature.Setting>> usages = EcoreUtil.UsageCrossReferencer
				.findAll(eObjects, editingDomain.getResourceSet());

		super.execute();

		Collection<EObject> potentialReplacements = new ArrayList<EObject>();
		potentialReplacements.add(fNewObject);
		for (Iterator<EObject> j = fNewObject.eAllContents(); j.hasNext();) {
			potentialReplacements.add(j.next());
		}
		
		for (Map.Entry<EObject, Collection<EStructuralFeature.Setting>> entry : usages
				.entrySet()) {
			EObject eObject = entry.getKey();
			Collection<EStructuralFeature.Setting> settings = entry.getValue();
			for (EStructuralFeature.Setting setting : settings) {
				EObject referencingEObject = setting.getEObject();
				if (!eObjects.contains(referencingEObject)) {
					EStructuralFeature eStructuralFeature = setting
							.getEStructuralFeature();
					if (eStructuralFeature.isChangeable()) {
						// try to find a replacement for the object
						Collection<EObject> replacements = replacement(eObject, potentialReplacements);
						if (replacements.size() == 0) {
							if (eStructuralFeature.isMany()) {
								appendAndExecute(RemoveCommand.create(editingDomain,
										referencingEObject, eStructuralFeature,
										eObject));
							} else {
								appendAndExecute(SetCommand.create(editingDomain,
										referencingEObject, eStructuralFeature,
										null));
							}	
						} else if (replacements.size() == 1) {
							if (eStructuralFeature.isMany()) {
								appendAndExecute(ReplaceCommand.create(editingDomain,
										referencingEObject, eStructuralFeature,
										eObject, replacements));
							} else {
								appendAndExecute(SetCommand.create(editingDomain,
										referencingEObject, eStructuralFeature,
										replacements.iterator().next()));
							}
						} else {
							throw new RuntimeException("unambigeous references"); //TODO
						}												
					} else {
						throw new RuntimeException("impossoble to do"); //TODO
					}
				}
			}
		}
	}	
	
	private Collection<EObject> replacement(EObject referencedObject, Collection<EObject> potentialReferencedObjects) {
		List<EObject> result = new ArrayList<EObject>();		
		EClassifier classifier = referencedObject.eClass();
		for (EObject potentialReferencedObject: potentialReferencedObjects) {							
			EClass classOfNext = potentialReferencedObject.eClass();
			if (classifier instanceof EClass &&
					((EClass)classifier).isSuperTypeOf(classOfNext)) {
				for (EAttribute possibleIdAttr: classOfNext.getEAllAttributes()) {
					if (possibleIdAttr.getName().equals("name")) {
						Object id = referencedObject.eGet(possibleIdAttr);
						if (id != null && id.equals(potentialReferencedObject.eGet(possibleIdAttr))) {
							result.add(potentialReferencedObject);							
						}
					}
				}
			}			
		}
		return result;		
	}
}
