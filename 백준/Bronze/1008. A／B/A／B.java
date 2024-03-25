import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double n1 = Double.parseDouble(st.nextToken());
		double n2 = Double.parseDouble(st.nextToken());
		
		System.out.println(n1/n2);
	}

}
