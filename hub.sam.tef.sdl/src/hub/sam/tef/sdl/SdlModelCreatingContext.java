package hub.sam.tef.sdl;

import java.util.Iterator;

import hub.sam.sdl.ConcreteSyntaxSdlStateList;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlNamedState;
import hub.sam.sdl.SdlSplit;
import hub.sam.sdl.SdlState;
import hub.sam.sdl.SdlStateAutomaton;
import hub.sam.sdl.SdlTransition;
import hub.sam.sdl.SdlTrigger;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.semantics.ISemanticsProvider;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class SdlModelCreatingContext extends ModelCreatingContext {
	SdlModelCreatingContext(EPackage[] packages,
			ISemanticsProvider semanticsProvider, Resource resource,
			String text) {
		super(packages, semanticsProvider, resource, text);
	}

	@Override
	public Object evaluateActionStatement(String methodName,
			EList<Object> methodParameters) {
		return null;
	}

	@Override
	public Object evaluateActionStatement(String methodName,
			EList<Object> methodParameters,
			ActionStatementEvaluationTime time) throws ModelCreatingException {
		if (time == ActionStatementEvaluationTime.create) {
			if (methodName.equals("decisions")) {
				decisions((SdlTransition)methodParameters.get(0), 
						(SdlSplit)methodParameters.get(1));
			} else if (methodName.equals("stateList")) {
				stateListCreate((SdlStateAutomaton)methodParameters.get(0),
						(ConcreteSyntaxSdlStateList)methodParameters.get(1));
			}
		} else if (time == ActionStatementEvaluationTime.resolve) {
			if (methodName.equals("stateList")) {
				stateListResolve((SdlStateAutomaton)methodParameters.get(0),
						(ConcreteSyntaxSdlStateList)methodParameters.get(1));
			}
		}
		return null;
	}
	
	private void decisions(SdlTransition transition, SdlSplit decision)
			throws ModelCreatingException {
		EObject context = transition;
		while (context != null && !(context instanceof SdlStateAutomaton)) {
			context = context.eContainer();
		}
		if (context == null) {
			throw new ModelCreatingException("Impossible");
		} else {
			((SdlStateAutomaton)context).getState().add(decision);
		}
	}
	
	private void stateListCreate(SdlStateAutomaton automaton,
			ConcreteSyntaxSdlStateList stateList) throws ModelCreatingException {
		for (String name : stateList.getNames()) {
			// try to find existing state with this name
			SdlState stateWithName = null;
			loop: for (SdlNamedState namedStateOfAutomaton : automaton
					.getNamedState()) {
				if (namedStateOfAutomaton instanceof SdlState
						&& (!(namedStateOfAutomaton instanceof ConcreteSyntaxSdlStateList))) {
					if (name.equals(namedStateOfAutomaton.getName())) {
						stateWithName = (SdlState) namedStateOfAutomaton;
						break loop;
					}
				}
			}

			// add a new state if it doesn't exist
			if (stateWithName == null) {
				stateWithName = (SdlState) instantiate(EmfSdlPackage.eINSTANCE
						.getSdlState(), getTreeNodeForObject(stateList));
				stateWithName.setName(name);
				automaton.getNamedState().add(stateWithName);
			}
		}
	}
	
	private void stateListResolve(SdlStateAutomaton automaton, ConcreteSyntaxSdlStateList stateList) 
			throws ModelCreatingException {		
		for(String name: stateList.getNames()) {
			// try to find existing state with this name
			SdlState stateWithName = null;
			loop: for (SdlNamedState namedStateOfAutomaton: automaton.getNamedState()) {
				if (namedStateOfAutomaton instanceof SdlState &&
						(!(namedStateOfAutomaton instanceof ConcreteSyntaxSdlStateList))) {
					if (name.equals(namedStateOfAutomaton.getName())) {
						stateWithName = (SdlState)namedStateOfAutomaton;
						break loop;
					}
				}
			}
						
			if (stateWithName == null) {
				Assert.isTrue(false);
			}
			// add the trigger of the state list to the state
			EList<SdlTrigger> triggerList = stateList.getTrigger();
			Assert.isTrue(triggerList.size() == 1);
			SdlTrigger trigger = triggerList.get(0);
			SdlTrigger triggerCopy = (SdlTrigger)EcoreUtil.copy(trigger);
			trace(trigger, triggerCopy);
			stateWithName.getTrigger().add(triggerCopy);
			Iterator<EObject> origIt = trigger.eAllContents();
			Iterator<EObject> copyIt = triggerCopy.eAllContents();
			while(origIt.hasNext()) {
				EObject orig = origIt.next();
				EObject copy = copyIt.next();
				trace(orig, copy);
			}
		}
		
		// remove the stateList
		automaton.getNamedState().remove(stateList);
		getResource().getContents().remove(stateList);
	}
}