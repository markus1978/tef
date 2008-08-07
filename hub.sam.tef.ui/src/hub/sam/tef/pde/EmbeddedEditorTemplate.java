package hub.sam.tef.pde;

import hub.sam.tef.ui.TEFPlugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.TemplateOption;
import org.osgi.framework.Bundle;

public class EmbeddedEditorTemplate extends OptionTemplateSection {

	public static final String EDITOR_NAME = "editorName"; //$NON-NLS-1$
	public static final String MODEL_PLUGIN_ID = "modelPluginId";
	public static final String MODEL_PLUGIN_NAME = "modelPluginName";
	public static final String PACKAGE_PREFIX = "packagePrefix";

	private String pluginId = "";
	
	/**
	 * Constructor for EditorTemplate.
	 */
	public EmbeddedEditorTemplate() {
		setPageCount(1);
		createOptions();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.pde.ui.templates.AbstractTemplateSection#getDependencies(java.lang.String)
	 */
	public IPluginReference[] getDependencies(String schemaVersion) {
		if (schemaVersion != null) {
			IPluginReference[] dep = new IPluginReference[5];
			dep[0] = new PluginReference("org.eclipse.core.runtime", null, 0); //$NON-NLS-1$
			dep[1] = new PluginReference("org.eclipse.ui", null, 0); //$NON-NLS-1$
			dep[2] = new PluginReference("hub.sam.tef", null, 0); //$NON-NLS-1$
			dep[3] = new PluginReference(getStringOption(MODEL_PLUGIN_ID), null, 0);
			dep[4] = new PluginReference(getStringOption(MODEL_PLUGIN_ID) + ".edit", null, 0);
			return dep;
		}
		return super.getDependencies(schemaVersion);
	}

	public void addPages(Wizard wizard) {
		WizardPage page = createPage(0); // TODO documentation reference
		page.setTitle("Sample TEF Text Editor");
		page.setDescription("Choose the options that will be used to generate the TEF Text editor.");
		wizard.addPage(page);
		markPagesAdded();
	}

	private void createOptions() {
		// first page
		addOption(
			PACKAGE_PREFIX,
			"Java package prefix",
			(String)null,
			0);
		addOption(
			EDITOR_NAME,
			"Editor name",
			"model editor",
			0);
		addOption(
			MODEL_PLUGIN_ID,
			"Model plugin id",
			(String)null,
			0);
		addOption(
			MODEL_PLUGIN_NAME,
			"Model plugin name",
			(String)null,
			0);
	}

	public String getSectionId() {
		return "embedded-editor"; //$NON-NLS-1$
	}
	/*
	 * @see ITemplateSection#getNumberOfWorkUnits()
	 */
	public int getNumberOfWorkUnits() {
		return super.getNumberOfWorkUnits() + 1;
	}

	protected void initializeFields(IFieldData data) {
		// In a new project wizard, we don't know this yet - the
		// model has not been created
		String id = data.getId();
		initializeOption(KEY_PACKAGE_NAME, getFormattedPackageName(id));		
	}
	
	public void initializeFields(IPluginModelBase model) {
		// In the new extension wizard, the model exists so
		// we can initialize directly from it
		pluginId = model.getPluginBase().getId();		
	
		initializeOption(KEY_PACKAGE_NAME, getFormattedPackageName(pluginId));
		initializeOption(PACKAGE_PREFIX, getFormattedPackageName(pluginId));
		initializeOption(MODEL_PLUGIN_ID, getFormattedPackageName(pluginId) + ".model");
		initializeOption(MODEL_PLUGIN_NAME, getFormattedPackageName(pluginId) + ".model");
	}

	public boolean isDependentOnParentWizard() {
		return true;
	}

	/**
	 * @see GenericTemplateSection#validateOptions(TemplateOption)
	 */
	public void validateOptions(TemplateOption source) {
		if (source.isRequired() && source.isEmpty()) {
			flagMissingRequiredOption(source);
		} else {
			validateContainerPage(source);
		}
	}

	private void validateContainerPage(TemplateOption source) {
		TemplateOption[] options = getOptions(0);
		for (int i = 0; i < options.length; i++) {
			TemplateOption nextOption = options[i];
			if (nextOption.isRequired() && nextOption.isEmpty()) {
				flagMissingRequiredOption(nextOption);
				return;
			}
		}
		resetPageState();
	}

	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginExtension extension = createExtension(getUsedExtensionPoint(), true);
		IPluginModelFactory factory = model.getPluginFactory();

		IPluginElement editorElement = factory.createElement(extension);
		editorElement.setName("popupeditor"); //$NON-NLS-1$
		editorElement.setAttribute("name", getStringOption(EDITOR_NAME)); //$NON-NLS-1$
		editorElement.setAttribute("metaModelURI", "http://www.informatik.hu-berlin.de/sam/meta-tools/expressions"); //$NON-NLS-1$

		editorElement.setAttribute(
			"class", //$NON-NLS-1$
			getStringOption(PACKAGE_PREFIX) + "." + "EmbeddedEditor"); //$NON-NLS-1$		
		extension.add(editorElement);
		if (!extension.isInTheModel())
			plugin.add(extension);
	}

	protected ResourceBundle getPluginResourceBundle() {
		Bundle bundle = Platform.getBundle(TEFPlugin.getDefault().getBundle().getSymbolicName());
		return Platform.getResourceBundle(bundle);
	}
	
	protected URL getInstallURL() {
		return TEFPlugin.getDefault().getBundle().getEntry("/");
	}
	
	public URL getTemplateLocation() {
		try {
			String[] candidates = getDirectoryCandidates();
			for (int i = 0; i < candidates.length; i++) {
				if (TEFPlugin.getDefault().getBundle().getEntry(candidates[i]) != null) {
					URL candidate = new URL(getInstallURL(), candidates[i]);
					return candidate;
				}
			}
		} catch (MalformedURLException e) {
		}
		return null;
	}

	private String[] getDirectoryCandidates() {
		return new String[] { "templates" + "/" + getSectionId() + "/" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.pde.ui.templates.ITemplateSection#getFoldersToInclude()
	 */
	public String[] getNewFiles() {
		return new String[0];
	}
	
	protected String getFormattedPackageName(String id){
		String packageName = getFormattedPackageNameWithOutSuffix(id);
	    if (packageName.length() != 0)
	        return packageName; //$NON-NLS-1$
	    return "editors"; //$NON-NLS-1$
	}
	
	protected String getFormattedPackageNameWithOutSuffix(String id) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (buffer.length() == 0) {
				if (Character.isJavaIdentifierStart(ch))
					buffer.append(Character.toLowerCase(ch));
			} else {
				if (Character.isJavaIdentifierPart(ch) || ch == '.')
					buffer.append(ch);
			}
		}

		return buffer.toString().toLowerCase(Locale.ENGLISH);	    
	}
	
	public String getUsedExtensionPoint() {
		return "hub.sam.tef.popupeditor"; //$NON-NLS-1$
	}
}
