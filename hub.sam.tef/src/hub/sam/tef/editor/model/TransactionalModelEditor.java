package hub.sam.tef.editor.model;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeRuleNode;
import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.util.MultiMap;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.Position;

/**
 * This class can be extended to provide a {@link ModelEditor} that works on a
 * {@link TransactionalEditingDomain} and that encapsulates all model modifications in EMF
 * {@link Command}s.
 * 
 * @author <a href="mailto:sadilek@informatik.hu-berlin.de">Daniel Sadilek</a>
 */
public abstract class TransactionalModelEditor extends ModelEditor {
    
	/**
	 * Subclasses must implement this method to return the id of the editing domain that this
	 * transactional model editor should use.
	 * 
	 * @return the id of the editing domain to be used
	 */
	protected abstract String getEditingDomainId();
	
	protected class ModelCreatingContextTransactionProxy implements IModelCreatingContext {
        
        private final IModelCreatingContext realContext;

        public ModelCreatingContextTransactionProxy(IModelCreatingContext realContext, EPackage[] packages,
                ISemanticsProvider semanticsProvider, Resource resource, String text) {
            this.realContext = realContext;
        }

        public void addCreatedObject(final EObject object) {
            TransactionalModelEditor.this.execute(new Runnable() {
                public void run() {
                    realContext.getResource().getContents().clear();
                    realContext.getResource().getContents().add(object);
                }
            });
        }

        public void addResolution(final Resolution resolution) {
            TransactionalModelEditor.this.execute(new Runnable() {
                public void run() {
                    realContext.addResolution(resolution);
                }
            });
        }

        public void addError(AbstractError error) {
            realContext.addError(error);
        }

        public void addOccurence(EObject object, Position position) {
            realContext.addOccurence(object, position);
        }

        public void destroy() {
            realContext.destroy();
        }

        public Object evaluateActionStatement(String methodName, EList<Object> methodParameters,
                ActionStatementEvaluationTime time) throws ModelCreatingException {
            return realContext.evaluateActionStatement(methodName, methodParameters, time);
        }

        public Object evaluateActionStatement(String methodName, EList<Object> methodParameters) throws ModelCreatingException {
            return realContext.evaluateActionStatement(methodName, methodParameters, ActionStatementEvaluationTime.resolve);
        }

        public void executeResolutions() {
            realContext.executeResolutions();
        }

        public Iterable<Object> getAllContents() {
            RunnableWithResult<Iterable<Object>> runnable = new RunnableWithResult.Impl<Iterable<Object>>() {
                public void run() {
                    setResult(realContext.getAllContents());
                }
            };
            TransactionalModelEditor.this.execute(runnable);
            return runnable.getResult();
        }

        public Collection<AbstractError> getErrors() {
            return realContext.getErrors();
        }

        public EPackage[] getMetaModelPackages() {
            return realContext.getMetaModelPackages();
        }

        public MultiMap<EObject, Position> getOccurences() {
            return realContext.getOccurences();
        }

        public Resource getResource() {
            return realContext.getResource();
        }

        public ISemanticsProvider getSemanticsProvider() {
            return realContext.getSemanticsProvider();
        }

        public String getText() {
            return realContext.getText();
        }

        public ParseTreeRuleNode getTreeNodeForObject(EObject object) {
            return realContext.getTreeNodeForObject(object);
        }

        public EObject instantiate(EClass metaClass, ParseTreeRuleNode node) throws ModelCreatingException {
            return realContext.instantiate(metaClass, node);
        }

        public void trace(EObject source, EObject target) {
            realContext.trace(source, target);
        }

        public <T> T getAdapter(Class<T> adapterClass) {
            return realContext.getAdapter(adapterClass);
        }
        
    }
    
    public IModelCreatingContext createModelCreatingContext() {
        return new ModelCreatingContextTransactionProxy(super.createModelCreatingContext(), getMetaModelPackages(),
                getSemanticsProvider(), getCurrentModel(), getCurrentText());
    }
    
    @Override
    protected ResourceSet createResourceSet() {
        return getEditingDomain().getResourceSet();
    }
    
    protected TransactionalEditingDomain getEditingDomain() {
        TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
                .getEditingDomain(getEditingDomainId()); //$NON-NLS-1$
        return editingDomain;
    }
    
    protected void execute(final Runnable runnable) {
        getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {
            @Override
            protected void doExecute() {
                runnable.run();
            }
        });
    }

}
