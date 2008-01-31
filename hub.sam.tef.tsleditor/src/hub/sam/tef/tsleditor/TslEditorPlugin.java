package hub.sam.tef.tsleditor;

import java.util.ResourceBundle;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class TslEditorPlugin extends AbstractUIPlugin {

	public static ResourceBundle getMessagesBundle() {
		return ResourceBundle.getBundle("resources/messages");
	}
	
	// The plug-in ID
	public static final String PLUGIN_ID = "hub.sam.tef.tsleditor";

	// The shared instance
	private static TslEditorPlugin plugin;
	
	/**
	 * The constructor
	 */
	public TslEditorPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
	public static TslEditorPlugin getDefault() {
		return plugin;
	}

}
