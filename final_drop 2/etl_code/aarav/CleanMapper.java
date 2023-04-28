import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.StringReader;

public class CleanMapper extends Mapper<Object, Text, Text, Text> {
 
    
    @Override
    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] cols = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        String partner_type = cols[5].toUpperCase();
        String borough = cols[9].toUpperCase();
        String zip_code = cols[10].toUpperCase();
        String male_condoms = cols[24].toUpperCase();
        String female_condoms = cols[25].toUpperCase();
        String lubricant = cols[26].toUpperCase();

        String[] vals = {partner_type, borough, zip_code, male_condoms, female_condoms, lubricant};

        int null_counter = 0;

        for (String val : vals) {
            if (val.equals("")) null_counter++;
        }

        if (null_counter >= 3) return;

        
        context.write(new Text(
            partner_type+","+borough+","+zip_code
            +","+male_condoms+","+female_condoms+","
            +lubricant), new Text());

    }
}
