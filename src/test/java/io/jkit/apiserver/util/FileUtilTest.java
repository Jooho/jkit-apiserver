package io.jkit.apiserver.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

public class FileUtilTest {

	String JKIT_CONFIG_DIR_PATH = "/tmp";
	String ARCHIVE_DIR_PATH = "ansible-test";
	String TAR_FILE_NAME = "ansible-test.tar";
	String UNTAR_FILE_PATH = JKIT_CONFIG_DIR_PATH;
	String TAR_FILE_PATH = JKIT_CONFIG_DIR_PATH;

	//
	// @Test
	// public void readYamlFileTest() throws Exception{
	// InputStream input = new FileInputStream(new
	// File("src/test/resources/ansible-test/test-yaml.yml"));
	// Yaml yaml = new Yaml();
	// Iterable<Object> dataList = yaml.loadAll(input);
	// for (Object o : dataList) {
	//// Map<String, String> data = (Map<String, String>) o;
	// System.out.println();
	//
	// }
	//
	// //assertEquals("yaml-shootout", data.get("simple"));
	// }
	//
	// @Test
	// public void writeYamlFileTest() {
	//
	// }

	@Test
	public void writeFile() throws Exception {
		FileUtil.writeFile(JKIT_CONFIG_DIR_PATH + "/jkit_hosts", "test");

		assertTrue(new File(TAR_FILE_PATH + "/jkit_hosts").exists());
		try (BufferedReader reader = new BufferedReader(new FileReader(TAR_FILE_PATH + "/jkit_hosts"))) {
			assertThat(reader.readLine(), equalTo("test"));
		}
	}

	@Test
	public void sendFileToRemoteHost() throws Exception {
		// https://unix.stackexchange.com/questions/136165/java-code-to-copy-files-from-one-linux-machine-to-another-linux-machine?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
		// http://www.jcraft.com/jsch/examples/Exec.java.html
		FileUtil.sendFileToRemoteHost("root", "dhcp182-21.gsslab.rdu2.redhat.com", "redhat",
				new File(TAR_FILE_PATH + "/" + TAR_FILE_NAME), "/tmp/");
	}

	@Test
	public void execCmdToRemoteHost() throws Exception {
		assertThat(FileUtil.execCmdToRemote("root", "dhcp182-21.gsslab.rdu2.redhat.com", "redhat",
				"ls " + TAR_FILE_PATH + "/" + TAR_FILE_NAME), equalTo(0));

		// https://unix.stackexchange.com/questions/136165/java-code-to-copy-files-from-one-linux-machine-to-another-linux-machine?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
		// http://www.jcraft.com/jsch/examples/Exec.java.html
	}

	// @Test
	// public void getFileToHost() {
	//
	// }

	@Test
	public void tarFiles() throws Exception {
		File directory = new File(getClass().getClassLoader().getResource(ARCHIVE_DIR_PATH).getFile());
		FileUtil.compress(TAR_FILE_PATH + "/" + TAR_FILE_NAME, directory);

		assertTrue(new File(TAR_FILE_PATH + "/" + TAR_FILE_NAME).exists());

		// https://memorynotfound.com/java-tar-example-compress-decompress-tar-tar-gz-files/
		// https://netjs.blogspot.ca/2017/05/creating-tar-file-and-gzipping-multiple-files-java.html
		// https://netjs.blogspot.ca/2017/05/compressing-and-decompressing-file-in-gzip-java-code.html
	}

	@Test
	public void untarFiles() throws Exception {
		FileUtil.decompress(TAR_FILE_PATH + "/" + TAR_FILE_NAME, new File(UNTAR_FILE_PATH));
		assertTrue(new File(TAR_FILE_PATH + "/" + ARCHIVE_DIR_PATH).isDirectory());
	}

	// https://netjs.blogspot.ca/2016/07/unzipping-files-in-java.html

}
