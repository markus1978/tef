package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.SingleReductionCompletion;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Symbol;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultContentAssistSemantics extends SingleReductionCompletion 
		implements IContentAssistSemantics {

	private final PropertyBinding fBinding;
	private final String[] fPrefix;
	
	public DefaultContentAssistSemantics(PropertyBinding binding) {
		super();
		this.fBinding = binding;
		Rule rule = getRule();
		List<String> prefix = new ArrayList<String>();
		loop: for (Symbol rhsPart: rule.getRhs()) {
			if (rhsPart instanceof NonTerminal && 
					((NonTerminal)rhsPart).getPropertyBinding() == fBinding) {
				break loop;
			}
			prefix.add(rhsPart.getRCCSymbol());
		}
		fPrefix = prefix.toArray(new String[] {});
	}

	@Override
	public final Rule getRule() {
		return (Rule)fBinding.eContainer().eContainer();
	}

	@Override
	public final String[] getRulePrefix() {
		return fPrefix;
	}
}
