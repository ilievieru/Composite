package Visitor;

import base.GenericShape;
import base.Point;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class JsonSerialize implements Visitor {

    public void createJSON(GenericShape genericShape, JSONObject obj) {
        obj.put("Id", genericShape.getId());
        obj.put("Name", genericShape.getName());

        JSONObject startPoint = new JSONObject();
        Point start = genericShape.getStart();
        startPoint.put("X", start.getX());
        startPoint.put("Y", start.getY());
        obj.put("StartPoint", startPoint);

        JSONArray listOfPoints = new JSONArray();
        if (genericShape.points != null) {
            for (Point p : genericShape.points) {
                JSONObject point = new JSONObject();
                point.put("X", p.getX());
                point.put("Y", p.getY());
                listOfPoints.add(point);
            }
            obj.put("ListOfPoints", listOfPoints);
            JSONArray listOfShapes = new JSONArray();

            List<GenericShape> list = genericShape.getShapeList();
            if (list.isEmpty()) {
                //listOfShapes.put("null","null");
            } else {
                for (GenericShape s : list) {
                    JSONObject child = new JSONObject();
                    listOfShapes.add(child);
                    createJSON(s, child);
                }
                obj.put("SubShapes", listOfShapes);
            }
        }
    }

    public void serialize(GenericShape genericShape) {
        JSONObject obj = new JSONObject();
        createJSON(genericShape, obj);
        try {
            FileWriter file = new FileWriter("C:\\Users\\V3790149\\Desktop\\" + genericShape.getName() + "JSON.txt");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GenericShape dese(GenericShape genericShape, JSONObject jsonObject) {
        //Shape name
        String name = (String) jsonObject.get("Name");
        //shape ID

        long ID = (Long) jsonObject.get("Id");
        int id = (int) (ID);

        //Shape start point
        JSONObject start = (JSONObject) jsonObject.get("StartPoint");
        double x = (Double) start.get("X");
        double y = (Double) start.get("Y");
        Point startPoint = new Point((float) x, (float) y);

        //shape points
        List<Point> list = new ArrayList<Point>();
        JSONArray arr = (JSONArray) jsonObject.get("ListOfPoints");
        Iterator<JSONObject> iterator = arr.iterator();
        while (iterator.hasNext()) {
            JSONObject poinnt = (JSONObject) iterator.next();
            double x1 = (Double) poinnt.get("X");
            double y1 = (Double) poinnt.get("Y");
            Point p = new Point((float) x1, (float) y1);
            list.add(p);
        }

        try {
            Point[] points = new Point[list.size()];
            for (int i = 0; i < list.size(); i++)
                points[i] = list.get(i);

            genericShape = null;
            Class sh = Class.forName("poligons." + name);
            genericShape = (GenericShape) sh.newInstance();
            genericShape.name = name;
            genericShape.id = id;
            genericShape.start = startPoint;
            genericShape.points = points;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //shape list of subshapes
        JSONArray shapeList = (JSONArray) jsonObject.get("SubShapes");
        List<GenericShape> subShp = new ArrayList<GenericShape>();

        if (shapeList != null)
            if (shapeList.isEmpty()) {
                System.out.println("No SubShapes");
            } else {
                for (Object ob : shapeList) {
                    GenericShape sub = null;
                    JSONObject obiect = (JSONObject) ob;
                    sub = dese(sub, obiect);
                    subShp.add(sub);
                }
            }
        genericShape.shapeList = subShp;
        return genericShape;
    }

    public void deserialize(GenericShape genericShape) {
        System.out.println("Done");
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\V3790149\\Desktop\\" + genericShape.getName() + "JSON.txt"));
            JSONObject jsonObject = (JSONObject) obj;
            genericShape = dese(genericShape, jsonObject);
            genericShape.drawSubShapes();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
