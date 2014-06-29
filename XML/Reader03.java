import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Reader03 {

	public static void main(String argv[]) {

	   try {
		String filepath = "masCSESyllabus.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);


		Element docEle = doc.getDocumentElement();

		System.out.println("Root element of the document: "
		                        + docEle.getNodeName());

		NodeList studentList = docEle.getElementsByTagName("Course");

		System.out.println("Total students: " + studentList.getLength());

		if (studentList != null && studentList.getLength() > 0) {
		    for (int i = 0; i < studentList.getLength(); i++) {

				Node node = studentList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

				                            System.out
				                                    .println("=====================");

				                            Element e = (Element) node;
				                            //NodeList list = e.getElementsByTagName("Course");
				                            NodeList list = node.getChildNodes();

				                            for (int i1 = 2; i1 < list.getLength(); i1++) {

											                   Node node1 = list.item(i1);

											                   //if("sdf".equals(node1.getTextContent()))

													   // get the salary element, and update the value
													   //System.out.println(node.getNodeName());
													  { System.out.println(node1.getTextContent());}



													}






		                      }
		                    }
		                } else {
		                    System.exit(1);
		                }


		// write the content into xml file

		//System.out.println("Done");

	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
	}
}