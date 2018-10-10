import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.StringWriter;

public class JenaSparqlExecution {
    public void query(String rdf, String format, String queryString){
        Model rdfModel = ModelFactory.createDefaultModel();
        rdfModel.read(new ByteArrayInputStream(rdf.getBytes()), null, format);
        Query query = QueryFactory.create(queryString);
        QueryExecution execution = QueryExecutionFactory.create(query, rdfModel);
        ResultSet resultSet = execution.execSelect();
        OutputStream outputStream;
        ResultSetFormatter.outputAsJSON(resultSet);

    }

}
