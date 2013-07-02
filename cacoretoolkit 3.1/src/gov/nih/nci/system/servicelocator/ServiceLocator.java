/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.servicelocator;


import gov.nih.nci.common.util.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
import org.jdom.xpath.XPath.*;
import org.jdom.*;
import org.xml.sax.SAXException;
import org.apache.log4j.*;



/**
 * ServiceLocator provides methods to retrieve information from an XML configuration file
 * @author caBIO Team
 * @version 1.0
 */

public class ServiceLocator {
	
	private static Logger log = Logger.getLogger(ServiceLocator.class.getName());
	public Document document;
	public Parser parser;
	public Vector domainObjects;
	public Hashtable dataSource;
	List list;
/**
 * Creates a ServiceLocator instance
 */
	public ServiceLocator()
	{
 
		parser = new Parser("../conf/DAOConfig.xml");
		list = parser.getList("/DAOConfiguration/domainObjects/@name");
		domainObjects = parser.listAttributes(list);
	}

/**
	 * Returns the configuration document
	 * return	Returns a document
 */
public Document getDocument()
	{
		return document;
	}

/**
 * Returns the datasource value
 * @param dataSource  Specified dataSource information
 * @param key		  Specified key of the hashtable
 */
public String getDataSourceCollectionValue(Hashtable dataSource, String key)
{
	return dataSource.get(key).toString();
}

/**
 * Gets the datasource configuration values
 * @param objectName
 * @return
 * @throws ServiceLocatorException
 */
public Hashtable getDataSourceCollection(String objectName)throws ServiceLocatorException
{
	Hashtable dataSource = new Hashtable();
	try{
	for(int i =0; i < domainObjects.size();i++){
		String dObject = (domainObjects.get(i).toString());

			if (dObject.indexOf(objectName)>= 0){

				String xPathExp = "/DAOConfiguration/domainObjects[@name='" + dObject +"']";
				dataSource= parser.listElements(parser.getList(xPathExp));
			}
		}
	}
	catch(Exception ex){
		log.error(ex.getMessage());
		throw new ServiceLocatorException(ex.getMessage());
	}
	return dataSource;
}

/**
 * Updates the data source configuration values sent by the user
 * @param domainObj
 * @param updateTable
 */
public void updateDataSourceCollection(String domainObj, String[][] updateTable)
{
	int indexOfDomainObject = 0;
		for (int i=0; i<domainObjects.size(); i++){
		String dObject = (domainObjects.get(i).toString());
			if(dObject == domainObj){
				indexOfDomainObject = i;
			}
		}
	parser.updateElements( indexOfDomainObject,updateTable );
 }

	public int getORMCount()
	{
		Iterator allDataSource = parser.getElements("DataSource");
		int count = 0;

		while(allDataSource.hasNext())
		{
			Element temp = (Element)allDataSource.next();
			if(temp.getText().indexOf("ORM") != -1)
			{
				count++;
			}
		}
		return count;

	}

	public int getORMCounter(String domainObjectName) throws Exception
	{
		int counter = 0;
		String dsName;
		try
		{
			dsName =getDataSourceCollectionValue(getDataSourceCollection(domainObjectName), "DataSource");
			String index = dsName.substring(3);
			return Integer.parseInt(index);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
}

