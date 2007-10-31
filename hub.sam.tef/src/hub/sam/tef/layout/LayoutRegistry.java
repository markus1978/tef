package hub.sam.tef.layout;

import hub.sam.tef.TEFPlugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

public class LayoutRegistry {

	private final static LayoutRegistry fDefaultLayoutRegistry = new LayoutRegistry();
	
	public static LayoutRegistry getDefaultRegistry() {
		return fDefaultLayoutRegistry;
	}
	
	private final Map<String, AbstractLayoutManager> fLayouts = new HashMap<String, AbstractLayoutManager>();
	
	private void initialise() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		try {
			IConfigurationElement[] elements = reg.getConfigurationElementsFor(TEFPlugin.PLUGIN_ID, 
					"layout");
			for (IConfigurationElement element: elements) {
				String name = element.getAttribute("name");
				AbstractLayoutManager layout = (AbstractLayoutManager)element.createExecutableExtension("class");
				fLayouts.put(name, layout);
			}
		} catch (Exception e) {
			TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
					Status.ERROR, "could not retrieve layout managers", e));
		}
	}
	
	private LayoutRegistry() {
		initialise();
	}
	
	public Collection<String> getLayoutManagerNames() {
		return fLayouts.keySet();
	}
	
	public AbstractLayoutManager getLayoutManager(String name) {
		return fLayouts.get(name);		
	}
}
