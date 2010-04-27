package gov.nih.nci.caintegrator.util;

import org.hibernate.Query;

import java.util.*;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 10, 2006
 * Time:   6:30:20 PM
 */
public class HQLHelper {
    public static void setParamsOnQuery(HashMap params, Query q) {
           Set paramKeys = params.keySet();
           Iterator iter = paramKeys.iterator();
           while (iter.hasNext()) {
               String key = (String)iter.next();
               Object value =  params.get(key);

               if (value instanceof List)
                   q.setParameterList(key, (ArrayList)value);
               else if (value instanceof Set)
                   q.setParameterList(key, (HashSet) value);
               else q.setParameter(key, value);

           }
       }

    public static void setParamsOnQuery(Hashtable params, Query q) {
           Set paramKeys = params.keySet();
           Iterator iter = paramKeys.iterator();
           while (iter.hasNext()) {
               String key = (String)iter.next();
               Object value =  params.get(key);
               Class c = value.getClass();

               if (value instanceof List)
                   q.setParameterList(key, (ArrayList)value);
               else if (value instanceof Set)
                   q.setParameterList(key, (HashSet) value);
               else q.setParameter(key, value);

           }
       }

    public static String removeTrailingAND(StringBuffer hSQL) {
            String combinedHSQL = hSQL.toString().trim();
            int length = combinedHSQL.length();
            String ANDRemovedHSQL  = null;
            if (combinedHSQL.endsWith(" AND"))  {
               int endIndex = length - 4;
               ANDRemovedHSQL = combinedHSQL.substring(0, endIndex);
            }
            String finalHSQL = (ANDRemovedHSQL  == null) ? combinedHSQL : ANDRemovedHSQL;
            return finalHSQL;
        }

       public static String removeTrailingToken(StringBuffer hSQL, String token) {
           String combinedHSQL = hSQL.toString().trim();
           int length = combinedHSQL.length();
           String ANDRemovedHSQL  = null;
           if (combinedHSQL.endsWith(" " + token))  {
              int endIndex = length - (token.length() + 1)
;
              ANDRemovedHSQL = combinedHSQL.substring(0, endIndex);
           }
           String finalHSQL = (ANDRemovedHSQL  == null) ? combinedHSQL : ANDRemovedHSQL;
           return finalHSQL;
       }

       public static String removeTrailingOR(StringBuffer hSQL) {
           String combinedHSQL = hSQL.toString().trim();
           int length = combinedHSQL.length();
           String ORRemovedHSQL = null;
           if (combinedHSQL.endsWith(" OR"))  {
              int endIndex = length - 3;
              ORRemovedHSQL = combinedHSQL.substring(0, endIndex);
           }
           String finalHSQL = (ORRemovedHSQL == null) ? combinedHSQL : ORRemovedHSQL;
           return finalHSQL;
       }
/*
      public static String removeTrailingALL(StringBuffer hSQL) {
        HQLHelper.removeTrailingToken(hSQL, "AND");
        HQLHelper.removeTrailingToken(hSQL, "OR");
        HQLHelper.removeTrailingToken(hSQL, "WHERE");
      }
*/

    public static String prepareCondition(ArithematicOperator pValueOP) {
        String condition = null;
        switch(pValueOP) {
            case GT: {
              condition = " > ";
              break;
            }
            case LT: {
              condition = " < ";
              break;
            }
            case EQ: {
              condition = " = ";
              break;
            }
            case LE: {
              condition = " <= ";
              break;
            }
            case GE: {
              condition = " >= ";
              break;
            }
            default: {
                // this should never happen.
                condition = " = ";
            }
         }

         return condition;
    }

    public static Collection<String> convertToUpperCaseCollection(Collection<String> collectionToBeConverted) { 
         Collection convertCaseValues = new ArrayList<String>(collectionToBeConverted.size());
         for (Iterator<String> iterator = collectionToBeConverted.iterator(); iterator.hasNext();) {
             String s =  iterator.next();
             convertCaseValues.add(s.toUpperCase());
         }
         return convertCaseValues;
     }

     public static Collection<String> convertToLowerCaseCollection(Collection<String> collectionToBeConverted) {
         Collection convertCaseValues = new ArrayList<String>(collectionToBeConverted.size());
         for (Iterator<String> iterator = collectionToBeConverted.iterator(); iterator.hasNext();) {
             String s =  iterator.next();
             convertCaseValues.add(s.toLowerCase());
         }
         return convertCaseValues;
     }

}
