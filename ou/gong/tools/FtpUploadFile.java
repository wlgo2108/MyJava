package ou.gong.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class FtpUploadFile {
	private TelnetOutputStream tos;
	private FileInputStream fis;
	private FtpClient ftpClient;
	private String host;
	private int port;
	private String username;
	private String password;

	public FtpUploadFile() {
		this.ftpClient = FtpClient.create();
	}

	public FtpUploadFile(String host, int port, String username, String password) {
		this.ftpClient = FtpClient.create();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public void connectServer() {
		SocketAddress sock = new InetSocketAddress(host, port);
		try {
			ftpClient.connect(sock);
			ftpClient.login(this.username, this.password.toCharArray());
			System.out.println("服务器连接成功");
		} catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接失败！");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("服务器连接失败！");
			e.printStackTrace();
		}
	}

	public boolean uploadFile(String fileName, String remoteFile) {
		boolean upCheck = true;
		this.connectServer();
		try {

			tos = (TelnetOutputStream) this.ftpClient.putFileStream(remoteFile);
			File file = new File(fileName);
			fis = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int c;
			while ((c = fis.read(bytes)) != -1) {
				tos.write(bytes, 0, c);
			}

			System.out.println("文件上传成功!");

		} catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("文件上传失败");
			upCheck = false;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("文件上传失败");
			upCheck = false;
			e.printStackTrace();
		} finally {

			try {
				if (fis != null) {
					fis.close();
				}
				
				if(tos != null) {
					tos.close() ; 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return upCheck;
	}

	public void closeServer() {

		try {
			if (this.ftpClient != null) {
				this.ftpClient.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
