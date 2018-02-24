
/*
 * HomeworkReducer.java
 */

package com.mehal;


import java.io.IOException;
import java.util.*;
// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;


public class HomeworkReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        HashMapList mapObject = new HashMapList();

        for (Text valueIterator : values) {
            String[] splitKeyValue = valueIterator.toString().split(",");   //split key and value using ',' as the separator
            mapObject.creatingMap(splitKeyValue[0], splitKeyValue[1]);   //insert the split value into the Map
        }

        Set<String> setOfKeys = mapObject.returnKeySet();   //gets all the keys from the HashMap
        for (String keyIterator : setOfKeys)
        {    //traverses all keys
            List<String> tempValue = mapObject.getKey(keyIterator);
            for (String tempValueIte : tempValue)
            {
                if (mapObject.containsKey(tempValueIte))
                {
                    List<String> valuesOfTempValue = mapObject.getKey(tempValueIte);
                    for (String ite : valuesOfTempValue)
                    {
                        if (!keyIterator.equals(ite))
                            context.write(new Text(ite + "," + tempValueIte), new Text(keyIterator));
                    }
                }
            }
        }


    }
}
