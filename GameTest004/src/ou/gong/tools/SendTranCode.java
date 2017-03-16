package ou.gong.tools;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Calendar;

import ou.gong.models.ServerInfo;

import ou.gong.models.TestCase;
import ou.gong.models.TranCodeInfo;
import ou.gong.socket.BasicSocket;

public class SendTranCode {
	
	private BasicSocket bSock ;
	private ServerInfo sf ;
	
	
	public SendTranCode(ServerInfo sf) {
		this.sf = sf ;
		System.out.println(this.sf.getHost_ip()) ;
		try {
			bSock = new BasicSocket(this.sf.getHost_ip(),this.sf.getPort()) ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Ͷע
	 * @param ts
	 * @param tf
	 * @return
	 */
    public String tt101200(TestCase ts, TranCodeInfo tf) {
        String trancode = "101200" ;
        if(sf.getPro_code() == 62) {
            trancode = "103200" ;
        }

        int game_type = ts.getPlay_type() ;
        int wager_money = ts.getWager_money() ;
        String wager_num = ts.getWager_num() ;
        int bs = ts.getBs() ;
        int qs = ts.getQs() ;
        String[] new_num = wager_num.split(";") ;
        String lottery_num = String.valueOf(new_num.length) ;
//        System.out.println(lottery_num) ;
        for(int i = 0 ; i < new_num.length ; i ++) {
            lottery_num = lottery_num + ";" + String.valueOf(i + 1) + ";3;" + String.valueOf(game_type) + ";" + String.valueOf(bs) + ";" + new_num[i] ;
        }
        
        int station_id = tf.getStation_id() ;
        int issue = tf.getIssue() ;
        int game_id = tf.getGame_id() ;
        int tsn = ts.getTsn() ;


        String msg = trancode + ";0;1;"+station_id+";1;"+game_id+";"+issue+";"+tsn+";"+
                wager_money + ";"+(tsn -1) + ";"+qs + ";;;;"+lottery_num + ";;" ;
        System.out.println(msg) ;
        bSock.send(msg) ;
        String rece_msg = bSock.receive() ;

    
         return rece_msg ;

    }

    /**
     * ע��
     * @return
     */
    public String tt101300(TranCodeInfo tf) {


        String trancode = "101300" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103300" ;
        }

        String msg = trancode + ";0;103;"+tf.getStation_id() + ";1;;"+tf.getGame_id()
                + ";" + tf.getIssue() + ";"+tf.getStation_id()+";"+tf.getTsn() +";;" + tf.getStation_cert()  + ";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
    }

    /**
     * ����
     * @return
     */

    public String tt101999(TranCodeInfo tf ) {
    	String trancode = "101999" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103999" ;

        }

        String msg = trancode + ";0;103;"+tf.getStation_id() + ";1;;"+tf.getGame_id()
                + ";" + tf.getIssue() + ";"+tf.getStation_id()+";"+tf.getTsn() +";;0;" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
        
    }

    /***
     * ���ڶҽ���
     * @return
     */

    public String tt101009(TranCodeInfo tf ) {
    	
    	String trancode = "101009" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103009" ;

        }

        String msg = trancode + ";0;103;"+tf.getStation_id() + ";1;;"
        		+tf.getStation_id()+";"+tf.getIssue()
                + ";" + tf.getGame_id()+ ";"+tf.getTsn() +";;"+tf.getStation_cert()+";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;

    }

	
	
    /**
     * ���ڶҽ�
     * @param tf
     * @return
     */

    public String tt101056(TranCodeInfo tf  ) {
    	
    	String trancode = "101056" ;
        if(this.sf.getPro_code() == 62) {
            trancode = "103056" ;
        }
        String msg = trancode + ";0;103;"+tf.getStation_id()+";1;;"+tf.getStation_id()+";"
        		+ tf.getIssue()+";"+tf.getGame_id()+";"+tf.getTsn()+";;"+tf.getStation_cert()+";" ;
        System.out.println(msg) ;

        bSock.send(msg) ;
        return bSock.receive() ;
 
    }
	
	
	/**
	 * ������Ʊ
	 * @param tf
	 * @return
	 */
	 public String tt101058(TranCodeInfo tf) {
	    	
	    	String trancode = "101058" ;
	        if(this.sf.getPro_code() == 62) {
	            trancode = "103058" ;
	        }
	        String msg = trancode + ";0;103;"+tf.getStation_id()+";1;;"+tf.getStation_id()+";"
	        		+ tf.getIssue()+";"+tf.getGame_id()+";"+tf.getTsn()+";;"+tf.getStation_cert()+";" ;
	        System.out.println(msg) ;

	        bSock.send(msg) ;
	        return bSock.receive() ;
	        
	    }
	
	/**
	 * �ɿ��T602201
	 * @param st
	 * @return
	 */
	
	public String tt602201(TranCodeInfo tf) {
    	String trancode = "602201" ;
    	Calendar calendar = Calendar.getInstance() ;
    	String dDate_time = TimeTools.dateTimeChange(calendar.getTime()) ;
    	float money = tf.getMoney() ;
    	String msg = trancode+";1;12345678;"+tf.getStation_id()+";1;12345678;"+tf.getStation_id()+";"+tf.getStation_id()+";"+money+";"+dDate_time+";5;" ;
        System.out.println(msg) ;
        bSock.send(msg) ;
        return bSock.receive() ;
    }
	
	/**
	 * 
	 */
	
	public String tt877805(TestCase ts,TranCodeInfo tf) {
		String trancode = "877805" ;
    
    	String msg = trancode +";0;1;"+tf.getStation_id()+";1;"
    			+tf.getStation_id()+";"+tf.getGame_id()+";"+tf.getIssue()+";"+ts.getTsn()+";2;"+ts.getPre_win_nun()+";"+ts.getPre_win_result()+";" ;
   
        System.out.println(msg) ;
        bSock.send(msg) ;
        return bSock.receive() ;
		
	}

}
