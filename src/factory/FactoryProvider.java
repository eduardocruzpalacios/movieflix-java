package factory;

public class FactoryProvider {

	public static AbstractFactory<?> getFactory(String chooseFactory) {
		switch (chooseFactory) {
		case "usuario":
			return new UsuarioFactory();
		case "video":
			return new VideoFactory();
		default:
			return null;
		}
	}

}
