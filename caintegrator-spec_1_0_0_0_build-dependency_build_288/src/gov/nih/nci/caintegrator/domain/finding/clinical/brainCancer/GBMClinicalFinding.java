package gov.nih.nci.caintegrator.domain.finding.clinical.brainCancer;

import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;

public class GBMClinicalFinding extends ClinicalFinding {
    private ClinicalAssessment BCRSITEID;
    private ClinicalAssessment INFORMEDCONSENTACQUIRED;
    private ClinicalAssessment BCRSLIDEBARCODE;
    private ClinicalAssessment MIB1_POSITIVE;
    private ClinicalAssessment PERCENTMONOCYTEINFILTRATION;
    private ClinicalAssessment PROTOCOLFILENAME;
    private NumericMeasurement SURVIVAL_LENGTH_MONTH;
    private NumericMeasurement NUMBERPROLIFERATINGCELLS;
    private ClinicalAssessment PRIMARYORMETASTATICSTATUS;
    private ClinicalAssessment SHIPPINGDATE;
    private ClinicalAssessment LEPTOMENINGEALINVOLEMENT;
    private ClinicalAssessment MARGINSINVOLVED;
    private ClinicalAssessment TNMPATHOLOGYMETASTATICSTATUS;
    private ClinicalAssessment DRUGNAME;
    private ClinicalAssessment TNMRECURRENCELYMPHNODESTATUS;
    private NumericMeasurement KARNOFSKYPERFORMANCESCORE;
    private ClinicalAssessment DRUGCATEGORY;
    private ClinicalAssessment SECTIONLOCATION;
    private ClinicalAssessment DATEOFDEATH;
    private ClinicalAssessment ENDDATE;
    private ClinicalAssessment DATEOFLASTFOLLOWUP;
    private ClinicalAssessment NORMALTUMORGENOTYPEMATCH;
    private ClinicalAssessment DOSAGEUNITS;
    private ClinicalAssessment PERCENTTUMORCELLS;
    private ClinicalAssessment PERCENTEOSINOPHILINFILTRATION;
    private ClinicalAssessment CELLULARITY;
    private ClinicalAssessment TNMCLINICALLYMPHNODESTATUS;
    private ClinicalAssessment HISTOLOGICNUCLEARGRADE;
    private ClinicalAssessment PROGRESSIONDETERMINEDBY;
    private ClinicalAssessment STARTDATE;
    private ClinicalAssessment BCRANALYTEBARCODE;
    private ClinicalAssessment RADIATIONDOSAGE;
    private ClinicalAssessment PERCENTGRANULOCYTEINFILTRATION;
    private ClinicalAssessment PALISADINGNECROSIS;
    private NumericMeasurement REVISION;
    private ClinicalAssessment OCTEMBEDDED;
    private ClinicalAssessment DATECREATED;
    private ClinicalAssessment GELIMAGEFILE;
    private NumericMeasurement PERCENTNECROSIS;
    private ClinicalAssessment BCRPORTIONBARCODE;
    private NumericMeasurement PERCENTINFLAMINFILTRATION;
    private ClinicalAssessment PERCENTNORMALCELLS;
    private NumericMeasurement SHORTESTDIMENSION;
    private NumericMeasurement PERCENTSTROMALCELLS;
    private ClinicalAssessment LYMPHATICINVASION;
    private ClinicalAssessment TNMRECURRENCETUMORSTATUS;
    private ClinicalAssessment ENVIRONMENTALEXPOSURE;
    private NumericMeasurement ALCOHOLCONSUMPTION;
    private ClinicalAssessment HISTOLOGICALNUCLEARGRADE;
    private ClinicalAssessment PRIMARYPROCEDURE;
    private ClinicalAssessment ANALYTETYPE;
    private ClinicalAssessment GEMISTOCYTESPRESENT;
    private ClinicalAssessment CANCERSTATUS;
    private NumericMeasurement TIMEBETWEENCLAMPINGANDFREEZING;
    private ClinicalAssessment DATEOFCOLLECTION;
    private ClinicalAssessment ENDOTHELIALPROLIFERATION;
    private ClinicalAssessment TNMPATHOLOGYTUMORSTATUS;
    private ClinicalAssessment VITALSTATUS;
    private ClinicalAssessment PTID;
    private ClinicalAssessment BCRSAMPLEBARCODE;
    private ClinicalAssessment VERIFICATIONBYBCR;
    private ClinicalAssessment FREEZINGMETHOD;
    private ClinicalAssessment TNMCLINICALMETASTATICSTATUS;
    private ClinicalAssessment LYMPHNODEPROCEDURE;
    private ClinicalAssessment TNMRECURRENCEMETASTATICSTATUS;
    private ClinicalAssessment EXPERIMENTALPROTOCOLTYPE;
    private ClinicalAssessment DATEOFBIRTH;
    private ClinicalAssessment RADIATIONTYPE;
    private ClinicalAssessment PERCENTTUMORNUCLEI;
    private ClinicalAssessment VENOUSINVASION;
    private ClinicalAssessment HISTOLOGICALTYPE;
    private NumericMeasurement CONCENTRATION;
    private ClinicalAssessment OLIGODENDROGLIALCOMPONENT;
    private NumericMeasurement INITIALWEIGHT;
    private ClinicalAssessment TUMORSAMPLEANATOMICLOCATION;
    private ClinicalAssessment DRUGDOSAGE;
    private ClinicalAssessment NUCLEARPLEOMORPHISM;
    private NumericMeasurement NUMBERCYCLES;
    private ClinicalAssessment WELLNUMBER;
    private NumericMeasurement WEIGHT;
    private NumericMeasurement AMOUNT;
    private ClinicalAssessment PROGRESSIONSTATUS;
    private NumericMeasurement PERCENTLYMPHOCYTEINFILTRATION;
    private NumericMeasurement NUMBERREGIONALLYMPHNODESPOS;
    private ClinicalAssessment TNMRECURRENCESTAGEGROUPING;
    private NumericMeasurement INTERMEDIATEDIMENSION;
    private NumericMeasurement PERCENTNEUTROPHILINFILTRATION;
    private ClinicalAssessment BCRPATIENTBARCODE;
    private ClinicalAssessment TNMCLINICALSTAGEGROUPING;
    private ClinicalAssessment ANATOMICTREATMENTSITE;
    private ClinicalAssessment GFAP_POSITIVE;
    private ClinicalAssessment TUMORTISSUESITE;
    private ClinicalAssessment TNMPATHOLOGYSTAGEGROUPING;
    private ClinicalAssessment EXAMINATIONDATE;
    private ClinicalAssessment HISTOLOGICTYPE;
    private NumericMeasurement LONGESTDIMENSION;
    private NumericMeasurement RINVALUE;
    private ClinicalAssessment METASTATICPROCEDURE;
    private ClinicalAssessment DATEOFRADIATION;
    private ClinicalAssessment PROTOCOLNAME;
    private ClinicalAssessment RACE;
    private ClinicalAssessment INITIALCOURSE;
    private ClinicalAssessment TNMCLINICALTUMORSTATUS;
    private ClinicalAssessment NUMBERREGIONALLYMPHNODESEXAM;
    private ClinicalAssessment DATEOFPROCEDURE;
    private ClinicalAssessment SMOKINGHISTORY;
    private ClinicalAssessment PROTOCOLTEXT;
    private NumericMeasurement TIMEBETWEENEXCISIONANDFREEZING;
    private ClinicalAssessment BCRALIQUOTBARCODE;
    private ClinicalAssessment SAMPLETYPE;
    private ClinicalAssessment GENDER;
    private NumericMeasurement CURRENTWEIGHT;
    private ClinicalAssessment PCRAMPLIFICATIONSUCCESSFUL;
    private NumericMeasurement NUMFRACTIONS;
    private ClinicalAssessment TNMPATHOLOGYLYMPHNODESTATUS;

    public ClinicalAssessment getBCRSITEID() {
        return this.BCRSITEID;
    }

    public void setBCRSITEID(ClinicalAssessment BCRSITEID) {
        this.BCRSITEID = BCRSITEID;
    }

    public ClinicalAssessment getINFORMEDCONSENTACQUIRED() {
        return this.INFORMEDCONSENTACQUIRED;
    }

    public void setINFORMEDCONSENTACQUIRED(
            ClinicalAssessment INFORMEDCONSENTACQUIRED) {
        this.INFORMEDCONSENTACQUIRED = INFORMEDCONSENTACQUIRED;
    }

    public ClinicalAssessment getBCRSLIDEBARCODE() {
        return this.BCRSLIDEBARCODE;
    }

    public void setBCRSLIDEBARCODE(ClinicalAssessment BCRSLIDEBARCODE) {
        this.BCRSLIDEBARCODE = BCRSLIDEBARCODE;
    }

    public ClinicalAssessment getMIB1_POSITIVE() {
        return this.MIB1_POSITIVE;
    }

    public void setMIB1_POSITIVE(ClinicalAssessment MIB1_POSITIVE) {
        this.MIB1_POSITIVE = MIB1_POSITIVE;
    }

    public ClinicalAssessment getPERCENTMONOCYTEINFILTRATION() {
        return this.PERCENTMONOCYTEINFILTRATION;
    }

    public void setPERCENTMONOCYTEINFILTRATION(
            ClinicalAssessment PERCENTMONOCYTEINFILTRATION) {
        this.PERCENTMONOCYTEINFILTRATION = PERCENTMONOCYTEINFILTRATION;
    }

    public ClinicalAssessment getPROTOCOLFILENAME() {
        return this.PROTOCOLFILENAME;
    }

    public void setPROTOCOLFILENAME(ClinicalAssessment PROTOCOLFILENAME) {
        this.PROTOCOLFILENAME = PROTOCOLFILENAME;
    }

    public NumericMeasurement getNUMBERPROLIFERATINGCELLS() {
        return this.NUMBERPROLIFERATINGCELLS;
    }

    public void setNUMBERPROLIFERATINGCELLS(
            NumericMeasurement NUMBERPROLIFERATINGCELLS) {
        this.NUMBERPROLIFERATINGCELLS = NUMBERPROLIFERATINGCELLS;
    }

    public ClinicalAssessment getPRIMARYORMETASTATICSTATUS() {
        return this.PRIMARYORMETASTATICSTATUS;
    }

    public void setPRIMARYORMETASTATICSTATUS(
            ClinicalAssessment PRIMARYORMETASTATICSTATUS) {
        this.PRIMARYORMETASTATICSTATUS = PRIMARYORMETASTATICSTATUS;
    }

    public ClinicalAssessment getSHIPPINGDATE() {
        return this.SHIPPINGDATE;
    }

    public void setSHIPPINGDATE(ClinicalAssessment SHIPPINGDATE) {
        this.SHIPPINGDATE = SHIPPINGDATE;
    }

    public ClinicalAssessment getLEPTOMENINGEALINVOLEMENT() {
        return this.LEPTOMENINGEALINVOLEMENT;
    }

    public void setLEPTOMENINGEALINVOLEMENT(
            ClinicalAssessment LEPTOMENINGEALINVOLEMENT) {
        this.LEPTOMENINGEALINVOLEMENT = LEPTOMENINGEALINVOLEMENT;
    }

    public ClinicalAssessment getMARGINSINVOLVED() {
        return this.MARGINSINVOLVED;
    }

    public void setMARGINSINVOLVED(ClinicalAssessment MARGINSINVOLVED) {
        this.MARGINSINVOLVED = MARGINSINVOLVED;
    }

    public ClinicalAssessment getTNMPATHOLOGYMETASTATICSTATUS() {
        return this.TNMPATHOLOGYMETASTATICSTATUS;
    }

    public void setTNMPATHOLOGYMETASTATICSTATUS(
            ClinicalAssessment TNMPATHOLOGYMETASTATICSTATUS) {
        this.TNMPATHOLOGYMETASTATICSTATUS = TNMPATHOLOGYMETASTATICSTATUS;
    }

    public ClinicalAssessment getDRUGNAME() {
        return this.DRUGNAME;
    }

    public void setDRUGNAME(ClinicalAssessment DRUGNAME) {
        this.DRUGNAME = DRUGNAME;
    }

    public ClinicalAssessment getTNMRECURRENCELYMPHNODESTATUS() {
        return this.TNMRECURRENCELYMPHNODESTATUS;
    }

    public void setTNMRECURRENCELYMPHNODESTATUS(
            ClinicalAssessment TNMRECURRENCELYMPHNODESTATUS) {
        this.TNMRECURRENCELYMPHNODESTATUS = TNMRECURRENCELYMPHNODESTATUS;
    }

    public NumericMeasurement getKARNOFSKYPERFORMANCESCORE() {
        return this.KARNOFSKYPERFORMANCESCORE;
    }

    public void setKARNOFSKYPERFORMANCESCORE(
            NumericMeasurement KARNOFSKYPERFORMANCESCORE) {
        this.KARNOFSKYPERFORMANCESCORE = KARNOFSKYPERFORMANCESCORE;
    }

    public ClinicalAssessment getDRUGCATEGORY() {
        return this.DRUGCATEGORY;
    }

    public void setDRUGCATEGORY(ClinicalAssessment DRUGCATEGORY) {
        this.DRUGCATEGORY = DRUGCATEGORY;
    }

    public ClinicalAssessment getSECTIONLOCATION() {
        return this.SECTIONLOCATION;
    }

    public void setSECTIONLOCATION(ClinicalAssessment SECTIONLOCATION) {
        this.SECTIONLOCATION = SECTIONLOCATION;
    }

    public ClinicalAssessment getDATEOFDEATH() {
        return this.DATEOFDEATH;
    }

    public void setDATEOFDEATH(ClinicalAssessment DATEOFDEATH) {
        this.DATEOFDEATH = DATEOFDEATH;
    }

    public ClinicalAssessment getENDDATE() {
        return this.ENDDATE;
    }

    public void setENDDATE(ClinicalAssessment ENDDATE) {
        this.ENDDATE = ENDDATE;
    }

    public ClinicalAssessment getDATEOFLASTFOLLOWUP() {
        return this.DATEOFLASTFOLLOWUP;
    }

    public void setDATEOFLASTFOLLOWUP(ClinicalAssessment DATEOFLASTFOLLOWUP) {
        this.DATEOFLASTFOLLOWUP = DATEOFLASTFOLLOWUP;
    }

    public ClinicalAssessment getNORMALTUMORGENOTYPEMATCH() {
        return this.NORMALTUMORGENOTYPEMATCH;
    }

    public void setNORMALTUMORGENOTYPEMATCH(
            ClinicalAssessment NORMALTUMORGENOTYPEMATCH) {
        this.NORMALTUMORGENOTYPEMATCH = NORMALTUMORGENOTYPEMATCH;
    }

    public ClinicalAssessment getDOSAGEUNITS() {
        return this.DOSAGEUNITS;
    }

    public void setDOSAGEUNITS(ClinicalAssessment DOSAGEUNITS) {
        this.DOSAGEUNITS = DOSAGEUNITS;
    }

    public ClinicalAssessment getPERCENTTUMORCELLS() {
        return this.PERCENTTUMORCELLS;
    }

    public void setPERCENTTUMORCELLS(ClinicalAssessment PERCENTTUMORCELLS) {
        this.PERCENTTUMORCELLS = PERCENTTUMORCELLS;
    }

    public ClinicalAssessment getPERCENTEOSINOPHILINFILTRATION() {
        return this.PERCENTEOSINOPHILINFILTRATION;
    }

    public void setPERCENTEOSINOPHILINFILTRATION(
            ClinicalAssessment PERCENTEOSINOPHILINFILTRATION) {
        this.PERCENTEOSINOPHILINFILTRATION = PERCENTEOSINOPHILINFILTRATION;
    }

    public ClinicalAssessment getCELLULARITY() {
        return this.CELLULARITY;
    }

    public void setCELLULARITY(ClinicalAssessment CELLULARITY) {
        this.CELLULARITY = CELLULARITY;
    }

    public ClinicalAssessment getTNMCLINICALLYMPHNODESTATUS() {
        return this.TNMCLINICALLYMPHNODESTATUS;
    }

    public void setTNMCLINICALLYMPHNODESTATUS(
            ClinicalAssessment TNMCLINICALLYMPHNODESTATUS) {
        this.TNMCLINICALLYMPHNODESTATUS = TNMCLINICALLYMPHNODESTATUS;
    }

    public ClinicalAssessment getHISTOLOGICNUCLEARGRADE() {
        return this.HISTOLOGICNUCLEARGRADE;
    }

    public void setHISTOLOGICNUCLEARGRADE(
            ClinicalAssessment HISTOLOGICNUCLEARGRADE) {
        this.HISTOLOGICNUCLEARGRADE = HISTOLOGICNUCLEARGRADE;
    }

    public ClinicalAssessment getPROGRESSIONDETERMINEDBY() {
        return this.PROGRESSIONDETERMINEDBY;
    }

    public void setPROGRESSIONDETERMINEDBY(
            ClinicalAssessment PROGRESSIONDETERMINEDBY) {
        this.PROGRESSIONDETERMINEDBY = PROGRESSIONDETERMINEDBY;
    }

    public ClinicalAssessment getSTARTDATE() {
        return this.STARTDATE;
    }

    public void setSTARTDATE(ClinicalAssessment STARTDATE) {
        this.STARTDATE = STARTDATE;
    }

    public ClinicalAssessment getBCRANALYTEBARCODE() {
        return this.BCRANALYTEBARCODE;
    }

    public void setBCRANALYTEBARCODE(ClinicalAssessment BCRANALYTEBARCODE) {
        this.BCRANALYTEBARCODE = BCRANALYTEBARCODE;
    }

    public ClinicalAssessment getRADIATIONDOSAGE() {
        return this.RADIATIONDOSAGE;
    }

    public void setRADIATIONDOSAGE(ClinicalAssessment RADIATIONDOSAGE) {
        this.RADIATIONDOSAGE = RADIATIONDOSAGE;
    }

    public ClinicalAssessment getPERCENTGRANULOCYTEINFILTRATION() {
        return this.PERCENTGRANULOCYTEINFILTRATION;
    }

    public void setPERCENTGRANULOCYTEINFILTRATION(
            ClinicalAssessment PERCENTGRANULOCYTEINFILTRATION) {
        this.PERCENTGRANULOCYTEINFILTRATION = PERCENTGRANULOCYTEINFILTRATION;
    }

    public ClinicalAssessment getPALISADINGNECROSIS() {
        return this.PALISADINGNECROSIS;
    }

    public void setPALISADINGNECROSIS(ClinicalAssessment PALISADINGNECROSIS) {
        this.PALISADINGNECROSIS = PALISADINGNECROSIS;
    }

    public NumericMeasurement getREVISION() {
        return this.REVISION;
    }

    public void setREVISION(NumericMeasurement REVISION) {
        this.REVISION = REVISION;
    }

    public ClinicalAssessment getOCTEMBEDDED() {
        return this.OCTEMBEDDED;
    }

    public void setOCTEMBEDDED(ClinicalAssessment OCTEMBEDDED) {
        this.OCTEMBEDDED = OCTEMBEDDED;
    }

    public ClinicalAssessment getDATECREATED() {
        return this.DATECREATED;
    }

    public void setDATECREATED(ClinicalAssessment DATECREATED) {
        this.DATECREATED = DATECREATED;
    }

    public ClinicalAssessment getGELIMAGEFILE() {
        return this.GELIMAGEFILE;
    }

    public void setGELIMAGEFILE(ClinicalAssessment GELIMAGEFILE) {
        this.GELIMAGEFILE = GELIMAGEFILE;
    }

    public NumericMeasurement getPERCENTNECROSIS() {
        return this.PERCENTNECROSIS;
    }

    public void setPERCENTNECROSIS(NumericMeasurement PERCENTNECROSIS) {
        this.PERCENTNECROSIS = PERCENTNECROSIS;
    }

    public ClinicalAssessment getBCRPORTIONBARCODE() {
        return this.BCRPORTIONBARCODE;
    }

    public void setBCRPORTIONBARCODE(ClinicalAssessment BCRPORTIONBARCODE) {
        this.BCRPORTIONBARCODE = BCRPORTIONBARCODE;
    }

    public NumericMeasurement getPERCENTINFLAMINFILTRATION() {
        return this.PERCENTINFLAMINFILTRATION;
    }

    public void setPERCENTINFLAMINFILTRATION(
            NumericMeasurement PERCENTINFLAMINFILTRATION) {
        this.PERCENTINFLAMINFILTRATION = PERCENTINFLAMINFILTRATION;
    }

    public ClinicalAssessment getPERCENTNORMALCELLS() {
        return this.PERCENTNORMALCELLS;
    }

    public void setPERCENTNORMALCELLS(ClinicalAssessment PERCENTNORMALCELLS) {
        this.PERCENTNORMALCELLS = PERCENTNORMALCELLS;
    }

    public NumericMeasurement getSHORTESTDIMENSION() {
        return this.SHORTESTDIMENSION;
    }

    public void setSHORTESTDIMENSION(NumericMeasurement SHORTESTDIMENSION) {
        this.SHORTESTDIMENSION = SHORTESTDIMENSION;
    }

    public NumericMeasurement getPERCENTSTROMALCELLS() {
        return this.PERCENTSTROMALCELLS;
    }

    public void setPERCENTSTROMALCELLS(NumericMeasurement PERCENTSTROMALCELLS) {
        this.PERCENTSTROMALCELLS = PERCENTSTROMALCELLS;
    }

    public ClinicalAssessment getLYMPHATICINVASION() {
        return this.LYMPHATICINVASION;
    }

    public void setLYMPHATICINVASION(ClinicalAssessment LYMPHATICINVASION) {
        this.LYMPHATICINVASION = LYMPHATICINVASION;
    }

    public ClinicalAssessment getTNMRECURRENCETUMORSTATUS() {
        return this.TNMRECURRENCETUMORSTATUS;
    }

    public void setTNMRECURRENCETUMORSTATUS(
            ClinicalAssessment TNMRECURRENCETUMORSTATUS) {
        this.TNMRECURRENCETUMORSTATUS = TNMRECURRENCETUMORSTATUS;
    }

    public ClinicalAssessment getENVIRONMENTALEXPOSURE() {
        return this.ENVIRONMENTALEXPOSURE;
    }

    public void setENVIRONMENTALEXPOSURE(
            ClinicalAssessment ENVIRONMENTALEXPOSURE) {
        this.ENVIRONMENTALEXPOSURE = ENVIRONMENTALEXPOSURE;
    }

    public NumericMeasurement getALCOHOLCONSUMPTION() {
        return this.ALCOHOLCONSUMPTION;
    }

    public void setALCOHOLCONSUMPTION(NumericMeasurement ALCOHOLCONSUMPTION) {
        this.ALCOHOLCONSUMPTION = ALCOHOLCONSUMPTION;
    }

    public ClinicalAssessment getHISTOLOGICALNUCLEARGRADE() {
        return this.HISTOLOGICALNUCLEARGRADE;
    }

    public void setHISTOLOGICALNUCLEARGRADE(
            ClinicalAssessment HISTOLOGICALNUCLEARGRADE) {
        this.HISTOLOGICALNUCLEARGRADE = HISTOLOGICALNUCLEARGRADE;
    }

    public ClinicalAssessment getPRIMARYPROCEDURE() {
        return this.PRIMARYPROCEDURE;
    }

    public void setPRIMARYPROCEDURE(ClinicalAssessment PRIMARYPROCEDURE) {
        this.PRIMARYPROCEDURE = PRIMARYPROCEDURE;
    }

    public ClinicalAssessment getANALYTETYPE() {
        return this.ANALYTETYPE;
    }

    public void setANALYTETYPE(ClinicalAssessment ANALYTETYPE) {
        this.ANALYTETYPE = ANALYTETYPE;
    }

    public ClinicalAssessment getGEMISTOCYTESPRESENT() {
        return this.GEMISTOCYTESPRESENT;
    }

    public void setGEMISTOCYTESPRESENT(ClinicalAssessment GEMISTOCYTESPRESENT) {
        this.GEMISTOCYTESPRESENT = GEMISTOCYTESPRESENT;
    }

    public ClinicalAssessment getCANCERSTATUS() {
        return this.CANCERSTATUS;
    }

    public void setCANCERSTATUS(ClinicalAssessment CANCERSTATUS) {
        this.CANCERSTATUS = CANCERSTATUS;
    }

    public NumericMeasurement getTIMEBETWEENCLAMPINGANDFREEZING() {
        return this.TIMEBETWEENCLAMPINGANDFREEZING;
    }

    public void setTIMEBETWEENCLAMPINGANDFREEZING(
            NumericMeasurement TIMEBETWEENCLAMPINGANDFREEZING) {
        this.TIMEBETWEENCLAMPINGANDFREEZING = TIMEBETWEENCLAMPINGANDFREEZING;
    }

    public ClinicalAssessment getDATEOFCOLLECTION() {
        return this.DATEOFCOLLECTION;
    }

    public void setDATEOFCOLLECTION(ClinicalAssessment DATEOFCOLLECTION) {
        this.DATEOFCOLLECTION = DATEOFCOLLECTION;
    }

    public ClinicalAssessment getENDOTHELIALPROLIFERATION() {
        return this.ENDOTHELIALPROLIFERATION;
    }

    public void setENDOTHELIALPROLIFERATION(
            ClinicalAssessment ENDOTHELIALPROLIFERATION) {
        this.ENDOTHELIALPROLIFERATION = ENDOTHELIALPROLIFERATION;
    }

    public ClinicalAssessment getTNMPATHOLOGYTUMORSTATUS() {
        return this.TNMPATHOLOGYTUMORSTATUS;
    }

    public void setTNMPATHOLOGYTUMORSTATUS(
            ClinicalAssessment TNMPATHOLOGYTUMORSTATUS) {
        this.TNMPATHOLOGYTUMORSTATUS = TNMPATHOLOGYTUMORSTATUS;
    }

    public ClinicalAssessment getVITALSTATUS() {
        return this.VITALSTATUS;
    }

    public void setVITALSTATUS(ClinicalAssessment VITALSTATUS) {
        this.VITALSTATUS = VITALSTATUS;
    }

    public ClinicalAssessment getPTID() {
        return this.PTID;
    }

    public void setPTID(ClinicalAssessment PTID) {
        this.PTID = PTID;
    }

    public ClinicalAssessment getBCRSAMPLEBARCODE() {
        return this.BCRSAMPLEBARCODE;
    }

    public void setBCRSAMPLEBARCODE(ClinicalAssessment BCRSAMPLEBARCODE) {
        this.BCRSAMPLEBARCODE = BCRSAMPLEBARCODE;
    }

    public ClinicalAssessment getVERIFICATIONBYBCR() {
        return this.VERIFICATIONBYBCR;
    }

    public void setVERIFICATIONBYBCR(ClinicalAssessment VERIFICATIONBYBCR) {
        this.VERIFICATIONBYBCR = VERIFICATIONBYBCR;
    }

    public ClinicalAssessment getFREEZINGMETHOD() {
        return this.FREEZINGMETHOD;
    }

    public void setFREEZINGMETHOD(ClinicalAssessment FREEZINGMETHOD) {
        this.FREEZINGMETHOD = FREEZINGMETHOD;
    }

    public ClinicalAssessment getTNMCLINICALMETASTATICSTATUS() {
        return this.TNMCLINICALMETASTATICSTATUS;
    }

    public void setTNMCLINICALMETASTATICSTATUS(
            ClinicalAssessment TNMCLINICALMETASTATICSTATUS) {
        this.TNMCLINICALMETASTATICSTATUS = TNMCLINICALMETASTATICSTATUS;
    }

    public ClinicalAssessment getLYMPHNODEPROCEDURE() {
        return this.LYMPHNODEPROCEDURE;
    }

    public void setLYMPHNODEPROCEDURE(ClinicalAssessment LYMPHNODEPROCEDURE) {
        this.LYMPHNODEPROCEDURE = LYMPHNODEPROCEDURE;
    }

    public ClinicalAssessment getTNMRECURRENCEMETASTATICSTATUS() {
        return this.TNMRECURRENCEMETASTATICSTATUS;
    }

    public void setTNMRECURRENCEMETASTATICSTATUS(
            ClinicalAssessment TNMRECURRENCEMETASTATICSTATUS) {
        this.TNMRECURRENCEMETASTATICSTATUS = TNMRECURRENCEMETASTATICSTATUS;
    }

    public ClinicalAssessment getEXPERIMENTALPROTOCOLTYPE() {
        return this.EXPERIMENTALPROTOCOLTYPE;
    }

    public void setEXPERIMENTALPROTOCOLTYPE(
            ClinicalAssessment EXPERIMENTALPROTOCOLTYPE) {
        this.EXPERIMENTALPROTOCOLTYPE = EXPERIMENTALPROTOCOLTYPE;
    }

    public ClinicalAssessment getDATEOFBIRTH() {
        return this.DATEOFBIRTH;
    }

    public void setDATEOFBIRTH(ClinicalAssessment DATEOFBIRTH) {
        this.DATEOFBIRTH = DATEOFBIRTH;
    }

    public ClinicalAssessment getRADIATIONTYPE() {
        return this.RADIATIONTYPE;
    }

    public void setRADIATIONTYPE(ClinicalAssessment RADIATIONTYPE) {
        this.RADIATIONTYPE = RADIATIONTYPE;
    }

    public ClinicalAssessment getPERCENTTUMORNUCLEI() {
        return this.PERCENTTUMORNUCLEI;
    }

    public void setPERCENTTUMORNUCLEI(ClinicalAssessment PERCENTTUMORNUCLEI) {
        this.PERCENTTUMORNUCLEI = PERCENTTUMORNUCLEI;
    }

    public ClinicalAssessment getVENOUSINVASION() {
        return this.VENOUSINVASION;
    }

    public void setVENOUSINVASION(ClinicalAssessment VENOUSINVASION) {
        this.VENOUSINVASION = VENOUSINVASION;
    }

    public ClinicalAssessment getHISTOLOGICALTYPE() {
        return this.HISTOLOGICALTYPE;
    }

    public void setHISTOLOGICALTYPE(ClinicalAssessment HISTOLOGICALTYPE) {
        this.HISTOLOGICALTYPE = HISTOLOGICALTYPE;
    }

    public NumericMeasurement getCONCENTRATION() {
        return this.CONCENTRATION;
    }

    public void setCONCENTRATION(NumericMeasurement CONCENTRATION) {
        this.CONCENTRATION = CONCENTRATION;
    }

    public ClinicalAssessment getOLIGODENDROGLIALCOMPONENT() {
        return this.OLIGODENDROGLIALCOMPONENT;
    }

    public void setOLIGODENDROGLIALCOMPONENT(
            ClinicalAssessment OLIGODENDROGLIALCOMPONENT) {
        this.OLIGODENDROGLIALCOMPONENT = OLIGODENDROGLIALCOMPONENT;
    }

    public NumericMeasurement getINITIALWEIGHT() {
        return this.INITIALWEIGHT;
    }

    public void setINITIALWEIGHT(NumericMeasurement INITIALWEIGHT) {
        this.INITIALWEIGHT = INITIALWEIGHT;
    }

    public ClinicalAssessment getTUMORSAMPLEANATOMICLOCATION() {
        return this.TUMORSAMPLEANATOMICLOCATION;
    }

    public void setTUMORSAMPLEANATOMICLOCATION(
            ClinicalAssessment TUMORSAMPLEANATOMICLOCATION) {
        this.TUMORSAMPLEANATOMICLOCATION = TUMORSAMPLEANATOMICLOCATION;
    }

    public ClinicalAssessment getDRUGDOSAGE() {
        return this.DRUGDOSAGE;
    }

    public void setDRUGDOSAGE(ClinicalAssessment DRUGDOSAGE) {
        this.DRUGDOSAGE = DRUGDOSAGE;
    }

    public ClinicalAssessment getNUCLEARPLEOMORPHISM() {
        return this.NUCLEARPLEOMORPHISM;
    }

    public void setNUCLEARPLEOMORPHISM(ClinicalAssessment NUCLEARPLEOMORPHISM) {
        this.NUCLEARPLEOMORPHISM = NUCLEARPLEOMORPHISM;
    }

    public NumericMeasurement getNUMBERCYCLES() {
        return this.NUMBERCYCLES;
    }

    public void setNUMBERCYCLES(NumericMeasurement NUMBERCYCLES) {
        this.NUMBERCYCLES = NUMBERCYCLES;
    }

    public ClinicalAssessment getWELLNUMBER() {
        return this.WELLNUMBER;
    }

    public void setWELLNUMBER(ClinicalAssessment WELLNUMBER) {
        this.WELLNUMBER = WELLNUMBER;
    }

    public NumericMeasurement getWEIGHT() {
        return this.WEIGHT;
    }

    public void setWEIGHT(NumericMeasurement WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public NumericMeasurement getAMOUNT() {
        return this.AMOUNT;
    }

    public void setAMOUNT(NumericMeasurement AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public ClinicalAssessment getPROGRESSIONSTATUS() {
        return this.PROGRESSIONSTATUS;
    }

    public void setPROGRESSIONSTATUS(ClinicalAssessment PROGRESSIONSTATUS) {
        this.PROGRESSIONSTATUS = PROGRESSIONSTATUS;
    }

    public NumericMeasurement getPERCENTLYMPHOCYTEINFILTRATION() {
        return this.PERCENTLYMPHOCYTEINFILTRATION;
    }

    public void setPERCENTLYMPHOCYTEINFILTRATION(
            NumericMeasurement PERCENTLYMPHOCYTEINFILTRATION) {
        this.PERCENTLYMPHOCYTEINFILTRATION = PERCENTLYMPHOCYTEINFILTRATION;
    }

    public NumericMeasurement getNUMBERREGIONALLYMPHNODESPOS() {
        return this.NUMBERREGIONALLYMPHNODESPOS;
    }

    public void setNUMBERREGIONALLYMPHNODESPOS(
            NumericMeasurement NUMBERREGIONALLYMPHNODESPOS) {
        this.NUMBERREGIONALLYMPHNODESPOS = NUMBERREGIONALLYMPHNODESPOS;
    }

    public ClinicalAssessment getTNMRECURRENCESTAGEGROUPING() {
        return this.TNMRECURRENCESTAGEGROUPING;
    }

    public void setTNMRECURRENCESTAGEGROUPING(
            ClinicalAssessment TNMRECURRENCESTAGEGROUPING) {
        this.TNMRECURRENCESTAGEGROUPING = TNMRECURRENCESTAGEGROUPING;
    }

    public NumericMeasurement getINTERMEDIATEDIMENSION() {
        return this.INTERMEDIATEDIMENSION;
    }

    public void setINTERMEDIATEDIMENSION(
            NumericMeasurement INTERMEDIATEDIMENSION) {
        this.INTERMEDIATEDIMENSION = INTERMEDIATEDIMENSION;
    }

    public NumericMeasurement getPERCENTNEUTROPHILINFILTRATION() {
        return this.PERCENTNEUTROPHILINFILTRATION;
    }

    public void setPERCENTNEUTROPHILINFILTRATION(
            NumericMeasurement PERCENTNEUTROPHILINFILTRATION) {
        this.PERCENTNEUTROPHILINFILTRATION = PERCENTNEUTROPHILINFILTRATION;
    }

    public ClinicalAssessment getBCRPATIENTBARCODE() {
        return this.BCRPATIENTBARCODE;
    }

    public void setBCRPATIENTBARCODE(ClinicalAssessment BCRPATIENTBARCODE) {
        this.BCRPATIENTBARCODE = BCRPATIENTBARCODE;
    }

    public ClinicalAssessment getTNMCLINICALSTAGEGROUPING() {
        return this.TNMCLINICALSTAGEGROUPING;
    }

    public void setTNMCLINICALSTAGEGROUPING(
            ClinicalAssessment TNMCLINICALSTAGEGROUPING) {
        this.TNMCLINICALSTAGEGROUPING = TNMCLINICALSTAGEGROUPING;
    }

    public ClinicalAssessment getANATOMICTREATMENTSITE() {
        return this.ANATOMICTREATMENTSITE;
    }

    public void setANATOMICTREATMENTSITE(
            ClinicalAssessment ANATOMICTREATMENTSITE) {
        this.ANATOMICTREATMENTSITE = ANATOMICTREATMENTSITE;
    }

    public ClinicalAssessment getGFAP_POSITIVE() {
        return this.GFAP_POSITIVE;
    }

    public void setGFAP_POSITIVE(ClinicalAssessment GFAP_POSITIVE) {
        this.GFAP_POSITIVE = GFAP_POSITIVE;
    }

    public ClinicalAssessment getTUMORTISSUESITE() {
        return this.TUMORTISSUESITE;
    }

    public void setTUMORTISSUESITE(ClinicalAssessment TUMORTISSUESITE) {
        this.TUMORTISSUESITE = TUMORTISSUESITE;
    }

    public ClinicalAssessment getTNMPATHOLOGYSTAGEGROUPING() {
        return this.TNMPATHOLOGYSTAGEGROUPING;
    }

    public void setTNMPATHOLOGYSTAGEGROUPING(
            ClinicalAssessment TNMPATHOLOGYSTAGEGROUPING) {
        this.TNMPATHOLOGYSTAGEGROUPING = TNMPATHOLOGYSTAGEGROUPING;
    }

    public ClinicalAssessment getEXAMINATIONDATE() {
        return this.EXAMINATIONDATE;
    }

    public void setEXAMINATIONDATE(ClinicalAssessment EXAMINATIONDATE) {
        this.EXAMINATIONDATE = EXAMINATIONDATE;
    }

    public ClinicalAssessment getHISTOLOGICTYPE() {
        return this.HISTOLOGICTYPE;
    }

    public void setHISTOLOGICTYPE(ClinicalAssessment HISTOLOGICTYPE) {
        this.HISTOLOGICTYPE = HISTOLOGICTYPE;
    }

    public NumericMeasurement getLONGESTDIMENSION() {
        return this.LONGESTDIMENSION;
    }

    public void setLONGESTDIMENSION(NumericMeasurement LONGESTDIMENSION) {
        this.LONGESTDIMENSION = LONGESTDIMENSION;
    }

    public NumericMeasurement getRINVALUE() {
        return this.RINVALUE;
    }

    public void setRINVALUE(NumericMeasurement RINVALUE) {
        this.RINVALUE = RINVALUE;
    }

    public ClinicalAssessment getMETASTATICPROCEDURE() {
        return this.METASTATICPROCEDURE;
    }

    public void setMETASTATICPROCEDURE(ClinicalAssessment METASTATICPROCEDURE) {
        this.METASTATICPROCEDURE = METASTATICPROCEDURE;
    }

    public ClinicalAssessment getDATEOFRADIATION() {
        return this.DATEOFRADIATION;
    }

    public void setDATEOFRADIATION(ClinicalAssessment DATEOFRADIATION) {
        this.DATEOFRADIATION = DATEOFRADIATION;
    }

    public ClinicalAssessment getPROTOCOLNAME() {
        return this.PROTOCOLNAME;
    }

    public void setPROTOCOLNAME(ClinicalAssessment PROTOCOLNAME) {
        this.PROTOCOLNAME = PROTOCOLNAME;
    }

    public ClinicalAssessment getRACE() {
        return this.RACE;
    }

    public void setRACE(ClinicalAssessment RACE) {
        this.RACE = RACE;
    }

    public ClinicalAssessment getINITIALCOURSE() {
        return this.INITIALCOURSE;
    }

    public void setINITIALCOURSE(ClinicalAssessment INITIALCOURSE) {
        this.INITIALCOURSE = INITIALCOURSE;
    }

    public ClinicalAssessment getTNMCLINICALTUMORSTATUS() {
        return this.TNMCLINICALTUMORSTATUS;
    }

    public void setTNMCLINICALTUMORSTATUS(
            ClinicalAssessment TNMCLINICALTUMORSTATUS) {
        this.TNMCLINICALTUMORSTATUS = TNMCLINICALTUMORSTATUS;
    }

    public ClinicalAssessment getNUMBERREGIONALLYMPHNODESEXAM() {
        return this.NUMBERREGIONALLYMPHNODESEXAM;
    }

    public void setNUMBERREGIONALLYMPHNODESEXAM(
            ClinicalAssessment NUMBERREGIONALLYMPHNODESEXAM) {
        this.NUMBERREGIONALLYMPHNODESEXAM = NUMBERREGIONALLYMPHNODESEXAM;
    }

    public ClinicalAssessment getDATEOFPROCEDURE() {
        return this.DATEOFPROCEDURE;
    }

    public void setDATEOFPROCEDURE(ClinicalAssessment DATEOFPROCEDURE) {
        this.DATEOFPROCEDURE = DATEOFPROCEDURE;
    }

    public ClinicalAssessment getSMOKINGHISTORY() {
        return this.SMOKINGHISTORY;
    }

    public void setSMOKINGHISTORY(ClinicalAssessment SMOKINGHISTORY) {
        this.SMOKINGHISTORY = SMOKINGHISTORY;
    }

    public ClinicalAssessment getPROTOCOLTEXT() {
        return this.PROTOCOLTEXT;
    }

    public void setPROTOCOLTEXT(ClinicalAssessment PROTOCOLTEXT) {
        this.PROTOCOLTEXT = PROTOCOLTEXT;
    }

    public NumericMeasurement getTIMEBETWEENEXCISIONANDFREEZING() {
        return this.TIMEBETWEENEXCISIONANDFREEZING;
    }

    public void setTIMEBETWEENEXCISIONANDFREEZING(
            NumericMeasurement TIMEBETWEENEXCISIONANDFREEZING) {
        this.TIMEBETWEENEXCISIONANDFREEZING = TIMEBETWEENEXCISIONANDFREEZING;
    }

    public ClinicalAssessment getBCRALIQUOTBARCODE() {
        return this.BCRALIQUOTBARCODE;
    }

    public void setBCRALIQUOTBARCODE(ClinicalAssessment BCRALIQUOTBARCODE) {
        this.BCRALIQUOTBARCODE = BCRALIQUOTBARCODE;
    }

    public ClinicalAssessment getSAMPLETYPE() {
        return this.SAMPLETYPE;
    }

    public void setSAMPLETYPE(ClinicalAssessment SAMPLETYPE) {
        this.SAMPLETYPE = SAMPLETYPE;
    }

    public ClinicalAssessment getGENDER() {
        return this.GENDER;
    }

    public void setGENDER(ClinicalAssessment GENDER) {
        this.GENDER = GENDER;
    }

    public NumericMeasurement getCURRENTWEIGHT() {
        return this.CURRENTWEIGHT;
    }

    public void setCURRENTWEIGHT(NumericMeasurement CURRENTWEIGHT) {
        this.CURRENTWEIGHT = CURRENTWEIGHT;
    }

    public ClinicalAssessment getPCRAMPLIFICATIONSUCCESSFUL() {
        return this.PCRAMPLIFICATIONSUCCESSFUL;
    }

    public void setPCRAMPLIFICATIONSUCCESSFUL(
            ClinicalAssessment PCRAMPLIFICATIONSUCCESSFUL) {
        this.PCRAMPLIFICATIONSUCCESSFUL = PCRAMPLIFICATIONSUCCESSFUL;
    }

    public NumericMeasurement getNUMFRACTIONS() {
        return this.NUMFRACTIONS;
    }

    public void setNUMFRACTIONS(NumericMeasurement NUMFRACTIONS) {
        this.NUMFRACTIONS = NUMFRACTIONS;
    }

    public ClinicalAssessment getTNMPATHOLOGYLYMPHNODESTATUS() {
        return this.TNMPATHOLOGYLYMPHNODESTATUS;
    }

    public void setTNMPATHOLOGYLYMPHNODESTATUS(
            ClinicalAssessment TNMPATHOLOGYLYMPHNODESTATUS) {
        this.TNMPATHOLOGYLYMPHNODESTATUS = TNMPATHOLOGYLYMPHNODESTATUS;
    }

    /**
     * @return the sURVIVAL_LENGTH_MONTH
     */
    public NumericMeasurement getSURVIVAL_LENGTH_MONTH() {
        return SURVIVAL_LENGTH_MONTH;
    }

    /**
     * @param survival_length_month the sURVIVAL_LENGTH_MONTH to set
     */
    public void setSURVIVAL_LENGTH_MONTH(NumericMeasurement survival_length_month) {
        SURVIVAL_LENGTH_MONTH = survival_length_month;
    }
}
