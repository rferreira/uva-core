/**
 * Benchmarks how quickly we can generate SIF_Ack's
 * @author Rafael Ferreira
 *
 */

import com.uvasoftware.core.*;
import com.uvasoftware.core.util.*;
import java.io.ByteArrayOutputStream;

public class AckBenchmark {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		Config.getInstance();
		
		// TODO Auto-generated method stub
		double runs = Math.pow(10, 5);
		
		System.out.println("Benchmarking SIFAck's");
		System.out.println("I'll be running " + runs + " itertations");
		
		SIFMessageMarshaller m = SIFMessageMarshaller.getInstance();
		ByteArrayOutputStream out = null;
		
		long start_time = System.currentTimeMillis();
		
		double i = 0;
		SIFAck ack = null;
		
				
		while (i < runs) {
			out = new ByteArrayOutputStream();
			ack =  new SIFAck("0","0",Code.Status.SUCCESS);
			m.marshal(ack, out);
			
			// we're hoping de-referencing will speed up collection
			out = null;
			i++;
		}
		
		System.out.println("done!");
		System.out.println("");
		System.out.println("results:");
		long stop_time = System.currentTimeMillis(); 
		System.out.println(String.format("Total time elapsed: %s ms",(stop_time - start_time)) );
		System.out.println(String.format("Avg elapsed time: %s ms",(stop_time - start_time)/runs) );
	}

}
