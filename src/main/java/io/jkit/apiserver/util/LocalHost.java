package io.jkit.apiserver.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class LocalHost {
	final Charset utf8 = java.nio.charset.StandardCharsets.UTF_8;

	public LocalHost() {

	}

	public void writeFile(String targetFilePath, String content) throws IOException {

		try (Writer targetFile = new OutputStreamWriter(new FileOutputStream(targetFilePath), utf8)) {
			targetFile.write(content.toString());
			targetFile.flush();
		}
	}

}
