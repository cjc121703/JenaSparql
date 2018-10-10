import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

public class JenaSparqlConversionTest {
    @Test
    public void testQuery(){
        String data = getFile("shapesui.ttl");
        JenaSparqlExecution execution = new JenaSparqlExecution();
        execution.query(data, "TTL", "select * where {?s ?p ?o.  ?s <http://www.w3.org/2000/01/rdf-schema#isDefinedBy> <http://ecp.thomsonreuters.com/shapes/registryUI>. }");
    }

    private String getFile(String fileName){
        String result = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try
        {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName), Charset.defaultCharset());
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
