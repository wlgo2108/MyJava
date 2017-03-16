package ou.gong.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import ou.gong.models.ServerInfo;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class FtpUploadFile {
	
	private ServerInfo serverInfo ;
	private TelnetOutputStream tos ;
	private FileInputStream fis ;
	private FtpClient ftpClient ;
	
	public FtpUploadFile(ServerInfo serverInfo) {
		this.ftpClient = FtpClient.create() ;
		this.serverInfo = serverInfo ;
	}
	
	/**
	 * ���ӷ�����
	 */
	public void connectServer() {
		SocketAddress sock = new InetSocketAddress(this.serverInfo.getHost_ip(),this.serverInfo.getPort()) ;
		try {
			ftpClient.connect(sock) ;
			ftpClient.login(this.serverInfo.getServer_name(),this.serverInfo.getServer_pass().toCharArray()) ;
		} catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("����������ʧ�ܣ�");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("����������ʧ�ܣ�");
			e.printStackTrace();
		}
		
		
	}
	
	/***
	 * function uploadFile() ---�ϴ��ļ���ָ��������
	 * @return  true -- �ϴ��ɹ��� false ---�ϴ�ʧ��
	 */
	public boolean uploadFile(String fileName) {
		boolean chk = false  ;
	
		this.connectServer() ; 
	
		String filePath = this.serverInfo.getUpload_path() ;
		String remoteFile = filePath+ fileName ;
		
		
		if(filePath.charAt(filePath.length() -1) != '/') {
			remoteFile = this.serverInfo.getUpload_path() +"/"+ fileName ;
		}
		
		try {
			tos = (TelnetOutputStream)this.ftpClient.putFileStream(remoteFile) ;
			File file = new File(fileName) ;
			fis = new FileInputStream(file) ;
			int c ;
			byte[] bytes = new byte[1024] ;
			while((c = fis.read(bytes)) != -1) {
				tos.write(bytes,0,c) ;
			}
			System.out.println("�ļ��ϴ��ɹ�");
			chk = true ;
		} catch (FtpProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ��ϴ�ʧ��");
	
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ��ϴ�ʧ��");
			e.printStackTrace();
		} finally {
	
				try {
					if(fis != null) {
					fis.close() ;
					}
					
					if(tos != null) {
						tos.close() ;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		return chk ;
	}
	
	/**
	 * �رշ�����
	 */
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
