package com.thenoiseteam.filedemo;

import com.thenoiseteam.filedemo.payload.Data;
import com.thenoiseteam.filedemo.property.FileStorageProperties;
import com.thenoiseteam.filedemo.service.DatabaseService;
import com.thenoiseteam.filedemo.service.XMLParserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FileDemoApplication {

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, SQLException {
		SpringApplication.run(FileDemoApplication.class, args);
	}

}
