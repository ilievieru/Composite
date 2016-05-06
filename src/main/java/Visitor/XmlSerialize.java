package Visitor;

import base.GenericShape;
import base.Point;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class XmlSerialize implements Visitor {

    public void createChild(GenericShape genericShape, Document doc, Element root) {
        //first shape
        Element shape = doc.createElement(genericShape.getName());
        root.appendChild(shape);
        //id tag
        Element id = doc.createElement("ID");
        id.appendChild(doc.createTextNode(genericShape.getId() + ""));
        shape.appendChild(id);
        //name Tag
        Element name = doc.createElement("Name");
        name.appendChild(doc.createTextNode(genericShape.getName()));
        shape.appendChild(name);
        //Start point
        Element start1 = doc.createElement("StartPoint");
        shape.appendChild(start1);
        //coordonata x
        Element x = doc.createElement("X");
        Point startP = genericShape.getStart();
        x.appendChild(doc.createTextNode(startP.getX() + ""));
        start1.appendChild(x);
        //coordonata y
        Element y = doc.createElement("Y");
        y.appendChild(doc.createTextNode(startP.getY() + ""));
        start1.appendChild(y);
        //Lista de puncte
        Element listOfPoints = doc.createElement("ListOfPoints");
        shape.appendChild(listOfPoints);
        int i = 0;
        if (genericShape.points != null) {
            for (Point p : genericShape.points) {
                i++;
                Element point = doc.createElement("Point" + i);
                listOfPoints.appendChild(point);

                Element x1 = doc.createElement("X");
                x1.appendChild(doc.createTextNode(p.getX() + ""));
                point.appendChild(x1);

                Element y1 = doc.createElement("Y");
                y1.appendChild(doc.createTextNode(p.getY() + ""));
                point.appendChild(y1);
            }
        } else
            listOfPoints.appendChild(doc.createTextNode("NoPoints"));
        //lista de forme
        Element listOfShapes = doc.createElement("ListOfShapes");
        shape.appendChild(listOfShapes);
        List<GenericShape> shapes = genericShape.getShapeList();
        if (shapes.isEmpty())
            listOfShapes.appendChild(doc.createTextNode("NoSubShapes"));
        else
            for (GenericShape s : shapes) {
                createChild(s, doc, listOfShapes);
            }
    }

    public void serialize(GenericShape genericShape) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuider = docFactory.newDocumentBuilder();

            //root element
            Document doc = docBuider.newDocument();
            Element rootElement = doc.createElement("GenericShape");
            doc.appendChild(rootElement);

            createChild(genericShape, doc, rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\V3790149\\Desktop\\" + genericShape.getName() + "XML.xml"));
            transformer.transform(source, result);
            System.out.println("Serializat");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public GenericShape des(GenericShape genericShape, Element shape) {
        String nume = "";
        int id = 0;
        Point start = null;
        float x = 0, y = 0;
        List<Point> list = new ArrayList<Point>();
        List<GenericShape> shapeList = new ArrayList<GenericShape>();


        //id
        Node ID = (Node) shape.getElementsByTagName("ID").item(0);
        id = Integer.parseInt(ID.getTextContent());
        //System.out.println("id " + id);
        //nume
        Node name = (Node) shape.getElementsByTagName("Name").item(0);
        nume = name.getTextContent();
        //System.out.println("Nume " + nume);
        //start Point
        Element startPoint = (Element) shape.getElementsByTagName("StartPoint").item(0);
        Node xCoord = startPoint.getElementsByTagName("X").item(0);
        x = Float.parseFloat(xCoord.getTextContent());
        Node YCoord = startPoint.getElementsByTagName("Y").item(0);
        y = Float.parseFloat(YCoord.getTextContent());
        start = new Point(x, y);
        //System.out.println("Start Point " + start.getX() + " " + start.getY());
        //List of points
        NodeList listPoints = (NodeList) shape.getElementsByTagName("ListOfPoints").item(0);
        for (int i = 0; i < listPoints.getLength(); i++) {
            Element point = (Element) listPoints.item(i);
            float x1 = 0, y1 = 0;
            Node xCoordP = point.getElementsByTagName("X").item(0);
            x1 = Float.parseFloat(xCoordP.getTextContent());
            Node YCoordP = point.getElementsByTagName("Y").item(0);
            y1 = Float.parseFloat(YCoordP.getTextContent());
            Point p = new Point(x1, y1);
            list.add(p);
        }
       /* for (Point p : list) {
            System.out.println(p.getX() + " " + p.getY());
        }*/

        //List of shapes
        Element listShapes = (Element) shape.getElementsByTagName("ListOfShapes").item(0);

        if (!listShapes.getTextContent().matches("NoSubShapes")) {
            GenericShape gen = null;
            gen = des(gen, listShapes);
            shapeList.add(gen);
        }
        genericShape = null;
        Class sh = null;
        try {
            sh = Class.forName("poligons." + nume);
            genericShape = (GenericShape) sh.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        genericShape.id = id;
        genericShape.name = nume;
        genericShape.start = start;
        Point[] points = new Point[list.size()];
        for (int i = 0; i < list.size(); i++)
            points[i] = list.get(i);
        genericShape.points = points;
        genericShape.shapeList = shapeList;
        return genericShape;
    }

    public void deserialize(GenericShape genericShape) {

        System.out.println("Done");
        File xml = new File("C:\\Users\\V3790149\\Desktop\\" + genericShape.getName() + "XML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(xml);
            doc.getDocumentElement().normalize();
            Element shape = (Element) doc.getDocumentElement().getFirstChild();
            // System.out.println("Root element is: " + doc.getDocumentElement().getNodeName());
            genericShape = des(genericShape, shape);
            genericShape.drawSubShapes();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
