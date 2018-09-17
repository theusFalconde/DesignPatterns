package br.edu.up.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterUtils {

	public static final String[] EXTENSIONS = new String[] { "jpg", "png", "jpeg" };

	private static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
		@Override
		public boolean accept(final File dir, final String name) {
			for (final String ext : EXTENSIONS) {
				if (name.endsWith("." + ext)) {
					return true;
				}
			}
			return false;
		}
	};

	public static File[] listImages(String directory) {
		File file = new File(directory);
		if (file.isDirectory()) {
			return file.listFiles(IMAGE_FILTER);
		} else {
			System.err.println("O Caminho informado não é um diretório!");
			return null;
		}
	}

}
