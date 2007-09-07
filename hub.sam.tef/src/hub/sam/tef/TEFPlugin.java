package hub.sam.tef;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class TEFPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "hub.sam.tef";
	
	private ResourceBundle fResourceBundle;

	// The shared instance
	private static TEFPlugin plugin;
	
	/**
	 * The constructor
	 */
	public TEFPlugin() {
		plugin = this;
		try {
			fResourceBundle = ResourceBundle.getBundle(this.getClass().getName());
		} catch (MissingResourceException ex) {
			fResourceBundle = null;
		}
	}
	
	public ResourceBundle getResourceBundle() {
		return fResourceBundle;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TEFPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
