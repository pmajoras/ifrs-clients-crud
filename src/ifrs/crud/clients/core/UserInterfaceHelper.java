package ifrs.crud.clients.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class UserInterfaceHelper implements IUserInterfaceHelper {

	private String readLine() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		
		return value != null ? value.trim() : null;
	}
	
	public Boolean ReadYesNo() {
		Boolean returnValue = false;
		Boolean invalidValue = true;
		
		while(invalidValue) {			
			try {
				int n = Integer.parseInt(this.readLine());
				
				if (n == 2 || n == 1) {
					returnValue = n == 1;
					invalidValue = false;
				}				
			} catch (Exception e) {
			} finally {
				if (invalidValue) {
					System.out.println(MessagesConstants.INVALID_OPTION);
				}
			}
		}
		
		return returnValue;
	}

	public Boolean RequestCreateUpdate() {
		System.out.println(MessagesConstants.STEP_CREATE_UPDATE_QUESTION);
		System.out.println(MessagesConstants.OPTION_YES);
		System.out.println(MessagesConstants.OPTION_NO);
		
		return this.ReadYesNo();
	}
	
	@Override
	public Boolean RequestDelete() {
		System.out.println(MessagesConstants.STEP_DELETE_CONFIRM);
		System.out.println(MessagesConstants.OPTION_YES);
		System.out.println(MessagesConstants.OPTION_NO);
		
		return this.ReadYesNo();
	}
	
	public Boolean RequestUpdateDelete() {
		System.out.println(MessagesConstants.STEP_CREATE_UPDATE_QUESTION);
		System.out.println(MessagesConstants.OPTION_UPDATE);
		System.out.println(MessagesConstants.OPTION_DELETE);
		
		return this.ReadYesNo();
	}

	@Override
	public String RequestCpfOrCnpj() {
		Boolean invalidValue = true;
		String cpfCnpj = null;
		System.out.println(MessagesConstants.STEP_REQUEST_CPF_CNPJ);
		
		while(invalidValue) {			
			try {
				cpfCnpj = this.readLine();
				if (GenericValidators.validateCpfCnpj(cpfCnpj)) {
					invalidValue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (invalidValue) {
					System.out.println(MessagesConstants.INVALID_CPF_CNPJ);
				}
			}
		}
		
		return cpfCnpj;
	}

	@Override
	public String RequestField(String fieldName, Function<String, String> validator) {
		
		Boolean invalidValue = true;
		String fieldValue = null;
		String extraErrorMessage = null;
		
		System.out.println(String.format(MessagesConstants.STEP_REQUEST_CLIENT_FIELD, 
				fieldName));
		
		while(invalidValue) {			
			try {
				fieldValue = this.readLine();
				extraErrorMessage = validator != null ? validator.apply(fieldValue) : null;
				invalidValue = extraErrorMessage != null;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (invalidValue) {
					System.out.println(String.format(MessagesConstants.INVALID_CLIENT_FIELD, 
							fieldName));
					
					if (extraErrorMessage != null) {
						System.out.println(extraErrorMessage);
					}
				}
			}
		}
		
		return fieldValue;
	}
}
