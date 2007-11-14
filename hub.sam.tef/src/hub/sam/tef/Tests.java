package hub.sam.tef;

import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.modelcreating.ResolutionState;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslPackage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class Tests {

	public static ResourceSet resourceSet = null;

	public static void reconciliation() {
		String content = prettyPrintExampleEcoreModel().getContent();
		System.out.println(content);
		Syntax syntax = Tests.createExampleEcoreSyntax();
		
		ParserSemantics semantics = new ParserSemantics(syntax);
		Parser parser = new Parser(syntax);
	
		boolean parseOk = false;
		try {
			parseOk = parser.parse(content, semantics);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if (!parseOk) {
			System.out.println("Could not parse the document.");
			return;
		}
		
		System.out.println(semantics.getResult().toString());
		
		Resource resource = new ResourceImpl();
		
		ParseTreeNode parseResult = semantics.getResult();
		EObject creationResult = null;
		try {
			
			ModelCreatingContext modelCreationContext = new ModelCreatingContext(resource,
					new EPackage[] {TslPackage.eINSTANCE, EcorePackage.eINSTANCE}, 
					new DefaultSemanitcsProvider(), content);
			creationResult = (EObject)
					parseResult.createModel(modelCreationContext, null);
			modelCreationContext.addToResource(creationResult);
			
			ResolutionState state = new ResolutionState(creationResult);
			parseResult.resolveModel(modelCreationContext, state);
		} catch (ModelCreatingException e) {
			e.printStackTrace();
		}
		
		PrettyPrinter printer = new PrettyPrinter(syntax, new DefaultSemanitcsProvider());
		printer.setLayout(new BlockLayout());
				
		String resultContent = null;
		try {
			resultContent = printer.print(creationResult).getContent();
		} catch (ModelCreatingException ex) {
			ex.printStackTrace();
		}
		System.out.print(resultContent);
		
		if (resultContent.equals(content)) {
			System.out.println("jjaaa");
		} else {
			System.err.println("NNNOOOOOOO");
		}
	}

	public static Syntax createExampleEcoreSyntax() {		
		return Utilities.loadSyntaxDescription("/hub.sam.tef.examples/example-syntax.tsl",
				new EPackage[] {EcorePackage.eINSTANCE});			
	}

	/**
	 * Test pretty printing based on the ecore example syntax and a simple
	 * ecore test model.
	 */
	public static PrettyPrintState prettyPrintExampleEcoreModel() {
		PrettyPrinter printer = new PrettyPrinter(Tests.createExampleEcoreSyntax(),
				new DefaultSemanitcsProvider());
		printer.setLayout(new BlockLayout());
		
		URI exampleModelFile = URI.createPlatformResourceURI(
				"/org.eclipse.emf.ecore/model/Ecore.ecore", false);			
		
		EPackage tslMetaModel = EcorePackage.eINSTANCE;	
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(tslMetaModel.getNsURI(), tslMetaModel);	
		Resource resource = resourceSet.getResource(exampleModelFile, true);				
		
		for (EObject content: resource.getContents()) {
			if (content instanceof EPackage) {
				try {
					return printer.print(content);
				} catch (ModelCreatingException e) {
					e.printStackTrace();
					return null;
				}				
			}
		}
		return null;
		
		/*
		EcoreFactory factory = EcoreFactory.eINSTANCE;
		EPackage package1 = factory.createEPackage();
		package1.setName("package1");
		EPackage package2 = factory.createEPackage();
		package2.setName("package2");
		package1.getESubpackages().add(package2);
		
		EClass class1 = factory.createEClass();
		class1.setName("class1");		
		package1.getEClassifiers().add(class1);
		
		EClass class2 = factory.createEClass();
		class2.setName("class2");		
		class2.getESuperTypes().add(class1);
		package1.getEClassifiers().add(class2);
		
		EClass class3 = factory.createEClass();
		class3.setName("class3");		
		class3.getESuperTypes().add(class1);
		class3.getESuperTypes().add(class2);
		package1.getEClassifiers().add(class3);
		
		PrettyPrinter printer = new PrettyPrinter(SyntaxDescription.createExampleEcoreSyntax());
		printer.print(package1);
		*/
	}

	public static void testTslParser() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(new Path("/hub.sam.tef/resources/examples/ecore.tslt"));
		
		String tslContent = null;
		
		try {
		    InputStream is = file.getContents();		
		    BufferedReader in = new BufferedReader(new InputStreamReader(is));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
			   buffer.append(line);
			}		
			tslContent = buffer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try {			
			Syntax syntax = Utilities.parseTsl(tslContent,
					new EPackage[] {TslPackage.eINSTANCE, EcorePackage.eINSTANCE});
			
			for(Rule rule: syntax.getRules()) {
				System.out.println(rule.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
