package gov.nih.nci.caintegrator.domain.finding.clinical.brainCancer;

import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;

public class GBMClinicalFinding extends ClinicalFinding{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1389764732570216913L;
    private NumericMeasurement WEIGHT;
    private ClinicalAssessment TNMCLINICALLYMPHNODESTATUS;
    private ClinicalAssessment MIB1_POSITIVE;
    private ClinicalAssessment FREEZINGMETHOD;
    private ClinicalAssessment HISTOLOGICTYPE;
    private ClinicalAssessment VERIFICATIONBYBCR;
    private ClinicalAssessment DRUGNAME;
    private ClinicalAssessment ENDOTHELIALPROLIFERATION;
    private ClinicalAssessment TNMRECURRENCESTAGEGROUPING;
    private ClinicalAssessment GEMISTOCYTESPRESENT;
    private ClinicalAssessment VITALSTATUS;
    private ClinicalAssessment BCRPORTIONBARCODE;
    private ClinicalAssessment CELLULARITY;
    private ClinicalAssessment PERCENTMONOCYTEINFILTRATION;
    private ClinicalAssessment TUMORSAMPLEANATOMICLOCATION;
    private ClinicalAssessment NUMBERREGIONALLYMPHNODESEXAM;
    private ClinicalAssessment DATEOFDEATH;
    private ClinicalAssessment PRIMARYORMETASTATICSTATUS;
    private NumericMeasurement PERCENTNECROSIS;
    private NumericMeasurement RINVALUE;
    private ClinicalAssessment NUCLEARPLEOMORPHISM;
    private ClinicalAssessment VENOUSINVASION;
    private ClinicalAssessment TNMPATHOLOGYLYMPHNODESTATUS;
    private ClinicalAssessment OCTEMBEDDED;
    private ClinicalAssessment SHIPPINGDATE;
    private NumericMeasurement SHORTESTDIMENSION;
    private ClinicalAssessment TNMRECURRENCETUMORSTATUS;
    private NumericMeasurement RATIO28S18S;
    private ClinicalAssessment OLIGODENDROGLIALCOMPONENT;
    private ClinicalAssessment DATEOFBIRTH;
    private NumericMeasurement NUMBERREGIONALLYMPHNODESPOS;
    private NumericMeasurement REVISION;
    private NumericMeasurement TIMEBETWEENCLAMPINGANDFREEZING;
    private ClinicalAssessment ANALYTETYPE;
    private ClinicalAssessment SECTIONLOCATION;
    private ClinicalAssessment CANCERSTATUS;
    private ClinicalAssessment TNMPATHOLOGYSTAGEGROUPING;
    private ClinicalAssessment BCRSLIDEBARCODE;
    private NumericMeasurement NUMFRACTIONS;
    private NumericMeasurement NUMBERCYCLES;
    private ClinicalAssessment TNMRECURRENCEMETASTATICSTATUS;
    private ClinicalAssessment STARTDATE;
    private ClinicalAssessment HISTOLOGICALTYPE;
    private ClinicalAssessment TNMCLINICALTUMORSTATUS;
    private NumericMeasurement ALCOHOLCONSUMPTION;
    private ClinicalAssessment HISTOLOGICNUCLEARGRADE;
    private NumericMeasurement INITIALWEIGHT;
    private ClinicalAssessment ENDDATE;
    private ClinicalAssessment DATEOFRADIATION;
    private ClinicalAssessment ENVIRONMENTALEXPOSURE;
    private ClinicalAssessment PERCENTGRANULOCYTEINFILTRATION;
    private ClinicalAssessment TNMRECURRENCELYMPHNODESTATUS;
    private ClinicalAssessment PROTOCOLNAME;
    private ClinicalAssessment INITIALCOURSE;
    private ClinicalAssessment MARGINSINVOLVED;
    private NumericMeasurement PERCENTSTROMALCELLS;
    private ClinicalAssessment PROTOCOLTEXT;
    private NumericMeasurement TIMEBETWEENEXCISIONANDFREEZING;
    private ClinicalAssessment PROTOCOLFILENAME;
    private NumericMeasurement NUMBERPROLIFERATINGCELLS;
    private ClinicalAssessment SAMPLETYPE;
    private ClinicalAssessment DATEOFPROCEDURE;
    private ClinicalAssessment RADIATIONDOSAGE;
    private ClinicalAssessment PERCENTTUMORNUCLEI;
    private ClinicalAssessment BCRALIQUOTBARCODE;
    private ClinicalAssessment HISTOLOGICALNUCLEARGRADE;
    private ClinicalAssessment PRIMARYPROCEDURE;
    private NumericMeasurement PERCENTINFLAMINFILTRATION;
    private ClinicalAssessment TNMPATHOLOGYMETASTATICSTATUS;
    private ClinicalAssessment ANATOMICTREATMENTSITE;
    private ClinicalAssessment PERCENTTUMORCELLS;
    private NumericMeasurement CONCENTRATION;
    private ClinicalAssessment PROGRESSIONDETERMINEDBY;
    private ClinicalAssessment LYMPHNODEPROCEDURE;
    private ClinicalAssessment DOSAGEUNITS;
    private ClinicalAssessment PALISADINGNECROSIS;
    private ClinicalAssessment DRUGDOSAGE;
    private ClinicalAssessment TNMCLINICALMETASTATICSTATUS;
    private ClinicalAssessment TUMORTISSUESITE;
    private ClinicalAssessment METASTATICPROCEDURE;
    private NumericMeasurement PERCENTNEUTROPHILINFILTRATION;
    private ClinicalAssessment PROGRESSIONSTATUS;
    private ClinicalAssessment NORMALTUMORGENOTYPEMATCH;
    private ClinicalAssessment TNMCLINICALSTAGEGROUPING;
    private ClinicalAssessment PCRAMPLIFICATIONSUCCESSFUL;
    private NumericMeasurement INTERMEDIATEDIMENSION;
    private ClinicalAssessment DATEOFCOLLECTION;
    private ClinicalAssessment DRUGCATEGORY;
    private ClinicalAssessment SMOKINGHISTORY;
    private ClinicalAssessment TNMPATHOLOGYTUMORSTATUS;
    private ClinicalAssessment LEPTOMENINGEALINVOLEMENT;
    private ClinicalAssessment DATECREATED;
    private ClinicalAssessment GFAP_POSITIVE;
    private ClinicalAssessment BCRSAMPLEBARCODE;
    private ClinicalAssessment RACE;
    private NumericMeasurement CURRENTWEIGHT;
    private NumericMeasurement AMOUNT;
    private ClinicalAssessment GENDER;
    private ClinicalAssessment INFORMEDCONSENTACQUIRED;
    private ClinicalAssessment PERCENTEOSINOPHILINFILTRATION;
    private ClinicalAssessment WELLNUMBER;
    private ClinicalAssessment BCRSITEID;
    private ClinicalAssessment RADIATIONTYPE;
    private ClinicalAssessment GELIMAGEFILE;
    private NumericMeasurement KARNOFSKYPERFORMANCESCORE;
    private ClinicalAssessment BCRPATIENTBARCODE;
    private ClinicalAssessment LYMPHATICINVASION;
    private ClinicalAssessment EXAMINATIONDATE;
    private NumericMeasurement A260A280RATIO;
    private ClinicalAssessment BCRANALYTEBARCODE;
    private NumericMeasurement LONGESTDIMENSION;
    private ClinicalAssessment EXPERIMENTALPROTOCOLTYPE;
    private ClinicalAssessment PERCENTNORMALCELLS;
    private NumericMeasurement PERCENTLYMPHOCYTEINFILTRATION;
    private ClinicalAssessment DATEOFLASTFOLLOWUP;
    private String PTID;
    
    
    /**
     * @return the pTID
     */
    public String getPTID() {
        return PTID;
    }
    /**
     * @param ptid the pTID to set
     */
    public void setPTID(String ptid) {
        PTID = ptid;
    }
    /**
     * @return the wEIGHT
     */
    public NumericMeasurement getWEIGHT() {
        return WEIGHT;
    }
    /**
     * @param weight the wEIGHT to set
     */
    public void setWEIGHT(NumericMeasurement weight) {
        WEIGHT = weight;
    }
    /**
     * @return the tNMCLINICALLYMPHNODESTATUS
     */
    public ClinicalAssessment getTNMCLINICALLYMPHNODESTATUS() {
        return TNMCLINICALLYMPHNODESTATUS;
    }
    /**
     * @param tnmclinicallymphnodestatus the tNMCLINICALLYMPHNODESTATUS to set
     */
    public void setTNMCLINICALLYMPHNODESTATUS(
            ClinicalAssessment tnmclinicallymphnodestatus) {
        TNMCLINICALLYMPHNODESTATUS = tnmclinicallymphnodestatus;
    }
    /**
     * @return the mIB1_POSITIVE
     */
    public ClinicalAssessment getMIB1_POSITIVE() {
        return MIB1_POSITIVE;
    }
    /**
     * @param mib1_positive the mIB1_POSITIVE to set
     */
    public void setMIB1_POSITIVE(ClinicalAssessment mib1_positive) {
        MIB1_POSITIVE = mib1_positive;
    }
    /**
     * @return the fREEZINGMETHOD
     */
    public ClinicalAssessment getFREEZINGMETHOD() {
        return FREEZINGMETHOD;
    }
    /**
     * @param freezingmethod the fREEZINGMETHOD to set
     */
    public void setFREEZINGMETHOD(ClinicalAssessment freezingmethod) {
        FREEZINGMETHOD = freezingmethod;
    }
    /**
     * @return the hISTOLOGICTYPE
     */
    public ClinicalAssessment getHISTOLOGICTYPE() {
        return HISTOLOGICTYPE;
    }
    /**
     * @param histologictype the hISTOLOGICTYPE to set
     */
    public void setHISTOLOGICTYPE(ClinicalAssessment histologictype) {
        HISTOLOGICTYPE = histologictype;
    }
    /**
     * @return the vERIFICATIONBYBCR
     */
    public ClinicalAssessment getVERIFICATIONBYBCR() {
        return VERIFICATIONBYBCR;
    }
    /**
     * @param verificationbybcr the vERIFICATIONBYBCR to set
     */
    public void setVERIFICATIONBYBCR(ClinicalAssessment verificationbybcr) {
        VERIFICATIONBYBCR = verificationbybcr;
    }
    /**
     * @return the dRUGNAME
     */
    public ClinicalAssessment getDRUGNAME() {
        return DRUGNAME;
    }
    /**
     * @param drugname the dRUGNAME to set
     */
    public void setDRUGNAME(ClinicalAssessment drugname) {
        DRUGNAME = drugname;
    }
    /**
     * @return the eNDOTHELIALPROLIFERATION
     */
    public ClinicalAssessment getENDOTHELIALPROLIFERATION() {
        return ENDOTHELIALPROLIFERATION;
    }
    /**
     * @param endothelialproliferation the eNDOTHELIALPROLIFERATION to set
     */
    public void setENDOTHELIALPROLIFERATION(
            ClinicalAssessment endothelialproliferation) {
        ENDOTHELIALPROLIFERATION = endothelialproliferation;
    }
    /**
     * @return the tNMRECURRENCESTAGEGROUPING
     */
    public ClinicalAssessment getTNMRECURRENCESTAGEGROUPING() {
        return TNMRECURRENCESTAGEGROUPING;
    }
    /**
     * @param tnmrecurrencestagegrouping the tNMRECURRENCESTAGEGROUPING to set
     */
    public void setTNMRECURRENCESTAGEGROUPING(
            ClinicalAssessment tnmrecurrencestagegrouping) {
        TNMRECURRENCESTAGEGROUPING = tnmrecurrencestagegrouping;
    }
    /**
     * @return the gEMISTOCYTESPRESENT
     */
    public ClinicalAssessment getGEMISTOCYTESPRESENT() {
        return GEMISTOCYTESPRESENT;
    }
    /**
     * @param gemistocytespresent the gEMISTOCYTESPRESENT to set
     */
    public void setGEMISTOCYTESPRESENT(ClinicalAssessment gemistocytespresent) {
        GEMISTOCYTESPRESENT = gemistocytespresent;
    }
    /**
     * @return the vITALSTATUS
     */
    public ClinicalAssessment getVITALSTATUS() {
        return VITALSTATUS;
    }
    /**
     * @param vitalstatus the vITALSTATUS to set
     */
    public void setVITALSTATUS(ClinicalAssessment vitalstatus) {
        VITALSTATUS = vitalstatus;
    }
    /**
     * @return the bCRPORTIONBARCODE
     */
    public ClinicalAssessment getBCRPORTIONBARCODE() {
        return BCRPORTIONBARCODE;
    }
    /**
     * @param bcrportionbarcode the bCRPORTIONBARCODE to set
     */
    public void setBCRPORTIONBARCODE(ClinicalAssessment bcrportionbarcode) {
        BCRPORTIONBARCODE = bcrportionbarcode;
    }
    /**
     * @return the cELLULARITY
     */
    public ClinicalAssessment getCELLULARITY() {
        return CELLULARITY;
    }
    /**
     * @param cellularity the cELLULARITY to set
     */
    public void setCELLULARITY(ClinicalAssessment cellularity) {
        CELLULARITY = cellularity;
    }
    /**
     * @return the pERCENTMONOCYTEINFILTRATION
     */
    public ClinicalAssessment getPERCENTMONOCYTEINFILTRATION() {
        return PERCENTMONOCYTEINFILTRATION;
    }
    /**
     * @param percentmonocyteinfiltration the pERCENTMONOCYTEINFILTRATION to set
     */
    public void setPERCENTMONOCYTEINFILTRATION(
            ClinicalAssessment percentmonocyteinfiltration) {
        PERCENTMONOCYTEINFILTRATION = percentmonocyteinfiltration;
    }
    /**
     * @return the tUMORSAMPLEANATOMICLOCATION
     */
    public ClinicalAssessment getTUMORSAMPLEANATOMICLOCATION() {
        return TUMORSAMPLEANATOMICLOCATION;
    }
    /**
     * @param tumorsampleanatomiclocation the tUMORSAMPLEANATOMICLOCATION to set
     */
    public void setTUMORSAMPLEANATOMICLOCATION(
            ClinicalAssessment tumorsampleanatomiclocation) {
        TUMORSAMPLEANATOMICLOCATION = tumorsampleanatomiclocation;
    }
    /**
     * @return the nUMBERREGIONALLYMPHNODESEXAM
     */
    public ClinicalAssessment getNUMBERREGIONALLYMPHNODESEXAM() {
        return NUMBERREGIONALLYMPHNODESEXAM;
    }
    /**
     * @param numberregionallymphnodesexam the nUMBERREGIONALLYMPHNODESEXAM to set
     */
    public void setNUMBERREGIONALLYMPHNODESEXAM(
            ClinicalAssessment numberregionallymphnodesexam) {
        NUMBERREGIONALLYMPHNODESEXAM = numberregionallymphnodesexam;
    }
    /**
     * @return the dATEOFDEATH
     */
    public ClinicalAssessment getDATEOFDEATH() {
        return DATEOFDEATH;
    }
    /**
     * @param dateofdeath the dATEOFDEATH to set
     */
    public void setDATEOFDEATH(ClinicalAssessment dateofdeath) {
        DATEOFDEATH = dateofdeath;
    }
    /**
     * @return the pRIMARYORMETASTATICSTATUS
     */
    public ClinicalAssessment getPRIMARYORMETASTATICSTATUS() {
        return PRIMARYORMETASTATICSTATUS;
    }
    /**
     * @param primaryormetastaticstatus the pRIMARYORMETASTATICSTATUS to set
     */
    public void setPRIMARYORMETASTATICSTATUS(
            ClinicalAssessment primaryormetastaticstatus) {
        PRIMARYORMETASTATICSTATUS = primaryormetastaticstatus;
    }
    /**
     * @return the pERCENTNECROSIS
     */
    public NumericMeasurement getPERCENTNECROSIS() {
        return PERCENTNECROSIS;
    }
    /**
     * @param percentnecrosis the pERCENTNECROSIS to set
     */
    public void setPERCENTNECROSIS(NumericMeasurement percentnecrosis) {
        PERCENTNECROSIS = percentnecrosis;
    }
    /**
     * @return the rINVALUE
     */
    public NumericMeasurement getRINVALUE() {
        return RINVALUE;
    }
    /**
     * @param rinvalue the rINVALUE to set
     */
    public void setRINVALUE(NumericMeasurement rinvalue) {
        RINVALUE = rinvalue;
    }
    /**
     * @return the nUCLEARPLEOMORPHISM
     */
    public ClinicalAssessment getNUCLEARPLEOMORPHISM() {
        return NUCLEARPLEOMORPHISM;
    }
    /**
     * @param nuclearpleomorphism the nUCLEARPLEOMORPHISM to set
     */
    public void setNUCLEARPLEOMORPHISM(ClinicalAssessment nuclearpleomorphism) {
        NUCLEARPLEOMORPHISM = nuclearpleomorphism;
    }
    /**
     * @return the vENOUSINVASION
     */
    public ClinicalAssessment getVENOUSINVASION() {
        return VENOUSINVASION;
    }
    /**
     * @param venousinvasion the vENOUSINVASION to set
     */
    public void setVENOUSINVASION(ClinicalAssessment venousinvasion) {
        VENOUSINVASION = venousinvasion;
    }
    /**
     * @return the tNMPATHOLOGYLYMPHNODESTATUS
     */
    public ClinicalAssessment getTNMPATHOLOGYLYMPHNODESTATUS() {
        return TNMPATHOLOGYLYMPHNODESTATUS;
    }
    /**
     * @param tnmpathologylymphnodestatus the tNMPATHOLOGYLYMPHNODESTATUS to set
     */
    public void setTNMPATHOLOGYLYMPHNODESTATUS(
            ClinicalAssessment tnmpathologylymphnodestatus) {
        TNMPATHOLOGYLYMPHNODESTATUS = tnmpathologylymphnodestatus;
    }
    /**
     * @return the oCTEMBEDDED
     */
    public ClinicalAssessment getOCTEMBEDDED() {
        return OCTEMBEDDED;
    }
    /**
     * @param octembedded the oCTEMBEDDED to set
     */
    public void setOCTEMBEDDED(ClinicalAssessment octembedded) {
        OCTEMBEDDED = octembedded;
    }
    /**
     * @return the sHIPPINGDATE
     */
    public ClinicalAssessment getSHIPPINGDATE() {
        return SHIPPINGDATE;
    }
    /**
     * @param shippingdate the sHIPPINGDATE to set
     */
    public void setSHIPPINGDATE(ClinicalAssessment shippingdate) {
        SHIPPINGDATE = shippingdate;
    }
    /**
     * @return the sHORTESTDIMENSION
     */
    public NumericMeasurement getSHORTESTDIMENSION() {
        return SHORTESTDIMENSION;
    }
    /**
     * @param shortestdimension the sHORTESTDIMENSION to set
     */
    public void setSHORTESTDIMENSION(NumericMeasurement shortestdimension) {
        SHORTESTDIMENSION = shortestdimension;
    }
    /**
     * @return the tNMRECURRENCETUMORSTATUS
     */
    public ClinicalAssessment getTNMRECURRENCETUMORSTATUS() {
        return TNMRECURRENCETUMORSTATUS;
    }
    /**
     * @param tnmrecurrencetumorstatus the tNMRECURRENCETUMORSTATUS to set
     */
    public void setTNMRECURRENCETUMORSTATUS(
            ClinicalAssessment tnmrecurrencetumorstatus) {
        TNMRECURRENCETUMORSTATUS = tnmrecurrencetumorstatus;
    }
    /**
     * @return the rATIO28S18S
     */
    public NumericMeasurement getRATIO28S18S() {
        return RATIO28S18S;
    }
    /**
     * @param ratio28s18s the rATIO28S18S to set
     */
    public void setRATIO28S18S(NumericMeasurement ratio28s18s) {
        RATIO28S18S = ratio28s18s;
    }
    /**
     * @return the oLIGODENDROGLIALCOMPONENT
     */
    public ClinicalAssessment getOLIGODENDROGLIALCOMPONENT() {
        return OLIGODENDROGLIALCOMPONENT;
    }
    /**
     * @param oligodendroglialcomponent the oLIGODENDROGLIALCOMPONENT to set
     */
    public void setOLIGODENDROGLIALCOMPONENT(
            ClinicalAssessment oligodendroglialcomponent) {
        OLIGODENDROGLIALCOMPONENT = oligodendroglialcomponent;
    }
    /**
     * @return the dATEOFBIRTH
     */
    public ClinicalAssessment getDATEOFBIRTH() {
        return DATEOFBIRTH;
    }
    /**
     * @param dateofbirth the dATEOFBIRTH to set
     */
    public void setDATEOFBIRTH(ClinicalAssessment dateofbirth) {
        DATEOFBIRTH = dateofbirth;
    }
    /**
     * @return the nUMBERREGIONALLYMPHNODESPOS
     */
    public NumericMeasurement getNUMBERREGIONALLYMPHNODESPOS() {
        return NUMBERREGIONALLYMPHNODESPOS;
    }
    /**
     * @param numberregionallymphnodespos the nUMBERREGIONALLYMPHNODESPOS to set
     */
    public void setNUMBERREGIONALLYMPHNODESPOS(
            NumericMeasurement numberregionallymphnodespos) {
        NUMBERREGIONALLYMPHNODESPOS = numberregionallymphnodespos;
    }
    /**
     * @return the rEVISION
     */
    public NumericMeasurement getREVISION() {
        return REVISION;
    }
    /**
     * @param revision the rEVISION to set
     */
    public void setREVISION(NumericMeasurement revision) {
        REVISION = revision;
    }
    /**
     * @return the tIMEBETWEENCLAMPINGANDFREEZING
     */
    public NumericMeasurement getTIMEBETWEENCLAMPINGANDFREEZING() {
        return TIMEBETWEENCLAMPINGANDFREEZING;
    }
    /**
     * @param timebetweenclampingandfreezing the tIMEBETWEENCLAMPINGANDFREEZING to set
     */
    public void setTIMEBETWEENCLAMPINGANDFREEZING(
            NumericMeasurement timebetweenclampingandfreezing) {
        TIMEBETWEENCLAMPINGANDFREEZING = timebetweenclampingandfreezing;
    }
    /**
     * @return the aNALYTETYPE
     */
    public ClinicalAssessment getANALYTETYPE() {
        return ANALYTETYPE;
    }
    /**
     * @param analytetype the aNALYTETYPE to set
     */
    public void setANALYTETYPE(ClinicalAssessment analytetype) {
        ANALYTETYPE = analytetype;
    }
    /**
     * @return the sECTIONLOCATION
     */
    public ClinicalAssessment getSECTIONLOCATION() {
        return SECTIONLOCATION;
    }
    /**
     * @param sectionlocation the sECTIONLOCATION to set
     */
    public void setSECTIONLOCATION(ClinicalAssessment sectionlocation) {
        SECTIONLOCATION = sectionlocation;
    }
    /**
     * @return the cANCERSTATUS
     */
    public ClinicalAssessment getCANCERSTATUS() {
        return CANCERSTATUS;
    }
    /**
     * @param cancerstatus the cANCERSTATUS to set
     */
    public void setCANCERSTATUS(ClinicalAssessment cancerstatus) {
        CANCERSTATUS = cancerstatus;
    }
    /**
     * @return the tNMPATHOLOGYSTAGEGROUPING
     */
    public ClinicalAssessment getTNMPATHOLOGYSTAGEGROUPING() {
        return TNMPATHOLOGYSTAGEGROUPING;
    }
    /**
     * @param tnmpathologystagegrouping the tNMPATHOLOGYSTAGEGROUPING to set
     */
    public void setTNMPATHOLOGYSTAGEGROUPING(
            ClinicalAssessment tnmpathologystagegrouping) {
        TNMPATHOLOGYSTAGEGROUPING = tnmpathologystagegrouping;
    }
    /**
     * @return the bCRSLIDEBARCODE
     */
    public ClinicalAssessment getBCRSLIDEBARCODE() {
        return BCRSLIDEBARCODE;
    }
    /**
     * @param bcrslidebarcode the bCRSLIDEBARCODE to set
     */
    public void setBCRSLIDEBARCODE(ClinicalAssessment bcrslidebarcode) {
        BCRSLIDEBARCODE = bcrslidebarcode;
    }
    /**
     * @return the nUMFRACTIONS
     */
    public NumericMeasurement getNUMFRACTIONS() {
        return NUMFRACTIONS;
    }
    /**
     * @param numfractions the nUMFRACTIONS to set
     */
    public void setNUMFRACTIONS(NumericMeasurement numfractions) {
        NUMFRACTIONS = numfractions;
    }
    /**
     * @return the nUMBERCYCLES
     */
    public NumericMeasurement getNUMBERCYCLES() {
        return NUMBERCYCLES;
    }
    /**
     * @param numbercycles the nUMBERCYCLES to set
     */
    public void setNUMBERCYCLES(NumericMeasurement numbercycles) {
        NUMBERCYCLES = numbercycles;
    }
    /**
     * @return the tNMRECURRENCEMETASTATICSTATUS
     */
    public ClinicalAssessment getTNMRECURRENCEMETASTATICSTATUS() {
        return TNMRECURRENCEMETASTATICSTATUS;
    }
    /**
     * @param tnmrecurrencemetastaticstatus the tNMRECURRENCEMETASTATICSTATUS to set
     */
    public void setTNMRECURRENCEMETASTATICSTATUS(
            ClinicalAssessment tnmrecurrencemetastaticstatus) {
        TNMRECURRENCEMETASTATICSTATUS = tnmrecurrencemetastaticstatus;
    }
    /**
     * @return the sTARTDATE
     */
    public ClinicalAssessment getSTARTDATE() {
        return STARTDATE;
    }
    /**
     * @param startdate the sTARTDATE to set
     */
    public void setSTARTDATE(ClinicalAssessment startdate) {
        STARTDATE = startdate;
    }
    /**
     * @return the hISTOLOGICALTYPE
     */
    public ClinicalAssessment getHISTOLOGICALTYPE() {
        return HISTOLOGICALTYPE;
    }
    /**
     * @param histologicaltype the hISTOLOGICALTYPE to set
     */
    public void setHISTOLOGICALTYPE(ClinicalAssessment histologicaltype) {
        HISTOLOGICALTYPE = histologicaltype;
    }
    /**
     * @return the tNMCLINICALTUMORSTATUS
     */
    public ClinicalAssessment getTNMCLINICALTUMORSTATUS() {
        return TNMCLINICALTUMORSTATUS;
    }
    /**
     * @param tnmclinicaltumorstatus the tNMCLINICALTUMORSTATUS to set
     */
    public void setTNMCLINICALTUMORSTATUS(ClinicalAssessment tnmclinicaltumorstatus) {
        TNMCLINICALTUMORSTATUS = tnmclinicaltumorstatus;
    }
    /**
     * @return the aLCOHOLCONSUMPTION
     */
    public NumericMeasurement getALCOHOLCONSUMPTION() {
        return ALCOHOLCONSUMPTION;
    }
    /**
     * @param alcoholconsumption the aLCOHOLCONSUMPTION to set
     */
    public void setALCOHOLCONSUMPTION(NumericMeasurement alcoholconsumption) {
        ALCOHOLCONSUMPTION = alcoholconsumption;
    }
    /**
     * @return the hISTOLOGICNUCLEARGRADE
     */
    public ClinicalAssessment getHISTOLOGICNUCLEARGRADE() {
        return HISTOLOGICNUCLEARGRADE;
    }
    /**
     * @param histologicnucleargrade the hISTOLOGICNUCLEARGRADE to set
     */
    public void setHISTOLOGICNUCLEARGRADE(ClinicalAssessment histologicnucleargrade) {
        HISTOLOGICNUCLEARGRADE = histologicnucleargrade;
    }
    /**
     * @return the iNITIALWEIGHT
     */
    public NumericMeasurement getINITIALWEIGHT() {
        return INITIALWEIGHT;
    }
    /**
     * @param initialweight the iNITIALWEIGHT to set
     */
    public void setINITIALWEIGHT(NumericMeasurement initialweight) {
        INITIALWEIGHT = initialweight;
    }
    /**
     * @return the eNDDATE
     */
    public ClinicalAssessment getENDDATE() {
        return ENDDATE;
    }
    /**
     * @param enddate the eNDDATE to set
     */
    public void setENDDATE(ClinicalAssessment enddate) {
        ENDDATE = enddate;
    }
    /**
     * @return the dATEOFRADIATION
     */
    public ClinicalAssessment getDATEOFRADIATION() {
        return DATEOFRADIATION;
    }
    /**
     * @param dateofradiation the dATEOFRADIATION to set
     */
    public void setDATEOFRADIATION(ClinicalAssessment dateofradiation) {
        DATEOFRADIATION = dateofradiation;
    }
    /**
     * @return the eNVIRONMENTALEXPOSURE
     */
    public ClinicalAssessment getENVIRONMENTALEXPOSURE() {
        return ENVIRONMENTALEXPOSURE;
    }
    /**
     * @param environmentalexposure the eNVIRONMENTALEXPOSURE to set
     */
    public void setENVIRONMENTALEXPOSURE(ClinicalAssessment environmentalexposure) {
        ENVIRONMENTALEXPOSURE = environmentalexposure;
    }
    /**
     * @return the pERCENTGRANULOCYTEINFILTRATION
     */
    public ClinicalAssessment getPERCENTGRANULOCYTEINFILTRATION() {
        return PERCENTGRANULOCYTEINFILTRATION;
    }
    /**
     * @param percentgranulocyteinfiltration the pERCENTGRANULOCYTEINFILTRATION to set
     */
    public void setPERCENTGRANULOCYTEINFILTRATION(
            ClinicalAssessment percentgranulocyteinfiltration) {
        PERCENTGRANULOCYTEINFILTRATION = percentgranulocyteinfiltration;
    }
    /**
     * @return the tNMRECURRENCELYMPHNODESTATUS
     */
    public ClinicalAssessment getTNMRECURRENCELYMPHNODESTATUS() {
        return TNMRECURRENCELYMPHNODESTATUS;
    }
    /**
     * @param tnmrecurrencelymphnodestatus the tNMRECURRENCELYMPHNODESTATUS to set
     */
    public void setTNMRECURRENCELYMPHNODESTATUS(
            ClinicalAssessment tnmrecurrencelymphnodestatus) {
        TNMRECURRENCELYMPHNODESTATUS = tnmrecurrencelymphnodestatus;
    }
    /**
     * @return the pROTOCOLNAME
     */
    public ClinicalAssessment getPROTOCOLNAME() {
        return PROTOCOLNAME;
    }
    /**
     * @param protocolname the pROTOCOLNAME to set
     */
    public void setPROTOCOLNAME(ClinicalAssessment protocolname) {
        PROTOCOLNAME = protocolname;
    }
    /**
     * @return the iNITIALCOURSE
     */
    public ClinicalAssessment getINITIALCOURSE() {
        return INITIALCOURSE;
    }
    /**
     * @param initialcourse the iNITIALCOURSE to set
     */
    public void setINITIALCOURSE(ClinicalAssessment initialcourse) {
        INITIALCOURSE = initialcourse;
    }
    /**
     * @return the mARGINSINVOLVED
     */
    public ClinicalAssessment getMARGINSINVOLVED() {
        return MARGINSINVOLVED;
    }
    /**
     * @param marginsinvolved the mARGINSINVOLVED to set
     */
    public void setMARGINSINVOLVED(ClinicalAssessment marginsinvolved) {
        MARGINSINVOLVED = marginsinvolved;
    }
    /**
     * @return the pERCENTSTROMALCELLS
     */
    public NumericMeasurement getPERCENTSTROMALCELLS() {
        return PERCENTSTROMALCELLS;
    }
    /**
     * @param percentstromalcells the pERCENTSTROMALCELLS to set
     */
    public void setPERCENTSTROMALCELLS(NumericMeasurement percentstromalcells) {
        PERCENTSTROMALCELLS = percentstromalcells;
    }
    /**
     * @return the pROTOCOLTEXT
     */
    public ClinicalAssessment getPROTOCOLTEXT() {
        return PROTOCOLTEXT;
    }
    /**
     * @param protocoltext the pROTOCOLTEXT to set
     */
    public void setPROTOCOLTEXT(ClinicalAssessment protocoltext) {
        PROTOCOLTEXT = protocoltext;
    }
    /**
     * @return the tIMEBETWEENEXCISIONANDFREEZING
     */
    public NumericMeasurement getTIMEBETWEENEXCISIONANDFREEZING() {
        return TIMEBETWEENEXCISIONANDFREEZING;
    }
    /**
     * @param timebetweenexcisionandfreezing the tIMEBETWEENEXCISIONANDFREEZING to set
     */
    public void setTIMEBETWEENEXCISIONANDFREEZING(
            NumericMeasurement timebetweenexcisionandfreezing) {
        TIMEBETWEENEXCISIONANDFREEZING = timebetweenexcisionandfreezing;
    }
    /**
     * @return the pROTOCOLFILENAME
     */
    public ClinicalAssessment getPROTOCOLFILENAME() {
        return PROTOCOLFILENAME;
    }
    /**
     * @param protocolfilename the pROTOCOLFILENAME to set
     */
    public void setPROTOCOLFILENAME(ClinicalAssessment protocolfilename) {
        PROTOCOLFILENAME = protocolfilename;
    }
    /**
     * @return the nUMBERPROLIFERATINGCELLS
     */
    public NumericMeasurement getNUMBERPROLIFERATINGCELLS() {
        return NUMBERPROLIFERATINGCELLS;
    }
    /**
     * @param numberproliferatingcells the nUMBERPROLIFERATINGCELLS to set
     */
    public void setNUMBERPROLIFERATINGCELLS(
            NumericMeasurement numberproliferatingcells) {
        NUMBERPROLIFERATINGCELLS = numberproliferatingcells;
    }
    /**
     * @return the sAMPLETYPE
     */
    public ClinicalAssessment getSAMPLETYPE() {
        return SAMPLETYPE;
    }
    /**
     * @param sampletype the sAMPLETYPE to set
     */
    public void setSAMPLETYPE(ClinicalAssessment sampletype) {
        SAMPLETYPE = sampletype;
    }
    /**
     * @return the dATEOFPROCEDURE
     */
    public ClinicalAssessment getDATEOFPROCEDURE() {
        return DATEOFPROCEDURE;
    }
    /**
     * @param dateofprocedure the dATEOFPROCEDURE to set
     */
    public void setDATEOFPROCEDURE(ClinicalAssessment dateofprocedure) {
        DATEOFPROCEDURE = dateofprocedure;
    }
    /**
     * @return the rADIATIONDOSAGE
     */
    public ClinicalAssessment getRADIATIONDOSAGE() {
        return RADIATIONDOSAGE;
    }
    /**
     * @param radiationdosage the rADIATIONDOSAGE to set
     */
    public void setRADIATIONDOSAGE(ClinicalAssessment radiationdosage) {
        RADIATIONDOSAGE = radiationdosage;
    }
    /**
     * @return the pERCENTTUMORNUCLEI
     */
    public ClinicalAssessment getPERCENTTUMORNUCLEI() {
        return PERCENTTUMORNUCLEI;
    }
    /**
     * @param percenttumornuclei the pERCENTTUMORNUCLEI to set
     */
    public void setPERCENTTUMORNUCLEI(ClinicalAssessment percenttumornuclei) {
        PERCENTTUMORNUCLEI = percenttumornuclei;
    }
    /**
     * @return the bCRALIQUOTBARCODE
     */
    public ClinicalAssessment getBCRALIQUOTBARCODE() {
        return BCRALIQUOTBARCODE;
    }
    /**
     * @param bcraliquotbarcode the bCRALIQUOTBARCODE to set
     */
    public void setBCRALIQUOTBARCODE(ClinicalAssessment bcraliquotbarcode) {
        BCRALIQUOTBARCODE = bcraliquotbarcode;
    }
    /**
     * @return the hISTOLOGICALNUCLEARGRADE
     */
    public ClinicalAssessment getHISTOLOGICALNUCLEARGRADE() {
        return HISTOLOGICALNUCLEARGRADE;
    }
    /**
     * @param histologicalnucleargrade the hISTOLOGICALNUCLEARGRADE to set
     */
    public void setHISTOLOGICALNUCLEARGRADE(
            ClinicalAssessment histologicalnucleargrade) {
        HISTOLOGICALNUCLEARGRADE = histologicalnucleargrade;
    }
    /**
     * @return the pRIMARYPROCEDURE
     */
    public ClinicalAssessment getPRIMARYPROCEDURE() {
        return PRIMARYPROCEDURE;
    }
    /**
     * @param primaryprocedure the pRIMARYPROCEDURE to set
     */
    public void setPRIMARYPROCEDURE(ClinicalAssessment primaryprocedure) {
        PRIMARYPROCEDURE = primaryprocedure;
    }
    /**
     * @return the pERCENTINFLAMINFILTRATION
     */
    public NumericMeasurement getPERCENTINFLAMINFILTRATION() {
        return PERCENTINFLAMINFILTRATION;
    }
    /**
     * @param percentinflaminfiltration the pERCENTINFLAMINFILTRATION to set
     */
    public void setPERCENTINFLAMINFILTRATION(
            NumericMeasurement percentinflaminfiltration) {
        PERCENTINFLAMINFILTRATION = percentinflaminfiltration;
    }
    /**
     * @return the tNMPATHOLOGYMETASTATICSTATUS
     */
    public ClinicalAssessment getTNMPATHOLOGYMETASTATICSTATUS() {
        return TNMPATHOLOGYMETASTATICSTATUS;
    }
    /**
     * @param tnmpathologymetastaticstatus the tNMPATHOLOGYMETASTATICSTATUS to set
     */
    public void setTNMPATHOLOGYMETASTATICSTATUS(
            ClinicalAssessment tnmpathologymetastaticstatus) {
        TNMPATHOLOGYMETASTATICSTATUS = tnmpathologymetastaticstatus;
    }
    /**
     * @return the aNATOMICTREATMENTSITE
     */
    public ClinicalAssessment getANATOMICTREATMENTSITE() {
        return ANATOMICTREATMENTSITE;
    }
    /**
     * @param anatomictreatmentsite the aNATOMICTREATMENTSITE to set
     */
    public void setANATOMICTREATMENTSITE(ClinicalAssessment anatomictreatmentsite) {
        ANATOMICTREATMENTSITE = anatomictreatmentsite;
    }
    /**
     * @return the pERCENTTUMORCELLS
     */
    public ClinicalAssessment getPERCENTTUMORCELLS() {
        return PERCENTTUMORCELLS;
    }
    /**
     * @param percenttumorcells the pERCENTTUMORCELLS to set
     */
    public void setPERCENTTUMORCELLS(ClinicalAssessment percenttumorcells) {
        PERCENTTUMORCELLS = percenttumorcells;
    }
    /**
     * @return the cONCENTRATION
     */
    public NumericMeasurement getCONCENTRATION() {
        return CONCENTRATION;
    }
    /**
     * @param concentration the cONCENTRATION to set
     */
    public void setCONCENTRATION(NumericMeasurement concentration) {
        CONCENTRATION = concentration;
    }
    /**
     * @return the pROGRESSIONDETERMINEDBY
     */
    public ClinicalAssessment getPROGRESSIONDETERMINEDBY() {
        return PROGRESSIONDETERMINEDBY;
    }
    /**
     * @param progressiondeterminedby the pROGRESSIONDETERMINEDBY to set
     */
    public void setPROGRESSIONDETERMINEDBY(
            ClinicalAssessment progressiondeterminedby) {
        PROGRESSIONDETERMINEDBY = progressiondeterminedby;
    }
    /**
     * @return the lYMPHNODEPROCEDURE
     */
    public ClinicalAssessment getLYMPHNODEPROCEDURE() {
        return LYMPHNODEPROCEDURE;
    }
    /**
     * @param lymphnodeprocedure the lYMPHNODEPROCEDURE to set
     */
    public void setLYMPHNODEPROCEDURE(ClinicalAssessment lymphnodeprocedure) {
        LYMPHNODEPROCEDURE = lymphnodeprocedure;
    }
    /**
     * @return the dOSAGEUNITS
     */
    public ClinicalAssessment getDOSAGEUNITS() {
        return DOSAGEUNITS;
    }
    /**
     * @param dosageunits the dOSAGEUNITS to set
     */
    public void setDOSAGEUNITS(ClinicalAssessment dosageunits) {
        DOSAGEUNITS = dosageunits;
    }
    /**
     * @return the pALISADINGNECROSIS
     */
    public ClinicalAssessment getPALISADINGNECROSIS() {
        return PALISADINGNECROSIS;
    }
    /**
     * @param palisadingnecrosis the pALISADINGNECROSIS to set
     */
    public void setPALISADINGNECROSIS(ClinicalAssessment palisadingnecrosis) {
        PALISADINGNECROSIS = palisadingnecrosis;
    }
    /**
     * @return the dRUGDOSAGE
     */
    public ClinicalAssessment getDRUGDOSAGE() {
        return DRUGDOSAGE;
    }
    /**
     * @param drugdosage the dRUGDOSAGE to set
     */
    public void setDRUGDOSAGE(ClinicalAssessment drugdosage) {
        DRUGDOSAGE = drugdosage;
    }
    /**
     * @return the tNMCLINICALMETASTATICSTATUS
     */
    public ClinicalAssessment getTNMCLINICALMETASTATICSTATUS() {
        return TNMCLINICALMETASTATICSTATUS;
    }
    /**
     * @param tnmclinicalmetastaticstatus the tNMCLINICALMETASTATICSTATUS to set
     */
    public void setTNMCLINICALMETASTATICSTATUS(
            ClinicalAssessment tnmclinicalmetastaticstatus) {
        TNMCLINICALMETASTATICSTATUS = tnmclinicalmetastaticstatus;
    }
    /**
     * @return the tUMORTISSUESITE
     */
    public ClinicalAssessment getTUMORTISSUESITE() {
        return TUMORTISSUESITE;
    }
    /**
     * @param tumortissuesite the tUMORTISSUESITE to set
     */
    public void setTUMORTISSUESITE(ClinicalAssessment tumortissuesite) {
        TUMORTISSUESITE = tumortissuesite;
    }
    /**
     * @return the mETASTATICPROCEDURE
     */
    public ClinicalAssessment getMETASTATICPROCEDURE() {
        return METASTATICPROCEDURE;
    }
    /**
     * @param metastaticprocedure the mETASTATICPROCEDURE to set
     */
    public void setMETASTATICPROCEDURE(ClinicalAssessment metastaticprocedure) {
        METASTATICPROCEDURE = metastaticprocedure;
    }
    /**
     * @return the pERCENTNEUTROPHILINFILTRATION
     */
    public NumericMeasurement getPERCENTNEUTROPHILINFILTRATION() {
        return PERCENTNEUTROPHILINFILTRATION;
    }
    /**
     * @param percentneutrophilinfiltration the pERCENTNEUTROPHILINFILTRATION to set
     */
    public void setPERCENTNEUTROPHILINFILTRATION(
            NumericMeasurement percentneutrophilinfiltration) {
        PERCENTNEUTROPHILINFILTRATION = percentneutrophilinfiltration;
    }
    /**
     * @return the pROGRESSIONSTATUS
     */
    public ClinicalAssessment getPROGRESSIONSTATUS() {
        return PROGRESSIONSTATUS;
    }
    /**
     * @param progressionstatus the pROGRESSIONSTATUS to set
     */
    public void setPROGRESSIONSTATUS(ClinicalAssessment progressionstatus) {
        PROGRESSIONSTATUS = progressionstatus;
    }
    /**
     * @return the nORMALTUMORGENOTYPEMATCH
     */
    public ClinicalAssessment getNORMALTUMORGENOTYPEMATCH() {
        return NORMALTUMORGENOTYPEMATCH;
    }
    /**
     * @param normaltumorgenotypematch the nORMALTUMORGENOTYPEMATCH to set
     */
    public void setNORMALTUMORGENOTYPEMATCH(
            ClinicalAssessment normaltumorgenotypematch) {
        NORMALTUMORGENOTYPEMATCH = normaltumorgenotypematch;
    }
    /**
     * @return the tNMCLINICALSTAGEGROUPING
     */
    public ClinicalAssessment getTNMCLINICALSTAGEGROUPING() {
        return TNMCLINICALSTAGEGROUPING;
    }
    /**
     * @param tnmclinicalstagegrouping the tNMCLINICALSTAGEGROUPING to set
     */
    public void setTNMCLINICALSTAGEGROUPING(
            ClinicalAssessment tnmclinicalstagegrouping) {
        TNMCLINICALSTAGEGROUPING = tnmclinicalstagegrouping;
    }
    /**
     * @return the pCRAMPLIFICATIONSUCCESSFUL
     */
    public ClinicalAssessment getPCRAMPLIFICATIONSUCCESSFUL() {
        return PCRAMPLIFICATIONSUCCESSFUL;
    }
    /**
     * @param pcramplificationsuccessful the pCRAMPLIFICATIONSUCCESSFUL to set
     */
    public void setPCRAMPLIFICATIONSUCCESSFUL(
            ClinicalAssessment pcramplificationsuccessful) {
        PCRAMPLIFICATIONSUCCESSFUL = pcramplificationsuccessful;
    }
    /**
     * @return the iNTERMEDIATEDIMENSION
     */
    public NumericMeasurement getINTERMEDIATEDIMENSION() {
        return INTERMEDIATEDIMENSION;
    }
    /**
     * @param intermediatedimension the iNTERMEDIATEDIMENSION to set
     */
    public void setINTERMEDIATEDIMENSION(NumericMeasurement intermediatedimension) {
        INTERMEDIATEDIMENSION = intermediatedimension;
    }
    /**
     * @return the dATEOFCOLLECTION
     */
    public ClinicalAssessment getDATEOFCOLLECTION() {
        return DATEOFCOLLECTION;
    }
    /**
     * @param dateofcollection the dATEOFCOLLECTION to set
     */
    public void setDATEOFCOLLECTION(ClinicalAssessment dateofcollection) {
        DATEOFCOLLECTION = dateofcollection;
    }
    /**
     * @return the dRUGCATEGORY
     */
    public ClinicalAssessment getDRUGCATEGORY() {
        return DRUGCATEGORY;
    }
    /**
     * @param drugcategory the dRUGCATEGORY to set
     */
    public void setDRUGCATEGORY(ClinicalAssessment drugcategory) {
        DRUGCATEGORY = drugcategory;
    }
    /**
     * @return the sMOKINGHISTORY
     */
    public ClinicalAssessment getSMOKINGHISTORY() {
        return SMOKINGHISTORY;
    }
    /**
     * @param smokinghistory the sMOKINGHISTORY to set
     */
    public void setSMOKINGHISTORY(ClinicalAssessment smokinghistory) {
        SMOKINGHISTORY = smokinghistory;
    }
    /**
     * @return the tNMPATHOLOGYTUMORSTATUS
     */
    public ClinicalAssessment getTNMPATHOLOGYTUMORSTATUS() {
        return TNMPATHOLOGYTUMORSTATUS;
    }
    /**
     * @param tnmpathologytumorstatus the tNMPATHOLOGYTUMORSTATUS to set
     */
    public void setTNMPATHOLOGYTUMORSTATUS(
            ClinicalAssessment tnmpathologytumorstatus) {
        TNMPATHOLOGYTUMORSTATUS = tnmpathologytumorstatus;
    }
    /**
     * @return the lEPTOMENINGEALINVOLEMENT
     */
    public ClinicalAssessment getLEPTOMENINGEALINVOLEMENT() {
        return LEPTOMENINGEALINVOLEMENT;
    }
    /**
     * @param leptomeningealinvolement the lEPTOMENINGEALINVOLEMENT to set
     */
    public void setLEPTOMENINGEALINVOLEMENT(
            ClinicalAssessment leptomeningealinvolement) {
        LEPTOMENINGEALINVOLEMENT = leptomeningealinvolement;
    }
    /**
     * @return the dATECREATED
     */
    public ClinicalAssessment getDATECREATED() {
        return DATECREATED;
    }
    /**
     * @param datecreated the dATECREATED to set
     */
    public void setDATECREATED(ClinicalAssessment datecreated) {
        DATECREATED = datecreated;
    }
    /**
     * @return the gFAP_POSITIVE
     */
    public ClinicalAssessment getGFAP_POSITIVE() {
        return GFAP_POSITIVE;
    }
    /**
     * @param gfap_positive the gFAP_POSITIVE to set
     */
    public void setGFAP_POSITIVE(ClinicalAssessment gfap_positive) {
        GFAP_POSITIVE = gfap_positive;
    }
    /**
     * @return the bCRSAMPLEBARCODE
     */
    public ClinicalAssessment getBCRSAMPLEBARCODE() {
        return BCRSAMPLEBARCODE;
    }
    /**
     * @param bcrsamplebarcode the bCRSAMPLEBARCODE to set
     */
    public void setBCRSAMPLEBARCODE(ClinicalAssessment bcrsamplebarcode) {
        BCRSAMPLEBARCODE = bcrsamplebarcode;
    }
    /**
     * @return the rACE
     */
    public ClinicalAssessment getRACE() {
        return RACE;
    }
    /**
     * @param race the rACE to set
     */
    public void setRACE(ClinicalAssessment race) {
        RACE = race;
    }
    /**
     * @return the cURRENTWEIGHT
     */
    public NumericMeasurement getCURRENTWEIGHT() {
        return CURRENTWEIGHT;
    }
    /**
     * @param currentweight the cURRENTWEIGHT to set
     */
    public void setCURRENTWEIGHT(NumericMeasurement currentweight) {
        CURRENTWEIGHT = currentweight;
    }
    /**
     * @return the aMOUNT
     */
    public NumericMeasurement getAMOUNT() {
        return AMOUNT;
    }
    /**
     * @param amount the aMOUNT to set
     */
    public void setAMOUNT(NumericMeasurement amount) {
        AMOUNT = amount;
    }
    /**
     * @return the gENDER
     */
    public ClinicalAssessment getGENDER() {
        return GENDER;
    }
    /**
     * @param gender the gENDER to set
     */
    public void setGENDER(ClinicalAssessment gender) {
        GENDER = gender;
    }
    /**
     * @return the iNFORMEDCONSENTACQUIRED
     */
    public ClinicalAssessment getINFORMEDCONSENTACQUIRED() {
        return INFORMEDCONSENTACQUIRED;
    }
    /**
     * @param informedconsentacquired the iNFORMEDCONSENTACQUIRED to set
     */
    public void setINFORMEDCONSENTACQUIRED(
            ClinicalAssessment informedconsentacquired) {
        INFORMEDCONSENTACQUIRED = informedconsentacquired;
    }
    /**
     * @return the pERCENTEOSINOPHILINFILTRATION
     */
    public ClinicalAssessment getPERCENTEOSINOPHILINFILTRATION() {
        return PERCENTEOSINOPHILINFILTRATION;
    }
    /**
     * @param percenteosinophilinfiltration the pERCENTEOSINOPHILINFILTRATION to set
     */
    public void setPERCENTEOSINOPHILINFILTRATION(
            ClinicalAssessment percenteosinophilinfiltration) {
        PERCENTEOSINOPHILINFILTRATION = percenteosinophilinfiltration;
    }
    /**
     * @return the wELLNUMBER
     */
    public ClinicalAssessment getWELLNUMBER() {
        return WELLNUMBER;
    }
    /**
     * @param wellnumber the wELLNUMBER to set
     */
    public void setWELLNUMBER(ClinicalAssessment wellnumber) {
        WELLNUMBER = wellnumber;
    }
    /**
     * @return the bCRSITEID
     */
    public ClinicalAssessment getBCRSITEID() {
        return BCRSITEID;
    }
    /**
     * @param bcrsiteid the bCRSITEID to set
     */
    public void setBCRSITEID(ClinicalAssessment bcrsiteid) {
        BCRSITEID = bcrsiteid;
    }
    /**
     * @return the rADIATIONTYPE
     */
    public ClinicalAssessment getRADIATIONTYPE() {
        return RADIATIONTYPE;
    }
    /**
     * @param radiationtype the rADIATIONTYPE to set
     */
    public void setRADIATIONTYPE(ClinicalAssessment radiationtype) {
        RADIATIONTYPE = radiationtype;
    }
    /**
     * @return the gELIMAGEFILE
     */
    public ClinicalAssessment getGELIMAGEFILE() {
        return GELIMAGEFILE;
    }
    /**
     * @param gelimagefile the gELIMAGEFILE to set
     */
    public void setGELIMAGEFILE(ClinicalAssessment gelimagefile) {
        GELIMAGEFILE = gelimagefile;
    }
    /**
     * @return the kARNOFSKYPERFORMANCESCORE
     */
    public NumericMeasurement getKARNOFSKYPERFORMANCESCORE() {
        return KARNOFSKYPERFORMANCESCORE;
    }
    /**
     * @param karnofskyperformancescore the kARNOFSKYPERFORMANCESCORE to set
     */
    public void setKARNOFSKYPERFORMANCESCORE(
            NumericMeasurement karnofskyperformancescore) {
        KARNOFSKYPERFORMANCESCORE = karnofskyperformancescore;
    }
    /**
     * @return the bCRPATIENTBARCODE
     */
    public ClinicalAssessment getBCRPATIENTBARCODE() {
        return BCRPATIENTBARCODE;
    }
    /**
     * @param bcrpatientbarcode the bCRPATIENTBARCODE to set
     */
    public void setBCRPATIENTBARCODE(ClinicalAssessment bcrpatientbarcode) {
        BCRPATIENTBARCODE = bcrpatientbarcode;
    }
    /**
     * @return the lYMPHATICINVASION
     */
    public ClinicalAssessment getLYMPHATICINVASION() {
        return LYMPHATICINVASION;
    }
    /**
     * @param lymphaticinvasion the lYMPHATICINVASION to set
     */
    public void setLYMPHATICINVASION(ClinicalAssessment lymphaticinvasion) {
        LYMPHATICINVASION = lymphaticinvasion;
    }
    /**
     * @return the eXAMINATIONDATE
     */
    public ClinicalAssessment getEXAMINATIONDATE() {
        return EXAMINATIONDATE;
    }
    /**
     * @param examinationdate the eXAMINATIONDATE to set
     */
    public void setEXAMINATIONDATE(ClinicalAssessment examinationdate) {
        EXAMINATIONDATE = examinationdate;
    }
    /**
     * @return the a260A280RATIO
     */
    public NumericMeasurement getA260A280RATIO() {
        return A260A280RATIO;
    }
    /**
     * @param a260a280ratio the a260A280RATIO to set
     */
    public void setA260A280RATIO(NumericMeasurement a260a280ratio) {
        A260A280RATIO = a260a280ratio;
    }
    /**
     * @return the bCRANALYTEBARCODE
     */
    public ClinicalAssessment getBCRANALYTEBARCODE() {
        return BCRANALYTEBARCODE;
    }
    /**
     * @param bcranalytebarcode the bCRANALYTEBARCODE to set
     */
    public void setBCRANALYTEBARCODE(ClinicalAssessment bcranalytebarcode) {
        BCRANALYTEBARCODE = bcranalytebarcode;
    }
    /**
     * @return the lONGESTDIMENSION
     */
    public NumericMeasurement getLONGESTDIMENSION() {
        return LONGESTDIMENSION;
    }
    /**
     * @param longestdimension the lONGESTDIMENSION to set
     */
    public void setLONGESTDIMENSION(NumericMeasurement longestdimension) {
        LONGESTDIMENSION = longestdimension;
    }
    /**
     * @return the eXPERIMENTALPROTOCOLTYPE
     */
    public ClinicalAssessment getEXPERIMENTALPROTOCOLTYPE() {
        return EXPERIMENTALPROTOCOLTYPE;
    }
    /**
     * @param experimentalprotocoltype the eXPERIMENTALPROTOCOLTYPE to set
     */
    public void setEXPERIMENTALPROTOCOLTYPE(
            ClinicalAssessment experimentalprotocoltype) {
        EXPERIMENTALPROTOCOLTYPE = experimentalprotocoltype;
    }
    /**
     * @return the pERCENTNORMALCELLS
     */
    public ClinicalAssessment getPERCENTNORMALCELLS() {
        return PERCENTNORMALCELLS;
    }
    /**
     * @param percentnormalcells the pERCENTNORMALCELLS to set
     */
    public void setPERCENTNORMALCELLS(ClinicalAssessment percentnormalcells) {
        PERCENTNORMALCELLS = percentnormalcells;
    }
    /**
     * @return the pERCENTLYMPHOCYTEINFILTRATION
     */
    public NumericMeasurement getPERCENTLYMPHOCYTEINFILTRATION() {
        return PERCENTLYMPHOCYTEINFILTRATION;
    }
    /**
     * @param percentlymphocyteinfiltration the pERCENTLYMPHOCYTEINFILTRATION to set
     */
    public void setPERCENTLYMPHOCYTEINFILTRATION(
            NumericMeasurement percentlymphocyteinfiltration) {
        PERCENTLYMPHOCYTEINFILTRATION = percentlymphocyteinfiltration;
    }
    /**
     * @return the dATEOFLASTFOLLOWUP
     */
    public ClinicalAssessment getDATEOFLASTFOLLOWUP() {
        return DATEOFLASTFOLLOWUP;
    }
    /**
     * @param dateoflastfollowup the dATEOFLASTFOLLOWUP to set
     */
    public void setDATEOFLASTFOLLOWUP(ClinicalAssessment dateoflastfollowup) {
        DATEOFLASTFOLLOWUP = dateoflastfollowup;
    }

}
