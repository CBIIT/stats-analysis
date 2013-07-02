/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

import gov.nih.nci.system.applicationservice.*;
import java.util.*;


import gov.nih.nci.cabio.domain.*;
import gov.nih.nci.cabio.domain.impl.*;
import gov.nih.nci.common.util.*;

import org.hibernate.criterion.*;
import javax.xml.parsers.*;

import javax.xml.validation.*;
import javax.xml.transform.*;
import java.io.*;

import javax.xml.transform.dom.*;
import org.xml.sax.*;

import javax.xml.validation.*;
import javax.xml.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.*;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;

import java.io.*;

 

/**
 * @author caBIO Team
 * @version 1.0
 */



/**
	* TestClient.java demonstartes various ways to execute searches with and without
      * using Application Service Layer (convenience layer that abstracts building criteria
      * Uncomment different scenarios below to demonstrate the various types of searches
*/

public class TestXML {


    public static void main(String[] args) {

       System.out.println("*** XML TestClient...");
	 try{
ApplicationService appService = ApplicationServiceProvider.getRemoteInstance(
//"http://cbiodev104.nci.nih.gov:29080/cacore30/server/HTTPServer"
//"http://cbioqa101.nci.nih.gov:29080/cacore30/server/HTTPServer"
//"http://cbioapp101.nci.nih.gov:29080/cacore30/server/HTTPServer"
//http://cabio-stage.nci.nih.gov/cacore30/server/HTTPServer"
);

try {
	System.out.println("Scenario 1: Retrieving a Gene based on a Gene id.");
	Gene gene = new Gene();
	gene.setId(new Long("2"));

	try {
		XMLUtility myUtil = new XMLUtility();
		List resultList = appService.search(Gene.class, gene);
		System.out.println("Result list size: " + resultList.size() + "\n");
		long startTime = System.currentTimeMillis();
		for (Iterator resultsIterator = resultList.iterator(); resultsIterator.hasNext();) {
			Gene returnedGene = (Gene)resultsIterator.next();
			System.out.println("Gene object right after search: \n\n");
			System.out.println("   Id: "+ returnedGene.getId() + "\n");
			System.out.println("   Title: "+ returnedGene.getTitle() + "\n");
			System.out.println("   Symbol: "+ returnedGene.getSymbol() + "\n");
			System.out.println("   LocusLinkId: "+ returnedGene.getLocusLinkId() + "\n\n\n");
			File myFile = new File("@CLIENT_DIR@/test.xml");
			FileWriter myWriter = new FileWriter(myFile);
			myUtil.toXML(returnedGene,myWriter);
			DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	        Document document = parser.parse(myFile);
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Source schemaFile = new StreamSource(new File("@SCHEMA_DIR@/gov.nih.nci.cabio.domain.xsd"));
			Schema schema = factory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			System.out.println("Validating gene against the schema......\n\n");
			validator.validate(new DOMSource(document));
			System.out.println("Gene has been validated!!!\n\n");
			Gene myGene = (Gene) myUtil.fromXML(myFile);
			System.out.println("Retrieving gene from xml ....\n\n");
			System.out.println("   Id: "+ myGene.getId() + "\n");
			System.out.println("   Title: "+ myGene.getTitle() + "\n");
			System.out.println("   Symbol: "+ myGene.getSymbol() + "\n");
			System.out.println("   LocusLinkId: "+ myGene.getLocusLinkId() + "\n\n\n");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("latency in miliseconds = "+ (endTime - startTime));

	} catch (ParserConfigurationException ea) {
		ea.printStackTrace();
	} catch (SAXException eb) {
		eb.printStackTrace();
	} catch (IOException ec) {
		ec.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
} catch (RuntimeException e2) {
	e2.printStackTrace();
}


}
catch(Exception ex){
ex.printStackTrace();
}
}
}