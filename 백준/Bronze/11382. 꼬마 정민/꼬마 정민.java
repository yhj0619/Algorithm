import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n1 = Long.parseLong(st.nextToken());
		long n2 = Long.parseLong(st.nextToken());
		long n3 = Long.parseLong(st.nextToken());	
		
		long n4 = n1 + n2 + n3;
		
		System.out.println(n4);
	}

}
