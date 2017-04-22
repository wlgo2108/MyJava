package ou.gong.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BasicSocket extends Socket {
	
	// 未初始化状态
		public static final int STATUS_NONE_INIT = 0;
		// 空闲状态
		public static final int STATUS_IDLE = 1;
		// 使用中状态
		public static final int STATUS_BUSY = 2;
		// 不可用状态
		public static final int STATUS_DISABLED = 3;
		// 连接状态
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
			// 消息体内容
			byte[] body = message.getBytes();
			byte[] data=null;
			byte[] result = new byte[body.length + 2];
			// 数据头2字节为长度
			putHead(result, (short) body.length);
			// 添加消息头
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
				// 消息字节长度
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
