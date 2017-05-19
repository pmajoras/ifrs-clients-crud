package ifrs.crud.clients.core;
import java.util.function.Function;

public interface IUserInterfaceHelper {
	Boolean ReadYesNo();
	Boolean RequestCreateUpdate();
	Boolean RequestUpdateDelete();
	Boolean RequestDelete();
	String RequestCpfOrCnpj();
	String RequestField(String fieldName, Function<String, String> validator);
}
