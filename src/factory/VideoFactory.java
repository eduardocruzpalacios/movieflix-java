package factory;

import model.Pelicula;

public class VideoFactory implements AbstractFactory<VideoProduct> {

	@Override
	public VideoProduct create(String type) {
		switch (type) {
		case "pelicula":
			return new Pelicula().crear();
		default:
			return null;
		}

	}

}
