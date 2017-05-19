package ifrs.crud.clients.core;

public class MessagesConstants {
	public static final String OPTION_YES = "1 - SIM";
	public static final String OPTION_NO = "2 - N�O";
	public static final String OPTION_UPDATE = "1 - Atualizar";
	public static final String OPTION_DELETE = "2 - Excluir";
	
	public static final String FIELD_VALUE = "%s: %s";
	
	// O sistema deve iniciar questionando se o usu�rio quer ou n�o cadastrar/atualizar um cliente.
	public static final String STEP_CREATE_UPDATE_QUESTION = "Voc� deseja cadastrar ou atualizar um cliente?";
	public static final String STEP_DELETE_CONFIRM = "Voc� realmente deseja excluir o client?";
	public static final String STEP_REQUEST_CPF_CNPJ = "Favor inserir CPF ou CNPJ do cliente.";
	public static final String STEP_REQUEST_CLIENT_FIELD = "Favor preencher o valor do campo %s.";
	public static final String INVALID_CLIENT_FIELD = "O valor do campo %s � inv�lido.";
	public static final String INVALID_lENGTH_FIELD = "O %s deve ter ao menos %s caracteres.";
	public static final String INVALID_ALREADY_EXISTS_FIELD = "J� existe algum cliente com este valor para o campo %s.";
	public static final String INVALID_OPTION = "Op��o inv�lida! Digite novamente.";
	public static final String INVALID_CPF_CNPJ = "CPF/CNPJ inv�lido! Digite novamente.";
}
