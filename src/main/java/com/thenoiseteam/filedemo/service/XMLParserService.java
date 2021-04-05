package com.thenoiseteam.filedemo.service;

import com.thenoiseteam.filedemo.payload.Data;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLParserService {

    public List<Data> ParseXML(File file) throws IOException, SAXException, ParserConfigurationException, SQLException {

        DatabaseService databaseService = new DatabaseService();

        List<Data> datas = new ArrayList<Data>();
        Data data = null;

        int id;
        String name, value;
        String TABLE = "datas";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(String.valueOf(file)));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("data");
        for(int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                data = new Data();
                data.setId(Integer.parseInt(eElement.getElementsByTagName("uniqueID").item(0).getTextContent()));
                data.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                data.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());

                id = data.getId();
                name = data.getName();
                value = data.getValue();

                if(databaseService.countDatabaseResults(TABLE, id) == 0) {
                    databaseService.InsertIntoDatabase(TABLE, id, name, value);
                } else {
                    databaseService.updateDatabase(TABLE, id, name, value);
                }

                datas.add(data);

            }
        }
        return datas;
    }
}
