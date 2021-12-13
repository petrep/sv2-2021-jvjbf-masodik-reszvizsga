package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
	private List<Human> humans = new ArrayList<>();

	public List<Human> getHumans() {
		return humans;
	}

	public void readHumansFromFile(Path path) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(path);
		}
		catch (IOException ioe) {
			throw new IllegalStateException("Can't read file!", ioe);
		}

		for (String line : lines) {
			String[] parts = line.split(";");
			String name = parts[0];
			String identityNumber = parts[1];
			humans.add(new Human(name, identityNumber));
		}
	}

	public void writeMaleHumansToFile(Path path) {
		List<String> maleHumans = getListOfMaleHumans();
		try {
			Files.write(path, maleHumans);
		} catch (IOException ioe) {
			throw new IllegalStateException("Can't write file!", ioe);
		}
	}

	private List<String> getListOfMaleHumans() {
		List<String> maleHumans = new ArrayList<>();

		for (Human human : humans) {
			if ((human.getIdentityNumber().startsWith("1")) ||
				(human.getIdentityNumber().startsWith("3"))) {
					maleHumans.add(human.getName() + ";" + human.getIdentityNumber());
			}
		}

		return maleHumans;
	}
}
