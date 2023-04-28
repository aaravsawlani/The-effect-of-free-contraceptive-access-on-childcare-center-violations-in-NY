import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.StringReader;

import javax.swing.BoundedRangeModel;

public class CleanMapper extends Mapper<Object, Text, Text, Text> {
 
    
    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        int null_counter = 0;

        String line = value.toString();
        String[] cols = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        String borough = cols[4];
        String zip = cols[5];
        String maxCap = cols[11];
        String violationRate = cols[20];
        String avgViolationRate = cols[21];
        String hhViolationRate = cols[24];
        String avgHHViolationRate = cols[25];
        String critViolationRate = cols[26];
        String avgCritViolationRate = cols[27];
        String violationCategory = cols[30];
        String violationStatus = cols[32];
        String highRisk;

        String[] vals = {borough, zip, maxCap, violationRate, avgViolationRate,
                        hhViolationRate, avgHHViolationRate, critViolationRate, 
                        avgCritViolationRate, violationCategory, violationStatus};

        // counts the number of null values per record
        for (String val : vals) {
            if (val.equals("")) null_counter++;
        }

        // skips record if too many null values
        if (null_counter >= 3) return;

        // if record has no zip code, don't include the record
        if (zip.equals("")) return;

        // add additional column indicating whether the establishment is 
        // high risk (violation rate is over 50 percent)
        try {
            highRisk = String.valueOf((Float.parseFloat(violationRate) > 49.9) ? 1 : 0);
        } catch (Exception e) {return;}

        context.write(new Text(
            borough+","+zip+","+maxCap+","+violationRate+","+avgViolationRate
            +","+hhViolationRate+","+avgHHViolationRate+","
            +critViolationRate+","+avgCritViolationRate+","
            +violationCategory+","+violationStatus+","+highRisk
            ), new Text());	

    }
}

