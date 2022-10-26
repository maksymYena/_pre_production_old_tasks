package com.epam.maksym_yena.java.lesson_15.task_9;

import java.io.*;
import java.net.*;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Runner {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        SAXParserFactory spf = SAXParserFactory.newDefaultInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        Handler myHandler = new Handler();
        xmlReader.setContentHandler(myHandler);
        xmlReader.parse(getResponce());
        Report report = myHandler.getReport();

        System.out.println("Report: " + report.ticketsList);

        report.ticketsList.forEach(System.out::println);

        List<Ticket> tickets = report.ticketsList;

        EditCollection.checkCollection(tickets);

        postRequest();

    }

    public static String getResponce() throws IOException {

        String url = "http://bookingticket-env.eba-tewwtmmp.eu-central-1.elasticbeanstalk.com/BookingTicket/getAvailableTicket.xml";
        String filename = "tickets.xml";

        URL obj = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;

        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(response + "\n");
        }
        return filename;
    }

    public static void postRequest() throws IOException {

        HttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost("http://bookingticket-env.eba-tewwtmmp.eu-central-1.elasticbeanstalk.com/BookingTicket/bookTicket.json?userId=1");
       /*
        HttpPost post = new HttpPost("http://bookingticket-env.eba-tewwtmmp.eu-central-1.elasticbeanstalk.com/BookingTicket/unbookTicket.json?userId=1");
       */
        post.addHeader("Content-type", "application/json;charset=UTF-8");


        StringEntity params = new StringEntity("[\"10\",\"12\",\"13\"]");

        post.setEntity(params);

        HttpResponse response = client.execute(post);

        HttpEntity entity = response.getEntity();

        System.out.println(response.getStatusLine());

        System.out.println(EntityUtils.toString(entity));
    }
}




