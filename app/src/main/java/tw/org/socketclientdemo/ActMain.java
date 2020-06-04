package tw.org.socketclientdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.SocketHandler;

public class ActMain extends AppCompatActivity{

    private View.OnClickListener btnSend_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{

                String account = "nihao";
                Socket remote = new Socket("140.116.180.100", 10288);
                DataOutputStream streamOut = new DataOutputStream(remote.getOutputStream());

                String name = "";
                for(int i=0;i<30;i++){
                    name+="";
                }

                String pic="\n"+
                        "┴┬┴┬／￣＼＿／￣＼\n" +
                        "┬┴┬┴▏　　▏▔▔▔▔＼\n" +
                        "┴┬┴／＼　／　　　　　　﹨\n" +
                        "┬┴∕　　　　　　　／　　　）\n" +
                        "┴┬▏　　　　　　　　●　　▏\n" +
                        "┬┴▏　　　　　　　　　　　▔█◤\n" +
                        "┴◢██◣　　　　　　 ＼＿＿／\n" +
                        "┬█████◣　　　　　　　／\n" +
                        "┴█████████████◣\n" +
                        "◢██████████████▆▄\n" +
                        "◢████████████\n" +
                        "。。。○";

                String pic2="\n";;

                streamOut.writeUTF(
                            account+"@"+
                                lblContact.getText().toString()+"@"+pic);
                                /*+lblInput.getText().toString()*/

                DataInputStream streamIN = new DataInputStream(remote.getInputStream());

                String data = streamIN.readUTF();
                lblShow.setText(data);
                remote.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);

        StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy( policy);

        InitialComponent();

    }

    private void InitialComponent() {
        lblInput=findViewById(R.id.lblInput);
        lblShow=findViewById(R.id.lblShow);
        lblContact=findViewById(R.id.lblContact);
        btnSend =findViewById(R.id.btnSend);
        btnSend.setOnClickListener(btnSend_Click);

    }
    EditText lblInput;
    EditText lblContact;
    TextView lblShow;
    Button btnSend;
}
