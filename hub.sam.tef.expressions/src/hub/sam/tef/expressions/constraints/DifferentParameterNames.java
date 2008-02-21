package hub.sam.tef.expressions.constraints;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import expressions.Function;
import expressions.Parameter;

public class DifferentParameterNames extends AbstractModelConstraint {
	
	
	public DifferentParameterNames() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		Assert.isTrue(eObj instanceof Function);
		
		Function function = (Function)eObj;
		
		for (Object parameter1: function.getParameters()) {
			for (Object parameter2 : function.getParameters()) {
				if (((Parameter) parameter1).getName().equals(
						((Parameter) parameter2).getName())
						&& (parameter1 != parameter2)) {
					return ctx.createFailureStatus(new Object[] {});
				}
			}
		}
				
		return ctx.createSuccessStatus();
	}

}
