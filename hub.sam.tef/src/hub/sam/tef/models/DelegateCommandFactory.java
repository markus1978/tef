package hub.sam.tef.models;

public class DelegateCommandFactory implements ICommandFactory {
	
	private final ICommandFactory fDelegatee;

	public DelegateCommandFactory(final ICommandFactory delegatee) {
		super();
		fDelegatee = delegatee;
	}

	public ICommand add(final IModelElement owner, final String property, final Object value, int position) {
		if (owner instanceof InternalModelElement) {
			return new ICommand() {
				public void execute() {
					((InternalCollection)((ICollection)owner.getValue(property))).add(value);					
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
		} else {
			return fDelegatee.set(owner, property, value);
		}
	}

	
}
