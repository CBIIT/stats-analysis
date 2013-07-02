/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.critieria;

/**
 * @author BhattarR
 */


/**
* 
* 
*/

public interface Constants {

    // TODO: probable read these values from DataBase????  Also how is presentation going to handle these?
    String AFFY_OLIGO_PLATFORM = "Affymetrix Oligo Expression Arrays";
    String AGILENT_PLATFROM = "Agilent Platform";
    String CDNA_ARRAY_PLATFORM = "cDNA arrays";
    String ALL_PLATFROM = "all";
    String ARRAY_CGH = "ArrayCGH";
    String  AFFY_100K_SNP_ARRAY = "Affymetrix 100K SNP Arrays";
    Float	KAPLAN_MEIER_DEFAULT_RATIO = new Float(3.0);
}
