package hub.sam.tef.models.extensions;

import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.ICommandFactory;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IModelElementExtension;
import hub.sam.tef.models.InternalCollection;

public class DelegateCommandFactory implements ICommandFactory {
	
	private final ICommandFactory fDelegatee;

	public DelegateCommandFactory(final ICommandFactory delegatee) {
		super();
		fDelegatee = delegatee;
	}

	public ICommand add(final IModelElement owner, final String property, final Object value, final int position) {
		if (owner instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					((InternalCollection)((ICollection)owner.getValue(property))).add(value);					
				}				
			};
		} else if (value instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					Object value = owner.getValue(property);
					if (value instanceof SequenceExtension) {
						((SequenceExtension)value).addValue(value, position);
					} else if (value instanceof CollectionExtension) {
						((CollectionExtension)owner.getValue(property)).addValue(value);
					} else {
						throw new RuntimeException("assert");
					}					
				}				
			};
		} else {
			return fDelegatee.add(owner, property, value, position);
		}
	}

	public ICommand add(final IModelElement owner, final String property, final Object value) {
		if (owner instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					((InternalCollection)((ICollection)owner.getValue(property))).add(value);					
				}				
			};
		} else if (value instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					Object value = owner.getValue(property);
					if (value instanceof SequenceExtension) {
						((SequenceExtension)value).addValue(value);
					} else if (value instanceof CollectionExtension) {
						((CollectionExtension)owner.getValue(property)).addValue(value);
					} else {
						throw new RuntimeException("assert");
					}					
				}				
			};
		} else {
			return fDelegatee.add(owner, property, value);
		}
	}

	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property, int position) {
		return fDelegatee.createChild(owner, type, property, position);
	}

	public ICommand createChild(IModelElement owner, IMetaModelElement type, String property) {
		return fDelegatee.createChild(owner, type, property);
	}

	public ICommand delete(Object element) {
		return fDelegatee.delete(element);
	}

	public ICommand remove(IModelElement owner, String property, Object value) {
		return fDelegatee.remove(owner, property, value);
	}

	public ICommand replace(IModelElement owner, String property, Object oldValue, Object newValue) {
		return fDelegatee.replace(owner, property, oldValue, newValue);
	}

	public ICommand set(final IModelElement owner, final String property, final Object value) {
		if (owner instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					((InternalModelElement)owner).setValue(property, value);					
				}				
			};	
		} else if (value instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {					
					((ModelElementExtension)owner).setValue(property, value);		
				}				
			};			
		} else {			
			return fDelegatee.set(owner, property, value);
		}
	}

	
}
