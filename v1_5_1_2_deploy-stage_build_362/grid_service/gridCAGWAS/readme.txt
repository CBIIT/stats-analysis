To build and run the CAGWAS_GridClient.java file.
1. Set ant to your path variable
2. Unzip gridCAGWAS.zip in a new directory such as c:/cagwas-grid-client
3. You will need tp pass the URL & port of your caGRID service such as an argument
http://cbiovdev5024.nci.nih.gov:59180/wsrf/services/cagrid/CAGWAS
5. Run ant from the unzipped directory as follows
ant -Dservice.url=<caGRID Service URL>
for example:
ant -Dservice.url=http://cbiovdev5024.nci.nih.gov:59180/wsrf/services/cagrid/CAGWAS

Note to change the testcases and associated IDs, please modify the testcases properties file under /conf folder