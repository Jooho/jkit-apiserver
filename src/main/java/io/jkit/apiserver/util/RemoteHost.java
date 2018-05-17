package io.jkit.apiserver.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class RemoteHost {

	public RemoteHost() {

	}

	public void sendLocalToRemote(String username, String hostname, String password, File sendFile, String targetPath)
			throws JSchException, FileNotFoundException, SftpException {
		// https://medium.com/@ldclakmal/scp-with-java-b7b7dbcdbc85

		JSch jsch = new JSch();
		Session session = null;
		session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		ChannelSftp channel = null;
		channel = (ChannelSftp) session.openChannel("sftp");
		channel.connect();
		// If you want you can change the directory using the following line.
		channel.cd(targetPath);
		channel.put(new FileInputStream(sendFile), sendFile.getName());
		channel.disconnect();
		session.disconnect();

	}

	public int execCmdToRemote(String username, String hostname, String password, String cmd) throws Exception {
		// https://medium.com/@ldclakmal/scp-with-java-b7b7dbcdbc85

		JSch jsch = new JSch();
		Session session = null;
		session = jsch.getSession(username, hostname, 22);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		ChannelExec channel = (ChannelExec) session.openChannel("exec");
		channel.setCommand(cmd);
		channel.connect();

		InputStream in = channel.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuffer output = new StringBuffer();

		String line;
		int index = 0;

		while ((line = reader.readLine()) != null) {
			System.out.println(++index + " : " + line);
			output.append(line);
			if (index != 1)
				output.append(System.getProperty("line.separator"));
		}
		int exitStatus = channel.getExitStatus();
		channel.disconnect();
		session.disconnect();

		if (exitStatus < 0) {
			System.out.println("Done, but exit status not set!");
		} else if (exitStatus > 0) {
			System.out.println("Done, but with error!");
		} else {
			System.out.println("Done!");
		}

		return exitStatus;
	}

}
