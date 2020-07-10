package edu.ahs.robotics.java;


import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GridLogger {

    private LogWriter writer;
    private HashSet<String> categories;
    private HashMap<String, String> values;
    private boolean noTitleRow = true;
    //private ArrayList<String>  categoryTicker = new ArrayList<>();

    public GridLogger(LogWriter writer) {
        this.writer = writer;
        categories = new HashSet<>();
        values = new HashMap<>();
    }

    /**
     * Add a value to the logger under the category.  Categories are lazily added to the logger
     * in the order encountered.
     *
     * @param category
     * @param value
     */
    public void add(String category, String value) {
        if (categories.contains(category)) {
            //Add the value the value to the HashMap
            values.put(category, value);
        } else {
            categories.add(category);


            //Add both the category and the value to the HashMap
            values.put(category, category);
            values.put(category, value);

        }
    }

    /**
     * Write a line of data to the log.  If this is the first call to writeLn, categories are
     * written first, followed by the line of data.  Once the data is written, the logger is reset
     * and calls to add() will add values to the next line of data.
     */
    public void writeLn() {
        for (int i = 0; i < values.size(); i++) {
            if (noTitleRow == true) {
                StringBuffer notCategory = new StringBuffer();
                notCategory.append(categories);

                writer.writeLine(notCategory.toString());
                noTitleRow = false;
            } else {
                StringBuffer categoriesInPlace = new StringBuffer();
                categoriesInPlace.append(values);
                writer.writeLine(categoriesInPlace.toString());
            }
        }

    }

    public void stop() {
    }
}


