package ou.gong.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BasicSocket extends Socket {
	
	// δ��ʼ��״̬
		public static final int STATUS_NONE_INIT = 0;
		// ����״̬
		public static final int STATUS_IDLE = 1;
		// ʹ����״̬
		public static final int STATUS_BUSY = 2;
		// ������״̬
		public static final int STATUS_DISABLED = 3;
		// ����״̬
		protected int status = STATUS_NONE_INIT;
		
		protected String commKey;
	

		public BasicSocket(String hostIp, int port) throws UnknownHostException, IOException  {
			super(hostIp, port);
		}

		public synchronized boolean updateStatus(int exceptStatus, int toStatus) {

			boolean flag = false;

			if (status == exceptStatus) {

				status = toStatus;

				flag = true;
			}

			return flag;
		}

		public synchronized void updateStatusForce(int toStatus) {

			status = toStatus;
		}

		public synchronized boolean isStatus(int exceptStatus) {

			return status == exceptStatus;
		}
		
		
		public void close() {

			try {
				
				super.close();
			} catch (IOException e) {


			} finally {
				updateStatusForce(STATUS_DISABLED);
			}
		}
		
		
		
		
		
		public void send(String message){
			// ��Ϣ������
			byte[] body = message.getBytes();
			byte[] data=null;
			byte[] result = new byte[body.length + 2];
			// ����ͷ2�ֽ�Ϊ����
			putHead(result, (short) body.length);
			// �����Ϣͷ
			putBody(result, body);
			
	    	data=result;
			
			sendmessage(data);
		}
		
		public void sendmessage(byte[] msg) {

			try {
				OutputStream out = this.getOutputStream();
				if (out != null) {
					this.getOutputStream().write(msg);
					this.getOutputStream().flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
				
				updateStatusForce(STATUS_DISABLED);
				
			//	this.close();
			}
		}
		
		
		public String receive() {
			String response =null;
			try {
				
				DataInputStream in = new DataInputStream(getInputStream());
				// ��Ϣ�ֽڳ���
				int length = in.readShort();
				
				byte[] data = new byte[length];
				
				in.readFully(data);			
			
				 response = new String(data);
		
				
			} catch (IOException e) {
				updateStatusForce(STATUS_DISABLED);

			}

			
			updateStatus(STATUS_BUSY, STATUS_IDLE);
			
			return response;
		}
		
		
		private void putHead(byte[] b, short msgLength) {
			
			b[0] = (byte) (msgLength >> 8);
			b[1] = (byte) msgLength;
		}
		

		private void putBody(byte[] result, byte[] bytes) {

			for (int i = 2; i < result.length; i++) {

				result[i] = bytes[i - 2];
			}

		}
		

}
