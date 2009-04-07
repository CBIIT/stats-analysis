drop table Activity cascade constraints;
drop table CNA_FINDING cascade constraints;
drop table ClinicalFinding cascade constraints;
drop table DNA_SPECIMEN cascade constraints;
drop table GENE_DIM cascade constraints;
drop table GENE_SNP_ASSO cascade constraints;
drop table GENOTYPE_FACT cascade constraints;
drop table HISTOLOGY cascade constraints;
drop table LOH_FINDING cascade constraints;
drop table LUNG_CANCER_FINDING cascade constraints;
drop table SNP_ANALYSIS_FINDING_FACT cascade constraints;
drop table SNP_ANALYSIS_GROUP cascade constraints;
drop table SNP_ASSAY cascade constraints;
drop table SNP_ASSOCIATION_ANALYSIS cascade constraints;
drop table SNP_DIM cascade constraints;
drop table SNP_FREQUENCY_FACT cascade constraints;
drop table SNP_PANEL cascade constraints;
drop table SOMATIC_MUTATION_FINDING cascade constraints;
drop table SPECIMEN cascade constraints;
drop table STDPT_ANALYSIS_GRP_AS cascade constraints;
drop table STUDY_DIM cascade constraints;
drop table STUDY_PANEL_ASSO cascade constraints;
drop table STUDY_PARTICIPANT cascade constraints;
drop table STUDY_POPULATION cascade constraints;
drop table STUDY_STDPOPUPLATION_ASSO cascade constraints;
drop table STUDY_TIMECOURSE_DIM cascade constraints;
drop table Somatic_Mutation_Annotation cascade constraints;
drop table TOBACCO_CONSUMPTION cascade constraints;
create table Activity (
   ADMIN_ID varchar2(255) not null,
   ACTIVITY_DESC varchar2(255),
   ACTIVITY_NAME varchar2(255),
   DAYS_START number(19,0),
   DAYS_STOP number(19,0),
   STATUS varchar2(255),
   PATIENT_DID varchar2(255),
   TIMECOURSE_ID number(19,0),
   primary key (ADMIN_ID)
);
create table CNA_FINDING (
   PARTICIPANT_DID varchar2(255) not null,
   Abnomality_Status varchar2(255),
   Array_Type varchar2(255),
   call varchar2(255),
   Copy_Number double precision,
   Copy_Number_Pvalue double precision,
   primary key (PARTICIPANT_DID)
);
create table ClinicalFinding (
   CLINICAL_FACT_ID varchar2(255) not null,
   PARTICIPANT_DID varchar2(255),
   TIMECOURSE_ID number(19,0),
   primary key (CLINICAL_FACT_ID)
);
create table DNA_SPECIMEN (
   SPECIMEN_ID varchar2(255) not null,
   DNA_AMPLICATION_METHOD varchar2(255),
   DNA_EXTRACTION_METHOD varchar2(255),
   DNA_MATERIAL_TYPE varchar2(255),
   primary key (SPECIMEN_ID)
);
create table GENE_DIM (
   GENE_ID varchar2(255) not null,
   CHROMOSOME varchar2(255),
   FEATURE_NAME varchar2(255),
   CHROMOSOME_START number(19,0),
   CHROMOSOME_END number(19,0),
   primary key (GENE_ID)
);
create table GENE_SNP_ASSO (
   GENE_ID varchar2(255) not null,
   SNPANNO_ID varchar2(255) not null,
   primary key (SNPANNO_ID, GENE_ID)
);
create table GENOTYPE_FACT (
   GS_ID number(19,0) not null,
   ALLELE1 varchar2(255),
   ALLELE2 varchar2(255),
   NORMAL_X float,
   NORMAL_Y float,
   QUALITY_SCORE float,
   RAW_X float,
   RAW_Y float,
   STATUS varchar2(255),
   SNPANNO_ID varchar2(255),
   STUDY_NAME varchar2(255) not null,
   SPECIMEN_ID varchar2(255) not null,
   ASSAY_ID number(19,0) not null,
   primary key (GS_ID)
);
create table HISTOLOGY (
   HISTOLOGY_ID number(10,0) not null,
   INVASIVE_PRESENTATION varchar2(255),
   COMMENTS varchar2(255),
   DIAGNOSIS_NAME varchar2(255),
   GRADE varchar2(255),
   STAGE varchar2(255),
   TYPE varchar2(255),
   T_STAGE varchar2(255),
   M_STAGE varchar2(255),
   N_STAGE varchar2(255),
   site varchar2(255),
   primary key (HISTOLOGY_ID)
);
create table LOH_FINDING (
   PARTICIPANT_DID varchar2(255) not null,
   Array_Type varchar2(255),
   Loss_Of_Heterozygosity_Score float,
   pValue float,
   ReferenceAllele varchar2(255),
   Sample_Allele varchar2(255),
   primary key (PARTICIPANT_DID)
);
create table LUNG_CANCER_FINDING (
   FINDING_ID varchar2(255) not null,
   Frozen_Acinar number(1,0),
   Frozen_Papillary number(1,0),
   Frozen_Concordant number(1,0),
   Frozen_BAC varchar2(255),
   Frozen_Micropapillary number(1,0),
   Percent_Tumor number(10,0),
   Frozen_Solid number(1,0),
   Clear_Cell float,
   Fetal float,
   Signet_Ring float,
   Papillary number(10,0),
   Acinar number(10,0),
   MicroPapillary number(10,0),
   Colloid number(10,0),
   Solid number(10,0),
   BAC number(10,0),
   BAC_Type varchar2(255),
   Pahology_DX varchar2(255),
   Path_Review varchar2(255),
   TSP_Normal_DNA_ID number(10,0),
   Normal_DNA_Source varchar2(255),
   primary key (FINDING_ID)
);
create table SNP_ANALYSIS_FINDING_FACT (
   ASSO_ANA_FACT_ID number(19,0) not null,
   ASSO_ANA_PVALUE float,
   ASSO_ANA_RANK number(10,0),
   SNPANNO_ID varchar2(255),
   ASSO_ANALYSIS_ID number(19,0),
   primary key (ASSO_ANA_FACT_ID)
);
create table SNP_ANALYSIS_GROUP (
   ANA_GRP_ID number(19,0) not null,
   MEMBER_COUNT number(10,0),
   ANA_GRP_NAME varchar2(255),
   ANA_GRP_DESCRIPTION varchar2(255),
   ASSO_ANALYSIS_ID number(19,0),
   primary key (ANA_GRP_ID)
);
create table SNP_ASSAY (
   ASSAY_ID number(19,0) not null,
   DESIGN_ALLELES varchar2(255),
   DESIGN_SCORE float,
   DESIGN_SEQUENCE varchar2(255),
   DESIGN_STRAND varchar2(255),
   STATUS varchar2(255),
   VENDOR_ASSAY_ID varchar2(255),
   VERSION varchar2(255),
   SNP_PANEL_ID number(19,0) not null,
   SNPANNO_ID varchar2(255) not null,
   primary key (ASSAY_ID)
);
create table SNP_ASSOCIATION_ANALYSIS (
   ASSO_ANALYSIS_ID number(19,0) not null,
   ASSO_ANALYSIS_NAME varchar2(255),
   ASSO_ANALYSIS_DESCRIPTION varchar2(255),
   ASSO_ANALYSIS_METHODS varchar2(255),
   primary key (ASSO_ANALYSIS_ID)
);
create table SNP_DIM (
   SNPANNO_ID varchar2(255) not null,
   PHYSICAL_LOCATION number(10,0),
   CHROMOSOME varchar2(255),
   DBSNP_BUILD varchar2(255),
   DBSNPID varchar2(255),
   GENOME_BUILD varchar2(255),
   REFERENCE_SEQUENCE varchar2(255),
   REFERENCE_STRAND varchar2(255),
   primary key (SNPANNO_ID)
);
create table SNP_FREQUENCY_FACT (
   SNP_FREQ_ID number(19,0) not null,
   HARDYWEINBERG_P_VALUE float,
   HETEROZYGOTE_COUNT number(10,0),
   MISSING_ALLELE_COUNT number(10,0),
   MISSSING_GENOTYPE_COUNT number(10,0),
   OTHER_ALLELE varchar2(255),
   OTHER_ALLELE_COUNT number(10,0),
   OTHER_HOMOZYGOTE_COUNT number(10,0),
   REFERENCE_ALLELE varchar2(255),
   REFERENCE_ALLELE_COUNT number(10,0),
   REFERENCE_HOMOZYGOTE_COUNT number(10,0),
   SNPANNO_ID varchar2(255),
   POPULATION_ID number(19,0),
   primary key (SNP_FREQ_ID)
);
create table SNP_PANEL (
   SNP_PANEL_ID number(19,0) not null,
   ASSAY_COUNT number(10,0),
   PANEL_DESCRIPTION varchar2(255),
   SNP_PANEL_NAME varchar2(255),
   TECHNOLOGY varchar2(255),
   VENDOR varchar2(255),
   VENDOR_PANEL_ID varchar2(255),
   VERSION varchar2(255),
   primary key (SNP_PANEL_ID)
);
create table SOMATIC_MUTATION_FINDING (
   PARTICIPANT_DID varchar2(255) not null,
   FINDING_ID number(19,0),
   Base_Number number(10,0),
   Functional_Change varchar2(255),
   Location_By_Codon number(10,0),
   Location_By_Exon number(10,0),
   Location_By_Intron number(10,0),
   Mutant_AminoAcid varchar2(255),
   Mutant_Codon varchar2(255),
   Mutation_Status varchar2(255),
   Mutation_Type varchar2(255),
   NumOf_Codons_Affected number(19,0),
   Size_Of_Mutation varchar2(255),
   Wild_Type_AminoAcid varchar2(255),
   Wild_Type_Codon varchar2(255),
   NCBI_build number(10,0),
   Chromosome number(10,0),
   GENE_BIOMARKER_ID varchar2(255),
   primary key (PARTICIPANT_DID)
);
create table SPECIMEN (
   SPECIMEN_ID varchar2(255) not null,
   SPECIMEN_TYPE varchar2(255),
   COLLECTION_METHOD varchar2(255),
   PARTICIPANT_DID varchar2(255),
   TIMECOURSE_ID number(19,0),
   primary key (SPECIMEN_ID)
);
create table STDPT_ANALYSIS_GRP_AS (
   ANA_GRP_ID number(19,0) not null,
   PARTICIPANT_DID varchar2(255) not null,
   primary key (PARTICIPANT_DID, ANA_GRP_ID)
);
create table STUDY_DIM (
   STUDY_NAME varchar2(255) not null,
   STUDY_DESCRIPTION varchar2(255),
   END_DATE timestamp,
   STUDY_SPONSOR varchar2(255),
   START_DATE timestamp,
   primary key (STUDY_NAME)
);
create table STUDY_PANEL_ASSO (
   STUDY_NAME varchar2(255) not null,
   SNP_PANEL_ID number(19,0) not null,
   primary key (STUDY_NAME, SNP_PANEL_ID)
);
create table STUDY_PARTICIPANT (
   PARTICIPANT_DID varchar2(255) not null,
   CASE_CONTROL_STATUS varchar2(255),
   GENDER varchar2(255),
   DAYS_ON_STUDY number(10,0),
   ETHNIC_GROUP_CODE varchar2(255),
   FAMILY_HISTORY varchar2(255),
   INSTITUTION_NAME varchar2(255),
   DAYS_OFF_STUDY number(10,0),
   RACE_CODE varchar2(255),
   SURVIVAL_STATUS varchar2(255),
   TSP_SPECIMEN_ID varchar2(255),
   OFF_STUDY char(1),
   STUDY_NAME varchar2(255),
   POPULATION_ID number(19,0),
   primary key (PARTICIPANT_DID)
);
create table STUDY_POPULATION (
   POPULATION_ID number(19,0) not null,
   MEMBER_COUNT number(10,0),
   POPULATION_NAME varchar2(255),
   POPULATION_DESC varchar2(255),
   SOURCE varchar2(255),
   primary key (POPULATION_ID)
);
create table STUDY_STDPOPUPLATION_ASSO (
   POPULATION_ID number(19,0) not null,
   STUDY_NAME varchar2(255) not null,
   primary key (STUDY_NAME, POPULATION_ID)
);
create table STUDY_TIMECOURSE_DIM (
   TIMECOURSE_ID number(19,0) not null,
   TIMECOURSE_NAME varchar2(255),
   primary key (TIMECOURSE_ID)
);
create table Somatic_Mutation_Annotation (
   SOMATIC_MUTATION_ID varchar2(255) not null,
   HUGO_SYMBOL varchar2(255),
   SPECIMEN_ID varchar2(255),
   Entrez_Gene_ID varchar2(255),
   Transcript_ID varchar2(255),
   NCBI_build varchar2(255),
   Start_Position varchar2(255),
   End_Position varchar2(255),
   Strand varchar2(255),
   Variant_Classification varchar2(255),
   Variant_Type varchar2(255),
   Refseq_Allele varchar2(255),
   Variant_Size varchar2(255),
   Variant_Allele varchar2(255),
   Codon_Sequence varchar2(255),
   Amino_Acid varchar2(255),
   Transcript_Position varchar2(255),
   Transcript_Region varchar2(255),
   Interpro_Annotation varchar2(255),
   Pfam_Annotation varchar2(255),
   SIFT_Prediction varchar2(255),
   GSC_Conservation_Score varchar2(255),
   UCSC_Conservation_Score varchar2(255),
   primary key (SOMATIC_MUTATION_ID)
);
create table TOBACCO_CONSUMPTION (
   FINDING_ID varchar2(255) not null,
   Smoking_Status char(1),
   Years_Quit number(10,0),
   Pack_Years number(10,0),
   Licotine_Level number(19,0),
   EPIFINDING_ID varchar2(255),
   primary key (FINDING_ID)
);
alter table Activity add constraint FKA126572F33E34BBC foreign key (PATIENT_DID) references STUDY_PARTICIPANT;
alter table Activity add constraint FKA126572F4C628067 foreign key (TIMECOURSE_ID) references STUDY_TIMECOURSE_DIM;
alter table ClinicalFinding add constraint FKAB8FD8D646B388EA foreign key (PARTICIPANT_DID) references STUDY_PARTICIPANT;
alter table ClinicalFinding add constraint FKAB8FD8D64C628067 foreign key (TIMECOURSE_ID) references STUDY_TIMECOURSE_DIM;
alter table DNA_SPECIMEN add constraint FK246E41506ED3C787 foreign key (SPECIMEN_ID) references SPECIMEN;
alter table GENE_SNP_ASSO add constraint FKCE1C58A2B475F329 foreign key (SNPANNO_ID) references SNP_DIM;
alter table GENE_SNP_ASSO add constraint FKCE1C58A216D3B9FA foreign key (GENE_ID) references GENE_DIM;
alter table GENOTYPE_FACT add constraint FKC05A3412B475F329 foreign key (SNPANNO_ID) references SNP_DIM;
alter table GENOTYPE_FACT add constraint FKC05A3412BB7BEA77 foreign key (ASSAY_ID) references SNP_ASSAY;
alter table GENOTYPE_FACT add constraint FKC05A34126ED3C787 foreign key (SPECIMEN_ID) references SPECIMEN;
alter table GENOTYPE_FACT add constraint FKC05A3412E7EF915D foreign key (STUDY_NAME) references STUDY_DIM;
alter table SNP_ANALYSIS_FINDING_FACT add constraint FK3FA40A9BB475F329 foreign key (SNPANNO_ID) references SNP_DIM;
alter table SNP_ANALYSIS_FINDING_FACT add constraint FK3FA40A9B146A6274 foreign key (ASSO_ANALYSIS_ID) references SNP_ASSOCIATION_ANALYSIS;
alter table SNP_ANALYSIS_GROUP add constraint FKBE0AA766146A6274 foreign key (ASSO_ANALYSIS_ID) references SNP_ASSOCIATION_ANALYSIS;
alter table SNP_ASSAY add constraint FKE69582EFB475F329 foreign key (SNPANNO_ID) references SNP_DIM;
alter table SNP_ASSAY add constraint FKE69582EF668B8221 foreign key (SNP_PANEL_ID) references SNP_PANEL;
alter table SNP_FREQUENCY_FACT add constraint FKABD78FB9B475F329 foreign key (SNPANNO_ID) references SNP_DIM;
alter table SNP_FREQUENCY_FACT add constraint FKABD78FB97B13A627 foreign key (POPULATION_ID) references STUDY_POPULATION;
alter table SOMATIC_MUTATION_FINDING add constraint FKB511747481E4D797 foreign key (GENE_BIOMARKER_ID) references GENE_DIM;
alter table SPECIMEN add constraint FKAF84F30846B388EA foreign key (PARTICIPANT_DID) references STUDY_PARTICIPANT;
alter table SPECIMEN add constraint FKAF84F3084C628067 foreign key (TIMECOURSE_ID) references STUDY_TIMECOURSE_DIM;
alter table STDPT_ANALYSIS_GRP_AS add constraint FKD8CC4FB746B388EA foreign key (PARTICIPANT_DID) references STUDY_PARTICIPANT;
alter table STDPT_ANALYSIS_GRP_AS add constraint FKD8CC4FB7C0A5F34D foreign key (ANA_GRP_ID) references SNP_ANALYSIS_GROUP;
alter table STUDY_DIM add constraint FK31A050D2E7EF915D foreign key (STUDY_NAME) references STUDY_DIM;
alter table STUDY_PANEL_ASSO add constraint FK51634FDF668B8221 foreign key (SNP_PANEL_ID) references SNP_PANEL;
alter table STUDY_PANEL_ASSO add constraint FK51634FDFE7EF915D foreign key (STUDY_NAME) references STUDY_DIM;
alter table STUDY_PARTICIPANT add constraint FK743EC17D7B13A627 foreign key (POPULATION_ID) references STUDY_POPULATION;
alter table STUDY_PARTICIPANT add constraint FK743EC17DE7EF915D foreign key (STUDY_NAME) references STUDY_DIM;
alter table STUDY_STDPOPUPLATION_ASSO add constraint FK9FF3DAE57B13A627 foreign key (POPULATION_ID) references STUDY_POPULATION;
alter table STUDY_STDPOPUPLATION_ASSO add constraint FK9FF3DAE5E7EF915D foreign key (STUDY_NAME) references STUDY_DIM;
alter table TOBACCO_CONSUMPTION add constraint FK9B5AE7F1C93130A6 foreign key (EPIFINDING_ID) references STUDY_PARTICIPANT;
