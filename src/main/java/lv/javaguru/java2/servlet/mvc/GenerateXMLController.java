package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.Customer;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by Svetlana Titova on 25.09.2016.
 */

@Controller
public class GenerateXMLController {

    private void generateNewXMLFile(HttpServletRequest request) {
        List<Customer> myList = (List<Customer>) request.getAttribute("model");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = builder.newDocument();
        Element results = doc.createElement("Results");
        doc.appendChild(results);

          for (int i = 0; i < myList.size(); i++) {

              Element row = doc.createElement("Row");
              results.appendChild(row);
              Element node = doc.createElement("customer_id");
              node.appendChild(doc.createTextNode(myList.get(i).getCustomer_id().toString()));
              row.appendChild(node);

              System.out.println("iteration "+i);
          }
          DOMSource domSource = new DOMSource(doc);
          TransformerFactory tf = TransformerFactory.newInstance();
          Transformer transformer = null;
          try {
              transformer = tf.newTransformer();
          } catch (TransformerConfigurationException e) {
              e.printStackTrace();
          }
          transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
          transformer.setOutputProperty(OutputKeys.METHOD, "xml");
          transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
          StringWriter sw = new StringWriter();
          StreamResult sr = new StreamResult(sw);
          try {
              transformer.transform(domSource, sr);
          } catch (TransformerException e) {
              e.printStackTrace();
          }

          System.out.println(sw.toString());

      }
}