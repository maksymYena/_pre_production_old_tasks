package com.epam.maksym_yena.java.lesson_15.task_9;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import java.util.ArrayList;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    static final String TICKETS = "tickets";
    static final String TICKET = "ticket";
    static final String ID = "id";
    static final String TITLE = "title";
    static final String DATA =  "data";
    static final String CATEGORIES = "category";
    static final String PLACE = "place";

    Report report;

    Report getReport() {
        return report;
    }

    private Ticket currentTicket;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        switch (currentElement) {
            case TICKETS:
                report = new Report();
                report.ticketsList = new ArrayList<>();
                break;
            case TICKET:
                currentTicket = new Ticket();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String text = new String(ch,start,length);

        if(text.contains("<") || currentElement == null) {
            return;
        }

        switch (currentElement) {
            case CATEGORIES:
                currentTicket.category = text;
                break;
            case DATA:
                currentTicket.data = text;
                break;
            case ID:
                currentTicket.id = Integer.valueOf(text);
                break;
            case PLACE:
                currentTicket.place = Integer.valueOf(text);
                break;
            case TITLE:
                currentTicket.title = text;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case TICKET:
                report.ticketsList.add(currentTicket);
                currentTicket = null;
                break;
        }
        currentElement = null;
    }
    }

