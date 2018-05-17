package io.jkit.apiserver.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

	public FileUtil() {

	}

	public static void compress(String tarPath, File... files) throws IOException {
		Tar tar = new Tar();
		tar.compress(tarPath, files);

	}

	public static void decompress(String tarPath, File targetFolderPath) throws IOException {
		Tar tar = new Tar();
		tar.decompress(tarPath, targetFolderPath);
	}

	public static void sendFileToRemoteHost(String username, String hostname, String password, File sendFile,
			String targetPath) throws Exception {
		RemoteHost remoteHost = new RemoteHost();
		remoteHost.sendLocalToRemote(username, hostname, password, sendFile, targetPath);

	}

	public static int execCmdToRemote(String username, String hostname, String password, String cmd) throws Exception {
		RemoteHost remoteHost = new RemoteHost();
		return remoteHost.execCmdToRemote(username, hostname, password, cmd);
	}

	public static void writeFile(String targetFilePath, String content) throws IOException {
		LocalHost localHost = new LocalHost();
		localHost.writeFile(targetFilePath, content);

	}

}
