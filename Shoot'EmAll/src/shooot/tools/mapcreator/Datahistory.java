package shooot.tools.mapcreator;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Datahistory {

    private ArrayList<Block> offset0;
    private ArrayList<Block> offset1;
    private ArrayList<Block> offset2;
    private ArrayList<Block> current;

   
    public Datahistory() {
        offset0 = new ArrayList<Block>();
        offset1 = new ArrayList<Block>();
        offset2 = new ArrayList<Block>();
        current = offset0;
    }

    
    public void add(Block block) {
        current.add(block);
    }

    public boolean remove(int row, int col) {
        Iterator<Block> itr = current.iterator();
        while (itr.hasNext()) {
            Block block = itr.next();
            if (block.getRow() == row && block.getCol() == col) {
                current.remove(block);
                return true;
            }
        }
        return false;
    }

  
    public void paint(Graphics g) {
        Iterator<Block> itr = current.iterator();
        while (itr.hasNext()) {
            Block block = itr.next();
            g.setColor(Color.BLACK);
            block.paint(g);
        }
    }

  
    public void save(File file) throws Exception {
        FileOutputStream fileoutput = new FileOutputStream(file);
        ObjectOutputStream objOS = new ObjectOutputStream(fileoutput);
        objOS.writeObject(current);
        objOS.close();
        fileoutput.close();
    }

    public void load(File file) throws Exception {
        FileInputStream fileinput = new FileInputStream(file);
        ObjectInputStream objIS = new ObjectInputStream(fileinput);
        current = (ArrayList) objIS.readObject();
        objIS.close();
        fileinput.close();
    }

   
    public void back() {
        if (current.size() > 0) {
            current.remove(current.size() - 1);
        }
    }

   
    public void clear() {
        current.clear();
    }

    public void setCurrentDB(int offset) {
        if (offset==0) {
            current = offset0;
        } else if (offset==1) {
            current = offset1;
        } else if (offset==2) {
            current = offset2;
        }
        System.out.println(current.size());
    }

    public ArrayList<Block> getCurrent() {
        return current;
    }
   
    public void printall() {
        Iterator<Block> itr = offset0.iterator();
        while (itr.hasNext()) {
            Block block = itr.next();
            block.printJava(0);
        }
        Iterator<Block> itr2 = offset1.iterator();
        while (itr2.hasNext()) {
            Block block = itr2.next();
            block.printJava(75*50);
        }
        Iterator<Block> itr3 = offset2.iterator();
        while (itr3.hasNext()) {
            Block block = itr3.next();
            block.printJava(2*75*50);
        }
    }
}
