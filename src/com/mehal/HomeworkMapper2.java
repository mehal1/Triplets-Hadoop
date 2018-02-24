/*
 * HomeworkMapper2.java
 */
package com.mehal;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class HomeworkMapper2 extends Mapper<Text, Text, Text, Text> {
    @Override
    protected void map(Text key, Text value, Context context)
            throws IOException, InterruptedException {
        context.write(key, value);
    }
}
