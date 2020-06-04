import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CMain {

	public static void main(String[] p) {
		
		ArrayList<CMessage> list = new ArrayList<CMessage>();
		try {
			System.out.println("Server is started.  IP:"+
					Inet4Address.getLocalHost().getHostAddress());
			
			ServerSocket server= new ServerSocket(10288);
			
			while(true) {
				Socket client = server.accept();
				System.out.println("Client is connected.");
				DataInputStream streamIn=new DataInputStream(client.getInputStream());
				String data = streamIn.readUTF();
				System.out.println("Recept:"+data);
				
				
				String[] items = new String[1];
				String strReturn="沒有任何留言";
				try {
					items=data.split("@");
				}catch(Exception ex) {
					strReturn="傳輸規格錯誤";
				}
				
				if(items.length==3) {
					
					CMessage sender = new CMessage(items[0],items[1],items[2],false);
					list.add(sender);
					for(CMessage m:list) {
						if(m.getTo().toUpperCase().equals(sender.getFrom().toUpperCase())&&!m.isRead())
						{
							m.setRead(true);
							strReturn=m.getFrom()+":"+m.getMessage();
							break;
						}
					}
				}
				else 
					strReturn="傳輸規格錯誤";
				
				
				
				DataOutputStream streamOut=
						new DataOutputStream(client.getOutputStream());
				streamOut.writeUTF(strReturn);
				client.close();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	}

}
