package ifrs.crud.clients.core;

public class GenericValidators {

	public static Boolean validateCpfCnpj(String cpfCnpj) {
		return GenericValidators.isCpf(cpfCnpj) ? 
				GenericValidators.isValidCpf(cpfCnpj) : GenericValidators.isValidCnpj(cpfCnpj);
	}
	
	public static Boolean isCpf(String cpf) {
		return GenericValidators.isValidCpf(cpf);
	}
	
	public static Boolean isValidCpf(String cpf) {
		return cpf != null && cpf.length() == 11;
	}
	
	public static Boolean isValidCnpj(String cnpj) {
		return cnpj != null && cnpj.length() == 14;
	}
	
	public static String validateFieldLength(String value, int minimumLength, String fieldName) {
		String errorMessage = null;
		
		if (value == null || value.length() < minimumLength) {
			errorMessage = String.format(MessagesConstants.INVALID_lENGTH_FIELD, 
					fieldName, minimumLength);
		}
		
		return errorMessage;
	}
}
