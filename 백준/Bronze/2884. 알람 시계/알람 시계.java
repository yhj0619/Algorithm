import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		if(minute < 45 ) {
			hour --;
			minute = 60 + (minute - 45);
			if(hour < 0) {
				hour = 23;
			}
			System.out.println(hour + " " + minute);
		} else {
			System.out.println(hour + " " + (minute-45));
		}
			
	}

}
