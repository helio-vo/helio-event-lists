package sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class TIMEDSEERemoveDoy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// directory containing the event list
		String dir  = "C:\\Development\\HELIO\\Event_lists\\TIMED_SEE\\";
		
		// input file name
		String inname = dir + "timed_see_flare_doy.txt";

		// args[2] - lines to skip at start of list
		int skiplines = 1;
		
		// name of output file 
		String outname = dir + "timed_see_flare.txt";
		File out = new File(outname);

		try {
			
			UlyssesHxrRemoveDoy ulyssesHxr = new UlyssesHxrRemoveDoy();
			
			FileWriter fw = new FileWriter( out );
			PrintWriter pw = new PrintWriter( fw );
			
			pw.println("time_start" + "|" + "time_peak" + "|" + "time_end"
					+ "|" + "lat_hg" + "|" + "long_hg" + "|" + "long_carr" + "|" + "xray_class" 
					+ "|" + "nar" + "|" + "nevent" + "|" + "see_xps_index" + "|" + "see_egs_index"
					+ "|" + "obs_time_offset" + "|" + "url_ftp_file");
			
			
			String delims = "[|]";
			String[] tokens;

			File file = new File(inname);
		
			FileReader fr = new FileReader ( file );
			BufferedReader in = new BufferedReader( fr);
				
			String line;
			int i = 0;
			while ((line = in.readLine()) != null) {
					
				//skip lines at start of file 
				if (i>skiplines-1) {

					tokens = line.split(delims);
					
					pw.println(tokens[0] + "|" + tokens[1] + "|" + tokens[2] + "|" + tokens[4]
							+ "|" + tokens[5] + "|" + tokens[6] + "|" + tokens[7]
							+ "|" + tokens[8] + "|" + tokens[9] + "|" + tokens[10]
							+ "|" + tokens[11] + "|" + tokens[12] + "|" + tokens[13]);
	
				}
				
				// line counter
				i++;
		
			}
			
			fw.close();
			
		} catch (Exception e) {System.out.println(e.getMessage());}


	}

}
