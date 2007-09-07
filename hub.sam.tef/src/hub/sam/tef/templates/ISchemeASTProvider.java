package hub.sam.tef.templates;

import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;

/**
 * A special IASTProvider used by {@link CommonSchemeTemplate}. It is a
 * IASTProvider for the scheme template part of a common scheme template. It has
 * to be a special IASTProvider, because the normal IASTProvider of the scheme
 * template part has to be the IASTProvider of the common scheme template. In
 * other words the scheme template part has to provide two different
 * IASTProvider.
 */
public interface ISchemeASTProvider extends IASTProvider {

}
