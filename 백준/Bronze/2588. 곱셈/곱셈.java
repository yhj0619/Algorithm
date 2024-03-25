import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
			
		System.out.println(n1 * (n2 % 10));
		System.out.println(n1 * ((n2 % 100) /10));
		System.out.println(n1 * (n2 / 100));
		System.out.println(n1 * n2 );
	}

}
