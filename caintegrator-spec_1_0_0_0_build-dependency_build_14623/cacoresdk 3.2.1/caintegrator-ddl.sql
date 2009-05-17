
    drop table AGENT_DIM cascade constraints;

    drop table COPY_NUMBER_FINDING cascade constraints;

    drop table ClinicalFinding cascade constraints;

    drop table DIFF_FOLD_CHANGE_FINDING cascade constraints;

    drop table DNA_SPECIMEN cascade constraints;

    drop table GENE_ALIAS cascade constraints;

    drop table GENE_DIM cascade constraints;

    drop table GENE_SNP_ASSO cascade constraints;

    drop table GENOTYPE_FACT cascade constraints;

    drop table HISTOLOGY cascade constraints;

    drop table ODDS_RATIO cascade constraints;

    drop table PROBESET_ALIGNMENTS cascade constraints;

    drop table PROBESET_DIM cascade constraints;

    drop table PROBESET_GENE_ASSO cascade constraints;

    drop table SNP_ANALYSIS_FINDING_FACT cascade constraints;

    drop table SNP_ANALYSIS_GROUP cascade constraints;

    drop table SNP_ASSAY cascade constraints;

    drop table SNP_ASSOCIATION_ANALYSIS cascade constraints;

    drop table SNP_DIM cascade constraints;

    drop table SNP_FREQUENCY_FACT cascade constraints;

    drop table SNP_PANEL cascade constraints;

    drop table SPECIMEN cascade constraints;

    drop table STDPT_ANALYSIS_GRP_AS cascade constraints;

    drop table STD_PARTICIPANT_POPULATION_AS cascade constraints;

    drop table STUDY_DIM cascade constraints;

    drop table STUDY_PANEL_ASSO cascade constraints;

    drop table STUDY_PARTICIPANT cascade constraints;

    drop table STUDY_POPULATION cascade constraints;

    drop table STUDY_PROC_ADMIN cascade constraints;

    drop table STUDY_STDPOPUPLATION_ASSO cascade constraints;

    drop table STUDY_SUBSTANCE_ADMIN cascade constraints;

    drop table STUDY_SURGERY_ADMIN cascade constraints;

    drop table STUDY_TIMECOURSE_DIM cascade constraints;

    drop table hibernate_unique_key cascade constraints;

    create table AGENT_DIM (
        AGENT_ID number(19,0) not null,
        AGENT_DESC varchar2(255),
        AGENT_NAME varchar2(255),
        AGENT_TYPE varchar2(255),
        primary key (AGENT_ID)
    );

    create table COPY_NUMBER_FINDING (
        COPY_NUMBER_ID number(19,0) not null,
        ABNORMALITY_STATUS varchar2(255),
        ARRAY_TYPE varchar2(255),
        CALL varchar2(255),
        COPY_NUMBER double precision,
        COPYNO_PVAL double precision,
        SNPANNO_ID number(19,0),
        SPECIMEN_ID number(19,0),
        primary key (COPY_NUMBER_ID)
    );

    create table ClinicalFinding (
        CLINICAL_FINDING_ID number(19,0) not null,
        PARTICIPANT_ID number(19,0),
        primary key (CLINICAL_FINDING_ID)
    );

    create table DIFF_FOLD_CHANGE_FINDING (
        DIFF_FOLD_CHANGE_ID number(19,0) not null,
        ARRAY_TYPE varchar2(255),
        NORMAL_INTENSITY double precision,
        RATIO double precision,
        TUMOR_INTENSITY double precision,
        REPORTER_ID number(19,0),
        SPECIMEN_ID number(19,0),
        primary key (DIFF_FOLD_CHANGE_ID)
    );

    create table DNA_SPECIMEN (
        SPECIMEN_ID number(19,0) not null,
        DNA_AMPLICATION_METHOD varchar2(255),
        DNA_EXTRACTION_METHOD varchar2(255),
        DNA_MATERIAL_TYPE varchar2(255),
        primary key (SPECIMEN_ID)
    );

    create table GENE_ALIAS (
        ALIAS_ID number(19,0) not null,
        ALIAS varchar2(255),
        GENE_SYMBOL varchar2(255),
        GENE_ID number(19,0),
        primary key (ALIAS_ID)
    );

    create table GENE_DIM (
        GENE_DIM_ID number(19,0) not null,
        CHROMOSOME varchar2(255),
        FEATURE_NAME varchar2(255),
        CHROMOSOME_START number(19,0),
        CHROMOSOME_END number(19,0),
        GENE_ID varchar2(255),
        primary key (GENE_DIM_ID)
    );

    create table GENE_SNP_ASSO (
        SNPANNO_ID number(19,0) not null,
        GENE_ID number(19,0) not null,
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
        SNPANNO_ID number(19,0),
        STUDY_ID number(19,0) not null,
        primary key (GS_ID)
    );

    create table HISTOLOGY (
        HISTOLOGY_ID number(19,0) not null,
        INVASIVE_PRESENTATION varchar2(255),
        COMMENTS varchar2(255),
        DIAGNOSIS_NAME varchar2(255),
        GRADE varchar2(255),
        STAGE varchar2(255),
        TYPE varchar2(255),
        PARTICIPANT_ID number(19,0),
        primary key (HISTOLOGY_ID)
    );

    create table ODDS_RATIO (
        ODDS_RATIO_ID number(19,0) not null,
        HOMOZYGOTE double precision,
        ODDS_RATIO_NAME varchar2(255),
        HETEROZYGOTE double precision,
        ASSO_ANA_FACT_ID number(19,0) not null,
        primary key (ODDS_RATIO_ID)
    );

    create table PROBESET_ALIGNMENTS (
        PROBESET_ALIGNMENTS_ID number(19,0) not null,
        CHROMOSOME varchar2(255),
        START_POSITION number(19,0),
        END_POSITION number(19,0),
        primary key (PROBESET_ALIGNMENTS_ID)
    );

    create table PROBESET_DIM (
        REPORTER_ID number(19,0) not null,
        PROBE_SET_ID varchar2(255),
        GENECHIP_ARRAY varchar2(255),
        primary key (REPORTER_ID)
    );

    create table PROBESET_GENE_ASSO (
        GENE_DIM_ID number(19,0) not null,
        REPORTER_ID number(19,0) not null,
        primary key (GENE_DIM_ID, REPORTER_ID)
    );

    create table SNP_ANALYSIS_FINDING_FACT (
        ASSO_ANA_FACT_ID number(19,0) not null,
        ASSO_ANA_PVALUE float,
        ASSO_ANA_RANK number(10,0),
        SNPANNO_ID number(19,0),
        ASSO_ANALYSIS_ID number(19,0),
        STUDY_ID number(19,0) not null,
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
        SNPANNO_ID number(19,0) not null,
        primary key (SNPANNO_ID, SNP_PANEL_ID)
    );

    create table SNP_ASSOCIATION_ANALYSIS (
        ASSO_ANALYSIS_ID number(19,0) not null,
        ASSO_ANALYSIS_NAME varchar2(255),
        ASSO_ANALYSIS_DESCRIPTION varchar2(255),
        ASSO_ANALYSIS_METHODS varchar2(255),
        ASSO_ANALYSIS_CODE varchar2(255),
        STUDY_ID number(19,0) not null,
        primary key (ASSO_ANALYSIS_ID)
    );

    create table SNP_DIM (
        SNPANNO_ID number(19,0) not null,
        PHYSICAL_LOCATION number(10,0),
        CHROMOSOME varchar2(255),
        DBSNP_BUILD varchar2(255),
        DBSNPID varchar2(255),
        GENOME_BUILD varchar2(255),
        SECONDARY_ID varchar2(255),
        REPORTER_NAME varchar2(255),
        REPORTER_PLATFORM varchar2(255),
        REPORTER_TYPE varchar2(255),
        primary key (SNPANNO_ID)
    );

    create table SNP_FREQUENCY_FACT (
        SNP_FREQ_ID number(19,0) not null,
        COMPLETION_RATE float,
        HARDYWEINBERG_P_VALUE float,
        HETEROZYGOTE_COUNT number(10,0),
        MINOR_ALLELE_FREQ float,
        MISSING_ALLELE_COUNT number(10,0),
        MISSSING_GENOTYPE_COUNT number(10,0),
        OTHER_ALLELE varchar2(255),
        OTHER_ALLELE_COUNT number(10,0),
        OTHER_HOMOZYGOTE_COUNT number(10,0),
        REFERENCE_ALLELE varchar2(255),
        REFERENCE_ALLELE_COUNT number(10,0),
        REFERENCE_HOMOZYGOTE_COUNT number(10,0),
        SNPANNO_ID number(19,0),
        POPULATION_ID number(19,0),
        STUDY_ID number(19,0) not null,
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

    create table SPECIMEN (
        SPECIMEN_ID number(19,0) not null,
        SPECIMEN_TYPE varchar2(255),
        SPECIMEN_ID_C varchar2(255),
        COLLECTION_METHOD varchar2(255),
        PARTICIPANT_ID number(19,0),
        primary key (SPECIMEN_ID)
    );

    create table STDPT_ANALYSIS_GRP_AS (
        ANA_GRP_ID number(19,0) not null,
        PARTICIPANT_ID number(19,0) not null,
        primary key (PARTICIPANT_ID, ANA_GRP_ID)
    );

    create table STD_PARTICIPANT_POPULATION_AS (
        POPULATION_ID number(19,0) not null,
        PARTICIPANT_ID number(19,0) not null,
        primary key (PARTICIPANT_ID, POPULATION_ID)
    );

    create table STUDY_DIM (
        STUDY_ID number(19,0) not null,
        STUDY_DESCRIPTION varchar2(255),
        END_DATE date,
        STUDY_NAME varchar2(255),
        STUDY_SPONSOR varchar2(255),
        START_DATE date,
        VERSION_CODE varchar2(255),
        primary key (STUDY_ID)
    );

    create table STUDY_PANEL_ASSO (
        STUDY_ID number(19,0) not null,
        SNP_PANEL_ID number(19,0) not null,
        primary key (STUDY_ID, SNP_PANEL_ID)
    );

    create table STUDY_PARTICIPANT (
        PARTICIPANT_ID number(19,0) not null,
        CASE_CONTROL_STATUS varchar2(255),
        GENDER varchar2(255),
        AGE_AT_DIAGNOSIS double precision,
        AGE_AT_DIAGNOSIS_MIN double precision,
        AGE_AT_DIAGNOSIS_MAX double precision,
        AGE_AT_DEATH double precision,
        AGE_AT_DEATH_MIN double precision,
        AGE_AT_DEATH_MAX double precision,
        AGE_AT_ENROLL double precision,
        AGE_AT_ENROLL_MIN double precision,
        AGE_AT_ENROLL_MAX double precision,
        DAYS_ON_STUDY number(10,0),
        ETHNIC_GROUP_CODE varchar2(255),
        FAMILY_HISTORY varchar2(255),
        INSTITUTION_NAME varchar2(255),
        DAYS_OFF_STUDY number(10,0),
        RACE_CODE varchar2(255),
        SURVIVAL_STATUS varchar2(255),
        OFF_STUDY char(1),
        STUDY_ID number(19,0),
        primary key (PARTICIPANT_ID)
    );

    create table STUDY_POPULATION (
        POPULATION_ID number(19,0) not null,
        MEMBER_COUNT number(10,0),
        POPULATION_NAME varchar2(255),
        POPULATION_DESC varchar2(255),
        SOURCE varchar2(255),
        primary key (POPULATION_ID)
    );

    create table STUDY_PROC_ADMIN (
        ADMIN_ID number(19,0) not null,
        ACTIVITY_DESC varchar2(255),
        ACTIVITY_NAME varchar2(255),
        DAYS_START number(19,0),
        DAYS_STOP number(19,0),
        STATUS varchar2(255),
        PARTICIPANT_ID number(19,0),
        TIMECOURSE_ID number(19,0),
        PATIENT_DID number(19,0),
        PROC_SITE varchar2(255),
        PROC_NAME varchar2(255),
        PROC_TYPE varchar2(255),
        primary key (ADMIN_ID)
    );

    create table STUDY_STDPOPUPLATION_ASSO (
        POPULATION_ID number(19,0) not null,
        STUDY_ID number(19,0) not null,
        primary key (STUDY_ID, POPULATION_ID)
    );

    create table STUDY_SUBSTANCE_ADMIN (
        ADMIN_ID number(19,0) not null,
        ACTIVITY_DESC varchar2(255),
        ACTIVITY_NAME varchar2(255),
        DAYS_START number(19,0),
        DAYS_STOP number(19,0),
        STATUS varchar2(255),
        PARTICIPANT_ID number(19,0),
        TIMECOURSE_ID number(19,0),
        PATIENT_DID number(19,0),
        DOSE_UNIT varchar2(255),
        TOTAL_DOSE number(19,0),
        AGENT_ID number(19,0),
        primary key (ADMIN_ID)
    );

    create table STUDY_SURGERY_ADMIN (
        ADMIN_ID number(19,0) not null,
        ACTIVITY_DESC varchar2(255),
        ACTIVITY_NAME varchar2(255),
        DAYS_START number(19,0),
        DAYS_STOP number(19,0),
        STATUS varchar2(255),
        PARTICIPANT_ID number(19,0),
        TIMECOURSE_ID number(19,0),
        PATIENT_DID number(19,0),
        PROC_SITE varchar2(255),
        PROC_NAME varchar2(255),
        PROC_TYPE varchar2(255),
        OUTCOME varchar2(255),
        primary key (ADMIN_ID)
    );

    create table STUDY_TIMECOURSE_DIM (
        TIMECOURSE_ID number(19,0) not null,
        TIMECOURSE_NAME varchar2(255),
        primary key (TIMECOURSE_ID)
    );

    alter table COPY_NUMBER_FINDING 
        add constraint FK685927DE04AB25F 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table COPY_NUMBER_FINDING 
        add constraint FK685927D31128D4B 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table ClinicalFinding 
        add constraint FKAB8FD8D6F078CAE2 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table DIFF_FOLD_CHANGE_FINDING 
        add constraint FK22364A9EA8FBD62A 
        foreign key (REPORTER_ID) 
        references PROBESET_DIM;

    alter table DIFF_FOLD_CHANGE_FINDING 
        add constraint FK22364A9E31128D4B 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table DNA_SPECIMEN 
        add constraint FK246E415031128D4B 
        foreign key (SPECIMEN_ID) 
        references SPECIMEN;

    alter table GENE_ALIAS 
        add constraint FK454DF08679E004AC 
        foreign key (GENE_ID) 
        references GENE_DIM;

    alter table GENE_SNP_ASSO 
        add constraint FKCE1C58A2E04AB25F 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table GENE_SNP_ASSO 
        add constraint FKCE1C58A21C0C26CF 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table GENE_SNP_ASSO 
        add constraint FKCE1C58A279E004AC 
        foreign key (GENE_ID) 
        references GENE_DIM;

    alter table GENOTYPE_FACT 
        add constraint FKC05A34121C0C26CF 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table GENOTYPE_FACT 
        add constraint FKC05A34128B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table HISTOLOGY 
        add constraint FKCEE4CA2F078CAE2 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table ODDS_RATIO 
        add constraint FK2A0B4110AF9D3D50 
        foreign key (ASSO_ANA_FACT_ID) 
        references SNP_ANALYSIS_FINDING_FACT;

    alter table PROBESET_GENE_ASSO 
        add constraint FK8CEE23ABA8FBD62A 
        foreign key (REPORTER_ID) 
        references PROBESET_DIM;

    alter table PROBESET_GENE_ASSO 
        add constraint FK8CEE23ABCAF272C3 
        foreign key (GENE_DIM_ID) 
        references GENE_DIM;

    alter table SNP_ANALYSIS_FINDING_FACT 
        add constraint FK3FA40A9BA350F414 
        foreign key (ASSO_ANALYSIS_ID) 
        references SNP_ASSOCIATION_ANALYSIS;

    alter table SNP_ANALYSIS_FINDING_FACT 
        add constraint FK3FA40A9B1C0C26CF 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table SNP_ANALYSIS_FINDING_FACT 
        add constraint FK3FA40A9B8B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table SNP_ANALYSIS_GROUP 
        add constraint FKBE0AA766A350F414 
        foreign key (ASSO_ANALYSIS_ID) 
        references SNP_ASSOCIATION_ANALYSIS;

    alter table SNP_ASSAY 
        add constraint FKE69582EF26E11EBB 
        foreign key (SNP_PANEL_ID) 
        references SNP_PANEL;

    alter table SNP_ASSAY 
        add constraint FKE69582EF1C0C26CF 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table SNP_ASSOCIATION_ANALYSIS 
        add constraint FKF2DC31A48B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table SNP_FREQUENCY_FACT 
        add constraint FKABD78FB9A8B80AEB 
        foreign key (POPULATION_ID) 
        references STUDY_POPULATION;

    alter table SNP_FREQUENCY_FACT 
        add constraint FKABD78FB91C0C26CF 
        foreign key (SNPANNO_ID) 
        references SNP_DIM;

    alter table SNP_FREQUENCY_FACT 
        add constraint FKABD78FB98B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table SPECIMEN 
        add constraint FKAF84F308F078CAE2 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table STDPT_ANALYSIS_GRP_AS 
        add constraint FKD8CC4FB7DDC23CED 
        foreign key (ANA_GRP_ID) 
        references SNP_ANALYSIS_GROUP;

    alter table STDPT_ANALYSIS_GRP_AS 
        add constraint FKD8CC4FB7F078CAE2 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table STD_PARTICIPANT_POPULATION_AS 
        add constraint FK20A9F2FCA8B80AEB 
        foreign key (POPULATION_ID) 
        references STUDY_POPULATION;

    alter table STD_PARTICIPANT_POPULATION_AS 
        add constraint FK20A9F2FCF078CAE2 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_DIM 
        add constraint FK31A050D28B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table STUDY_PANEL_ASSO 
        add constraint FK51634FDF26E11EBB 
        foreign key (SNP_PANEL_ID) 
        references SNP_PANEL;

    alter table STUDY_PANEL_ASSO 
        add constraint FK51634FDF8B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table STUDY_PARTICIPANT 
        add constraint FK743EC17D8B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table STUDY_PROC_ADMIN 
        add constraint FKA126572F5F20D8046c9fd5c 
        foreign key (PATIENT_DID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_PROC_ADMIN 
        add constraint FKA126572F7A06E52B46c9fd5c 
        foreign key (TIMECOURSE_ID) 
        references STUDY_TIMECOURSE_DIM;

    alter table STUDY_PROC_ADMIN 
        add constraint FKA126572FF078CAE246c9fd5c 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_STDPOPUPLATION_ASSO 
        add constraint FK9FF3DAE5A8B80AEB 
        foreign key (POPULATION_ID) 
        references STUDY_POPULATION;

    alter table STUDY_STDPOPUPLATION_ASSO 
        add constraint FK9FF3DAE58B218A29 
        foreign key (STUDY_ID) 
        references STUDY_DIM;

    alter table STUDY_SUBSTANCE_ADMIN 
        add constraint FK9AB300EA71D4B0A9 
        foreign key (AGENT_ID) 
        references AGENT_DIM;

    alter table STUDY_SUBSTANCE_ADMIN 
        add constraint FKA126572F5F20D809ab300ea 
        foreign key (PATIENT_DID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_SUBSTANCE_ADMIN 
        add constraint FKA126572F7A06E52B9ab300ea 
        foreign key (TIMECOURSE_ID) 
        references STUDY_TIMECOURSE_DIM;

    alter table STUDY_SUBSTANCE_ADMIN 
        add constraint FKA126572FF078CAE29ab300ea 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_SURGERY_ADMIN 
        add constraint FKA126572F5F20D8046c9fd5c8a5b442f 
        foreign key (PATIENT_DID) 
        references STUDY_PARTICIPANT;

    alter table STUDY_SURGERY_ADMIN 
        add constraint FKA126572F7A06E52B46c9fd5c8a5b442f 
        foreign key (TIMECOURSE_ID) 
        references STUDY_TIMECOURSE_DIM;

    alter table STUDY_SURGERY_ADMIN 
        add constraint FKA126572FF078CAE246c9fd5c8a5b442f 
        foreign key (PARTICIPANT_ID) 
        references STUDY_PARTICIPANT;

    create table hibernate_unique_key (
         next_hi number(10,0) 
    );

    insert into hibernate_unique_key values ( 0 );
