package com.thenoiseteam.filedemo.controller;

import com.thenoiseteam.filedemo.payload.Data;
import com.thenoiseteam.filedemo.service.XMLParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private XMLParserService xmlParserService;

    @PostMapping("/upload")
    public ResponseEntity<List<Data>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException, ParserConfigurationException, SAXException, SQLException {

        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file);
        file.transferTo(convFile);

        List<Data> datas = xmlParserService.ParseXML(convFile);

        int id = 0;
        String name = null, value = null;

        for( Data data : datas ) {
            id = data.getId();
            name = data.getName();
            value = data.getValue();
        }

        if( datas.size() > 0 ) {
            return ResponseEntity.ok(datas);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
