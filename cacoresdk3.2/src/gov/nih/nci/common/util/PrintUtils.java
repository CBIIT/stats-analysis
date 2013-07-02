/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.common.util;



import java.util.*;
import java.lang.reflect.*;
import javax.swing.tree.DefaultMutableTreeNode;
import org.apache.log4j.*;


/**
  * PrintUtils consists of methods that prints data to a Standard Output Device.
  * @author caBIO Team
  * @version 1.0
*/


public class PrintUtils {

    private static Logger log= Logger.getLogger(PrintUtils.class.getName());
/**
 	* Prints the objects in a given list along with it's child objects
 	* @param resultList 	Specifies the objects that needs to be printed
 	* return
*/
		public void printTree(List resultList){
			int recordNum = 1;
			int valid = -1;
			List classList;
			for(Iterator rList = resultList.iterator(); rList.hasNext();){

					classList = new ArrayList();
			      	Object result 	= rList.next();
			      	System.out.println("\n("+recordNum+"). Class name = "+ result.getClass().getName() +"\n");
			      	valid = classList.size();
			      	classList = addClassToList(result, classList);
			      	if(valid!= classList.size()){
						classList = printObject(result, classList);
						classList.remove(classList.size()-1);
						}

			      	recordNum++;
			    }

			String beanName = resultList.get(0).getClass().getName();
			System.out.println("Total number of "+ beanName.substring(beanName.lastIndexOf(Constant.DOT)+1) + Constant.SPACE +resultList.size());

			}


/**
	* Sends and object to a Standard Output Device
	* @param result 	Specifies the object that needs to be printed
	* @param classList	Specifies the path from root to the current object
	* return
*/
		public List printObject(Object result, List classList){

			List methodList 		= new ArrayList();
			List methodForObject 	= new ArrayList();
			List methodForObjects	= new ArrayList();
			Class resultClass 		= result.getClass();
			String className 		= resultClass.getName();
			String attribName 		= null;
			//Field[] fields 			= resultClass.getDeclaredFields();
			//Method[] methods 		= resultClass.getDeclaredMethods();


			Field[] fields 			= getAllFields(resultClass);
			Method[] methods 		= getAllMethods(resultClass);


			int valid = classList.size();



		   for(int f=0;f<fields.length; f++){
			    fields[f].setAccessible(true);
			    String fieldClassName = fields[f].getType().getName();
			    String fieldName = fields[f].getName().substring(0,1).toUpperCase()+fields[f].getName().substring(1);
			    for(int i=0; i< methods.length; i++){
			       String methodName = methods[i].getName();
			             if(methodName.endsWith(fieldName) && methodName.startsWith("get")){

			                  if(fieldClassName.startsWith(resultClass.getPackage().getName())){
			  						methodForObject.add(methods[i]);

			 						}
			 					else if(fieldClassName.endsWith("Collection")){

			 						methodForObjects.add(methods[i]);
			 						String beanName = fieldName.substring(0, fieldName.indexOf("Collection"));
			 						String beanClassName = resultClass.getPackage().getName() + Constant.DOT+ beanName.substring(0,1).toUpperCase() + beanName.substring(1);

			 						}
			 					else{
			 						methodList.add(methods[i]);
			 						}
			                  break;
			                 }
			             }
			   }

			   String path = (String)classList.get(0);
			   String tab = "\t";
			   for(int a=1; a<classList.size(); a++){

					   path += Constant.DOT+ (String)classList.get(a);
					   tab += "\t";
				   }

				System.out.println("Path  = "+ path);

			   for(Iterator iList=methodList.iterator(); iList.hasNext();){
			   		Method meth = (Method)iList.next();
			   		attribName = meth.getName().substring(3);
			   		try{
			   			System.out.println(tab+" * "+attribName +" - "+ meth.invoke(result, new Object[] {}));
			   			 }catch(Exception ex){
			   		     log.error("ERROR: " + ex.getMessage());
			   		 }
			  	}

				for(Iterator iList=methodForObject.iterator(); iList.hasNext();){
				         Method meth = (Method)iList.next();
				         attribName = "role value - "+meth.getName().substring(3) +".id ";
				         try{
							Object obj = meth.invoke(result, new Object[]{});

							if(obj == null){
								System.out.println("Empty " + obj.getClass().getName());
							}
							else{
								classList = addClassToList(obj, classList);
								if(valid!= classList.size()){
									classList = printObject(obj, classList);
									classList.remove(classList.size()-1);
								}
							}
				            }catch(Exception ex){
				                log.error("ERROR: " + ex.getMessage());
				            }
		               }


			   for(Iterator iList=methodForObjects.iterator(); iList.hasNext();){
			   		Method meth = (Method)iList.next();
			   		attribName = " - "+meth.getName().substring(3) +".id ";
			   		try{
						java.util.Collection objList = new ArrayList();
			   			objList = (java.util.Collection)meth.invoke(result,new Object[]{});
			   			System.out.println(tab + '*' +attribName + "  " +  objList.size()+ " found");
			   			Object[] objects = objList.toArray();

			   			List newList = new ArrayList();
			   			for(int i=0; i< objects.length; i++){
							classList = addClassToList(objects[i], classList);
							if(valid!= classList.size()){
								classList = printObject(objects[i], classList);
								classList.remove(classList.size()-1);
								}
							}
			         }catch(Exception ex){
			             log.error("ERROR: " + ex.getMessage());
			         }
				}
				return classList;
		}

/**
	* Adds the current class to a list. This list is used to idetify the path from parent to this class
	* @param result 	Specifies the object
	* @param classList	Specifies the path from root to the current object
	* return
*/
	public List addClassToList(Object result, List classList){

		boolean add = true;
		String className = result.getClass().getName();
		String classBean = className.substring(className.lastIndexOf(Constant.DOT)+1);
		if(classList.size()>1){
			String pathItem = null;
				for(int x=0; x<classList.size(); x++){
				pathItem = (String)classList.get(x);
				//System.out.println("BeanName = "+ classBean +" item = "+ item);

					if(classBean.equalsIgnoreCase(pathItem)){
						add = false;
						break;
					}
				}
		}
		if(add){
			classList.add(className.substring(className.lastIndexOf(Constant.DOT)+1));
			}
		return classList;
		}


/**
 	* Prints the objects in a given list
 	* @param resultList 	Specifies the objects that needs to printed
 	* return
*/
	public void printResults(List resultList){


			int recordNum = 1;
	        for(Iterator rList = resultList.iterator(); rList.hasNext();){
	            Object result 	= rList.next();
	            Class resultClass = result.getClass();
	            String className = resultClass.getName();
	            if(className.startsWith("java.lang") || className.equalsIgnoreCase("java.util.Date")){
	            	for(int i=0;i <resultList.size(); i++){
	            		System.out.println(resultList.get(i));
	            		}
	            	System.exit(0);
	            	}
	            else {

	            String attribName = null;
	            //Field[] fields = resultClass.getDeclaredFields();
	            //Method[] methods = resultClass.getDeclaredMethods();
	            Field[] fields 			= getAllFields(resultClass);
				Method[] methods 		= getAllMethods(resultClass);
	            List methodList = new ArrayList();
	            List methodForObject = new ArrayList();
	            List methodForObjects= new ArrayList();


	         System.out.println("\n("+recordNum+"). Class name = "+ className +"\n");


	            for(int f=0;f<fields.length; f++){
	                fields[f].setAccessible(true);
	                String fieldClassName = fields[f].getType().getName();
	                String fieldName = fields[f].getName().substring(0,1).toUpperCase()+fields[f].getName().substring(1);

	                for(int i=0; i< methods.length; i++){
	                    String methodName = methods[i].getName();
	                    if(methodName.endsWith(fieldName) && methodName.startsWith("get")){

	                    if(fieldClassName.startsWith(resultClass.getPackage().getName())){
							methodForObject.add(methods[i]);
							}
						else if(fieldClassName.endsWith("Collection")){
							methodForObjects.add(methods[i]);
							}
						else{
							methodList.add(methods[i]);
							}
	                    break;
	                    }
	                }

	            }

	         int count=1;
				  	for(Iterator iList=methodList.iterator(); iList.hasNext();){
				  	   Method meth = (Method)iList.next();
				  	   attribName = meth.getName().substring(3);
				       try{
				           System.out.println("--> "+attribName +" - "+ meth.invoke(result, new Object[]{}));
				  	       count++;
				  		}catch(Exception ex){
				  		  log.error("ERROR: " + ex.getMessage());
				  		}

				  	}
/*
			for(Iterator iList=methodForObject.iterator(); iList.hasNext();){
	                Method meth = (Method)iList.next();
	                attribName = "role value - "+meth.getName().substring(3) +".id ";
	                try{
							Object obj = meth.invoke(result, null);
							if(obj == null){
								}
							else{
							Method objMeth = obj.getClass().getMethod("getId",null);
								if(objMeth == null){
									System.out.println("no such method found for " + obj);
									}
								else{
	                        		count++;
								}
							}

	                    }catch(Exception ex){}
	                }


			for(Iterator iList=methodForObjects.iterator(); iList.hasNext();){
	    	     Method meth = (Method)iList.next();
	    	     attribName = "role value - "+meth.getName().substring(3) +".id ";

	    	    try{
					java.util.Collection objList = new ArrayList();
					objList = (java.util.Collection)meth.invoke(result,null);
					System.out.println("Collection Object " +attribName +"  "+  objList.size()+ " found");
					Object[] objects = objList.toArray();

	    	    }catch(Exception ex){}
			}
	*/
			recordNum++;
	            }
	        }
	            System.out.println("\n\n"+resultList.size()+ " \trecords found");

}

	/**
	 * Gets all the fields of a given class
	 * @param resultClass - Specifies the class name
	 * @return - returns all the fields of a class
	 */
	public Field[] getAllFields(Class resultClass){
		List fieldList = new ArrayList();
		try{

		while(resultClass != null && !resultClass.isInterface() && !resultClass.isPrimitive()){
			Field[] fields = resultClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
						fields[i].setAccessible(true);
						String fieldName = fields[i].getName();
						fieldList.add(fields[i]);
				}


			if(!resultClass.getSuperclass().getName().equalsIgnoreCase("java.lang.Object")){
				resultClass = resultClass.getSuperclass();
				}
			else{
				break;
				}

			}
		}catch(Exception ex){
		    log.error("ERROR: " + ex.getMessage());
			}

		Field[] fields = new Field[fieldList.size()];
		for(int i=0;i<fieldList.size(); i++){
			fields[i]= (Field)fieldList.get(i);
			}
			return fields;
		}

	/**
	 * Gets all the methods of a given class
	 * @param resultClass - Specifies the class name
	 * @return - Returns all the methods
	 */


	public Method[] getAllMethods(Class resultClass){

		List methodList = new ArrayList();
		try{
		while(resultClass != null && !resultClass.isInterface() && !resultClass.isPrimitive()){
			Method[] method = resultClass.getDeclaredMethods();
			for (int i = 0; i < method.length; i++) {
						method[i].setAccessible(true);
						String methodName = method[i].getName();
						methodList.add(method[i]);
				}


			if(!resultClass.getSuperclass().getName().equalsIgnoreCase("java.lang.Object")){
				resultClass = resultClass.getSuperclass();
				}
			else{
				break;
				}
			}
			}catch(Exception ex){
			    log.error("ERROR: " + ex.getMessage());
			}

			Method[] methods = new Method[methodList.size()];
					for(int i=0;i<methodList.size(); i++){
						methods[i]= (Method)methodList.get(i);
					}
		return methods;
		}

                            
}
