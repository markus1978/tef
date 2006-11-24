package hub.sam.tef.templates;

/**
 * This listner is used to react on changes in values. ValueTemplates create
 * views that represent values, only the ValueTemplate knows how the value
 * changes when the view is given events. But the ValueTemplate does not know
 * what to do with the model when the value change. Therefore, the corresponding
 * PropertyTemplate gives an instance of this interface when the value view is
 * created. This ValueTemplate uses this instance to propagate a change in the
 * value to the PropertyTemplate.
 */
public interface IValueChangeListener<ModelType> {
	void valueChanges(ModelType newValue);
}
