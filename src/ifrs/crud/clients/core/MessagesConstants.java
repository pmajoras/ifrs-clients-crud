package ifrs.crud.clients.core;

public class MessagesConstants {
	public static final String OPTION_YES = "1 - SIM";
	public static final String OPTION_NO = "2 - NÃO";
	public static final String OPTION_UPDATE = "1 - Atualizar";
	public static final String OPTION_DELETE = "2 - Excluir";
	
	public static final String FIELD_VALUE = "%s: %s";
	
	// O sistema deve iniciar questionando se o usuário quer ou não cadastrar/atualizar um cliente.
	public static final String STEP_CREATE_UPDATE_QUESTION = "Você deseja cadastrar ou atualizar um cliente?";
	public static final String STEP_DELETE_CONFIRM = "Você realmente deseja excluir o client?";
	public static final String STEP_REQUEST_CPF_CNPJ = "Favor inserir CPF ou CNPJ do cliente.";
	public static final String STEP_REQUEST_CLIENT_FIELD = "Favor preencher o valor do campo %s.";
	public static final String INVALID_CLIENT_FIELD = "O valor do campo %s é inválido.";
	public static final String INVALID_lENGTH_FIELD = "O %s deve ter ao menos %s caracteres.";
	public static final String INVALID_ALREADY_EXISTS_FIELD = "Já existe algum cliente com este valor para o campo %s.";
	public static final String INVALID_OPTION = "Opção inválida! Digite novamente.";
	public static final String INVALID_CPF_CNPJ = "CPF/CNPJ inválido! Digite novamente.";
}
