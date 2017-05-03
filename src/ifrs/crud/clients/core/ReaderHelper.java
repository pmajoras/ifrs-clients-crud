package ifrs.crud.clients.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderHelper implements IReaderHelper {

	public Boolean ReadYesNo() {
		Boolean returnValue = false;
		Boolean invalidValue = false;
		
		while(invalidValue) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				int n = Integer.parseInt(br.readLine());
				
				if (n == 1 || n == 0) {
					returnValue = n == 1;
					invalidValue = false;
				}				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (invalidValue) {
					System.out.println(MessagesConstants.INVALID_OPTION);
				}
			}
		}
		
		return returnValue;
	}
}
