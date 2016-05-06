package Visitor;

import base.GenericShape;

import java.io.*;

/**
 * Created by V3790149 on 5/4/2016.
 */
public class ConcretVisitor implements Visitor {
    public void serialize(GenericShape shape) {
        System.out.println("Serialize  " + shape.getName() );
        try {
            //shape.draw();
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\V3790149\\Desktop\\"+shape.getName()+"Normal.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(shape);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(GenericShape genericShape){
        System.out.println("Done");
        try {
            FileInputStream fisIn = new FileInputStream("C:\\Users\\V3790149\\Desktop\\"+ genericShape.getName()+"Normal.ser");
            ObjectInputStream in = new ObjectInputStream(fisIn);
            genericShape = (GenericShape) in.readObject();
            in.close();
            fisIn.close();
            if(genericShape != null){
                genericShape.drawSubShapes();
            }
            else
                System.out.println("Eroare deseralizare");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

