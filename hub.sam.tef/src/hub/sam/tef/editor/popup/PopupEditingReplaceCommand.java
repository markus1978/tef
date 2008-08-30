package hub.sam.tef.editor.popup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A specific EMF compound command used to replace an object edited with an TEF
 * embedded (a.k.a pop-up) editor. This command no only replaces the old-version
 * of the object with the new, edited, one, but also tries to reassign all
 * references towards elements within the old, now obsolete, object. This
 * reassigning of references is done using the objects assumed identity (TODO).
 * If reassigning fails, the reference is deleted.
 */
public class PopupEditingReplaceCommand extends CompoundCommand {
	
	private static class PopupEditingReplaceCommandParameter extends CommandParameter {

		private final EObject originalObject;
		private final EObject newObject;	
		
		private final Command fReplaceCommand;
		private final Command fResolveCommand;
		
		public PopupEditingReplaceCommandParameter(
				EObject originalObject, EObject newObject,
				Command replaceCommand, Command resolveCommand) {
			super(null);
			this.originalObject = originalObject;
			this.newObject = newObject;
			fReplaceCommand = replaceCommand;
			fResolveCommand = resolveCommand;
		}		
	}
	
	public static Command create(EditingDomain domain, EObject originalObject,
			EObject newObject, Command replaceCommand, Command resolveCommand) {
		return domain.createCommand(PopupEditingReplaceCommand.class,
				new PopupEditingReplaceCommandParameter(originalObject,
						newObject, replaceCommand, resolveCommand));
	}

    protected static final String LABEL = "TEF popup editing replace command";
	protected static final String DESCRIPTION = "TEF popup editing replace command";
	
	private final EObject fOriginalObject;
	private final EObject fNewObject;
	private final EditingDomain editingDomain;
	
	private final Command fReplaceCommand;
	private final Command fResolveCommand;

	public PopupEditingReplaceCommand(EditingDomain domain,
			CommandParameter parameter) {
		super(0, LABEL, DESCRIPTION);
		this.editingDomain = domain;
		this.fOriginalObject = ((PopupEditingReplaceCommandParameter)parameter).originalObject;
		this.fNewObject = ((PopupEditingReplaceCommandParameter)parameter).newObject;
		this.fReplaceCommand = ((PopupEditingReplaceCommandParameter)parameter).fReplaceCommand;
		this.fResolveCommand = ((PopupEditingReplaceCommandParameter)parameter).fResolveCommand;
	}
	
  @Override
	protected boolean prepare() {
		prepareCommand();
		return super.prepare();
	}
  
  protected void prepareCommand() {
		append(fReplaceCommand);
		append(fResolveCommand);
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
						
						// throw new RuntimeException("impossoble to do"); //TODO
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
