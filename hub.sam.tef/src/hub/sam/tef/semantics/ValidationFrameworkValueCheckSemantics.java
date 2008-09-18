package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.tsl.ElementBinding;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

/**
 * A value check semantics that triggers the validation frameworks. This is also used as the default
 * value check semantics for all model elements.
 */
public class ValidationFrameworkValueCheckSemantics implements IValueCheckSemantics {

	private final IBatchValidator validator;

	public ValidationFrameworkValueCheckSemantics() {
		super();
		validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(
				EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(false);
	}

	public void check(ParseTreeNode parseTreeNode, IModelCreatingContext context, EObject value,
			ElementBinding binding) throws ModelCreatingException {
		if (value.eContainer() == null) {
			final IStatus status = validator.validate(value);
			if (!status.isOK()) {
				if (!status.isMultiStatus()) {
					IConstraintStatus cstatus = (IConstraintStatus) status;
					context.addError(new ModelCheckError(cstatus.getMessage(), cstatus.getTarget(),
							cstatus.getSeverity()));
				} else {
					IStatus[] children = status.getChildren();
					for (int i = 0; i < children.length; i++) {
						IConstraintStatus cstatus = (IConstraintStatus) children[i];
						context.addError(new ModelCheckError(cstatus.getMessage(), cstatus
								.getTarget(), cstatus.getSeverity()));
					}
				}
			}
		}
	}
}
