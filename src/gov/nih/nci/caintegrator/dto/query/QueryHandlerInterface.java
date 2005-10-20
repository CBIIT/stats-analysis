package gov.nih.nci.caintegrator.dto.query;


public interface QueryHandlerInterface {

	public ResultSetInterface[] handle(Query query) throws Exception ;

}