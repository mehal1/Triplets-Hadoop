
/*
 * HomeworkReducer.java
 */

package com.mehal;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class HomeworkReducer2 extends Reducer<Text, Text, Text, Text> {


    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        StringBuffer valueBuffer = new StringBuffer();
        for (Text valueIterator : values) {
            valueBuffer.append(valueIterator + ",");
        }
        valueBuffer.replace(valueBuffer.length() - 1, valueBuffer.length(), "");
        context.write(key, new Text(valueBuffer.toString()));
    }
}
