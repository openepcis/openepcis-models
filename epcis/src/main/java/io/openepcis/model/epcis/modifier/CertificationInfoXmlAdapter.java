package io.openepcis.model.epcis.modifier;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used during the Unmarshalling (XML -> Object) and Marshalling (Object -> XML) for the "CertificationInfo" field during the XML reading/writing. certificationInfo can be String or List<String> hence based on the value handle accordingly. Ex:
 * "certificationInfo": "https://example.com/certificate/1" or "certificationInfo": [ ""certificationInfo": "https://example.com/certificate/1", "https://example.com/certificate/1"]
 */
public class CertificationInfoXmlAdapter extends XmlAdapter<Object, Object> {

    //Store the certificationInfo within list accordingly return String or List
    final List<String> list = new ArrayList<>();

    //During the reading of XML handle either simple String or List<String> and assign to certificationInfo field
    @Override
    public Object unmarshal(Object v) {
        if (v instanceof Element element) {
            final NodeList childNodes = element.getChildNodes();

            // If there's only one text node, it's a single String
            if (childNodes.getLength() == 1 && childNodes.item(0).getNodeType() == Node.TEXT_NODE) {
                list.add(childNodes.item(0).getNodeValue());
            }

            //Todo we may need to support the complete list in EPCIS 2.1 instead of just 1 element in XML as per EPCIS 2.0
            /*
            // If there are multiple child nodes, treat it as a list
            for (int c = 0; c < childNodes.getLength(); c++) {
                final NodeList nodes = childNodes.item(c).getChildNodes();

                for (int n = 0; n < nodes.getLength(); n++) {
                    if (nodes.item(n).getNodeType() == Node.TEXT_NODE) {
                        list.add(nodes.item(n).getNodeValue());
                    }
                }
            }
            */

            return list.isEmpty() ? null : list.size() == 1 ? list.get(0) : list;
        }
        return null;
    }

    //During the writing of XML handle either simple String or List<String> and write certificationInfo field
    @Override
    public Object marshal(Object v) throws Exception {
        final Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        if (v instanceof String) {
            final Element root = document.createElement("certificationInfo");
            root.setTextContent((String) v);
            return root;
        } else if (v instanceof List) {
            final List<String> infoList = (List<String>) v;

            //If there are List<String> then append only the 1st element for EPCIS 2.0
            final Element element = document.createElement("certificationInfo");
            element.setTextContent(infoList.get(0));
            return element;

            //Todo we may need to support the complete list in EPCIS 2.1 instead of just 1 element in XML as per EPCIS 2.0
            /*
             final Element root = document.createElement("certificationInfo");
            for (final String item : infoList) {
                final Element element = document.createElement("certificationInfo");
                element.setTextContent(item);
                root.appendChild(element);
            }*/
        }
        return null;
    }
}