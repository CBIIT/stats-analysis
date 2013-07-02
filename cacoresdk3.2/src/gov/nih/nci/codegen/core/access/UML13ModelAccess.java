/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.access;

import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.core.util.XMLUtils;
import gov.nih.nci.codegen.framework.ModelAccess;
import gov.nih.nci.codegen.framework.ModelAccessException;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.jmi.model.ModelPackage;
import javax.jmi.model.MofPackage;
import javax.jmi.reflect.RefPackage;

import org.apache.log4j.Logger;
import org.netbeans.api.mdr.MDRManager;
import org.netbeans.api.mdr.MDRepository;
import org.netbeans.api.xmi.XMIReader;
import org.netbeans.api.xmi.XMIReaderFactory;
import org.w3c.dom.Element;

 
/**
 * Uses NetBeans MDR to read an XMI file and provide
 * a reference into an UML 1.3 model instance.
 * @author caBIO Team
 * @version 1.0
 * @see gov.nih.nci.codegen.framework.ModelAccess
 */
public class UML13ModelAccess implements ModelAccess, XMLConfigurable {
	
	private static final Logger log = Logger.getLogger(UML13ModelAccess.class);

	public static final String META_MODEL = "UML";

	public static final String META_MODEL_FILE = "01-12-02_Diff.xml";

	public static final String MODEL = "UMLInstance";

	private MofPackage _metaModel;

	private String _metaModelXmiFileName;

	private XMIReader _reader;

	private MDRepository _repository;

	/**
	 *  Creates an UML13ModelAccess instance
	 */
	public UML13ModelAccess() {
		initProperties();
		initRepository();
		initXmiReader();
		initMetaModel();
	}

	/**
	 * @see gov.nih.nci.codegen.framework.ModelAccess#beginTransaction()
	 */
	public void beginTransaction() throws ModelAccessException {
		try{
			_repository.beginTrans(true);
		}catch(Exception ex){
			log.error("Error beginning transaction -" + ex.getMessage());
			throw new ModelAccessException("Error beginning transaction", ex);
		}
	}

	/**
	 * @see gov.nih.nci.codegen.framework.ModelAccess#commitTransaction()
	 */
	public void commitTransaction() throws ModelAccessException {
		
		try{
			_repository.endTrans(false);
		}catch(Exception ex){
			log.error("Error ending transaction - " + ex.getMessage());
			throw new ModelAccessException("Error ending transaction", ex);
		}		
	}

	/**
	 * @see gov.nih.nci.codegen.core.XMLConfigurable#configure(org.w3c.dom.Element)
	 */
	public void configure(org.w3c.dom.Element config) throws ConfigurationException {
		
	}

	/**
	 * 
	 */
	private RefPackage getModelExtent() {
		RefPackage m = null;
		try{
			m = _repository.getExtent(MODEL);
		}catch(Exception ex){
			log.error("Error getting model extent - " + ex.getMessage());
			throw new RuntimeException("Error getting model extent", ex);
		}
		if(m == null){
			try{
				m = _repository.createExtent(MODEL, _metaModel);
			}catch(Exception ex){
				log.error("Error creating extent - " + ex.getMessage());
				throw new RuntimeException("Error creating extent", ex);
			}
		}
		return m;
	}
	
	private MofPackage getMofPackage(ModelPackage model, String pkgName) {
		MofPackage result = null;
		for (Iterator i = model.getMofPackage().refAllOfClass().iterator();
			i.hasNext();
			) {
			MofPackage pkg = (MofPackage) i.next();
			if (pkg.getContainer() == null && pkgName.equals(pkg.getName())) {
				result = pkg;
				break;
			}
		}
		return result;
	}

	/**
	 * @see gov.nih.nci.codegen.framework.ModelAccess#getOutermostExtent()
	 */
	public RefPackage getOutermostExtent() {
		return getModelExtent();
	}

	private String getParameter(org.w3c.dom.Element config, String paramName) {
		String param = null;
		
		List params = XMLUtils.getChildren(config, "param");
		for(Iterator i = params.iterator(); i.hasNext();){
			Element paramEl = (Element)i.next();
			if(paramName.equals(paramEl.getAttribute("name"))){
				param = paramEl.getAttribute("value");
				break;
			}
		}

		return param;
	}

	private void initMetaModel() {
		try {
			ModelPackage mm = (ModelPackage) _repository.getExtent(META_MODEL);
			if (mm == null) {
				
				mm = (ModelPackage) _repository.createExtent(META_MODEL);
			}
			_metaModel = getMofPackage(mm, META_MODEL);
			if (_metaModel == null) {
				
				URL url = Thread.currentThread().getContextClassLoader().getResource(_metaModelXmiFileName);
				if(url == null){
					log.error("Couldn't get resource " + _metaModelXmiFileName);
					throw new RuntimeException("Couldn't get resource " + _metaModelXmiFileName);
				}
				_reader.read(url.toString(), mm);
			}
			_metaModel = getMofPackage(mm, META_MODEL);
		} catch (Exception ex) {
			log.error("Error initializing meta model" + ex.getMessage());
			throw new RuntimeException("Error initializing meta model", ex);
		}
	}

	private void initProperties() {
		_metaModelXmiFileName = System.getProperty(
				"codegen.modelAccess.metaModelFileName", META_MODEL_FILE);
	}

	private void initRepository() {
		try {

			//Switch class loader
			ClassLoader oldLoader = Thread.currentThread()
					.getContextClassLoader();
			Thread.currentThread().setContextClassLoader(
					getClass().getClassLoader());

			System
					.setProperty(
							"org.netbeans.mdr.storagemodel.StorageFactoryClassName",
							"org.netbeans.mdr.persistence.memoryimpl.StorageFactoryImpl");

			
			System.setProperty("org.netbeans.lib.jmi.Logger.fileName",
					"mdr.log");
			MDRManager mgr = MDRManager.getDefault();

			
			Thread.currentThread().setContextClassLoader(oldLoader);

			_repository = mgr.getDefault().getDefaultRepository();
		} catch (Exception ex) {
			log.error("Error setting up MDR repository "+ ex.getMessage());
			throw new RuntimeException("Error setting up MDR repository", ex);
		}
	}

	private void initXmiReader() {
		try {
			_reader = XMIReaderFactory.getDefault().createXMIReader();
		} catch (Exception ex) {
			log.error("Error instantiating XMI reader " + ex.getMessage());
			throw new RuntimeException("Error instantiating XMI reader", ex);
		}
	}

	

	/** 
	 * @see gov.nih.nci.codegen.framework.ModelAccess#readModel(java.io.InputStream)
	 */
	public void readModel(String uriStr, String modelName) throws IOException,
			ModelAccessException {

		
		
		URI uri = null;
		try{
			uri = new URI(uriStr);	
		}catch(Exception ex){
			log.error("Couldn't create URI for " + uriStr, ex);
		}

		if(uri == null){
			try{
				uri = (new File(uriStr)).toURI();
			}catch(Exception ex){
				log.error("Couldn't create URI from file for " + uriStr, ex);
			}
		}
		if(uri == null){
			log.error("Couldn't create URI from " + uriStr);
			throw new ModelAccessException("Couldn't create URI from " + uriStr);
		}
		
		RefPackage modelExtent = getModelExtent();
		
		if(modelExtent == null){
			log.error("Model extent is null");
			throw new RuntimeException("Model extent is null");
		}
		
		try {
			_reader.read(uri.toString(), modelExtent);
		} catch (Exception ex) {
			log.error("Error reading model "+ ex.getMessage());
			log.error("Error reading model 2 "+ ex.getStackTrace());
			throw new ModelAccessException("Error reading model", ex);
		}
	}

	/**
	 * @see gov.nih.nci.codegen.framework.ModelAccess#rollback()
	 */
	public void rollback() throws ModelAccessException {
		try{
			_repository.endTrans(false);
		}catch(Exception ex){
			log.error("Error rolling back transaction - "+ ex.getMessage());
			throw new ModelAccessException("Error rolling back transaction", ex);
		}		
	}
}
