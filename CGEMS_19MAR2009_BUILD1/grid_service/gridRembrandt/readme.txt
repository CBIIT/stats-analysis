To build and run the GridServiceClient.java file.
1. Set ant to your path variable
2. Unzip gridRembrandt.zip in a new directory such as c:/rembrandt-grid-client
3. You will need to pass the URL & port of your caGRID service  as the argument
http://cbiovdev5024.nci.nih.gov:59180/wsrf-rembrandt/services/cagrid/RembrandtGridService
4. Run ant from the unzipped directory as follows
ant -Dservice.url=<caGRID Service URL>
for example:
ant -Dservice.url=http://cbiovdev5024.nci.nih.gov:59180/wsrf-rembrandt/services/cagrid/RembrandtGridService

Note to change the testcases and associated IDs, please modify the testcases properties file under /conf folder