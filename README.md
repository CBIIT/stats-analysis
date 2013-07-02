Welcome to the Stats Analysis Project!
=====================================

The purpose of this API Service Layer to allow programmatic and logical access to the underlying Data Mart via the clinical genomic domain objects.  The API is organized by three separate services; each compliments the other to provide a full suite of tools that allows researchers and bioinformatics developers to analyze, search and retrieve clinical genomic data.

* Object Query Service
  
  The Object Query Service allows the API users to initiate search from any object within the CG-OM and retrieve the query results in the form of a domain object graph.  caIntegator leverages the caCORE SDK tool kit to implement the Object Query Service.
  
* Study Query Service

  The Study Query Service allows the API users to initiate search from a Criteria Data Transfer Object (DTO) and retrieve the query results in the form of a clinical genomic domain object graph or a Report DTO. 

* Analytical Query Service

  The Analytical Query Service allows the API users to perform run time analysis of clinical genomic data that currently supports class comparison analysis, principle component analysis and hieratical analysis.  It is designed to easily incorporate other types of analysis in the future and scale to provide performance.

The Stats Analysis is an Open Source project and it is written in Java using caCORE SDK, caCORE CSM, Hibernate, Spring Framework Technologies.

The Stats Analysis is distributed under the BSD 3-Clause License.
Please see the NOTICE and LICENSE files for details.

You will find more details about the Stats Analysis in the following links:
 * [Code Repository] (https://github.com/NCIP/stats-analysis)
 
Please join us in further developing and improving Stats Analysis project.
