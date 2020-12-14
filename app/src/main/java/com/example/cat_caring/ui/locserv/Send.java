package com.example.cat_caring.ui.locserv;

import android.util.Log;

import com.example.cat_caring.ui.activity.location;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.Socket;



public class Send implements Runnable {
    private String Ip = "192.168.0.112";
    private Integer port = 8181;
    private JSONObject jsonObject;
    private Socket socket;
    private OutputStream outputStream;
    private Send_InputStream inputStream;
    private location mainActivity;


    public Send(){}
    public Send(location mainActivity){
        this.mainActivity = mainActivity;
    }
    public String getIp() {
        return Ip;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public Socket getSocket() {
        return socket;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    private void startSocket(){
        try{
            socket = new Socket(Ip,port);
            Log.i("128","连上了");
            outputStream = socket.getOutputStream();
            inputStream = new Send_InputStream(socket.getInputStream());
            inputStream.setMainActivity(mainActivity);
            new Thread(inputStream).start();
        }catch (Exception e){
            Log.i("128",e.getMessage()+"报错");
        }

    }
    @Override
    public void run() {
        try{
            startSocket();
            jsonObject = new JSONObject();
            while (socket != null){
                Thread.sleep(3000);
                jsonObject.put("lat",location.getLat());
                jsonObject.put("lng",location.getLng());
                outputStream.write(jsonObject.toString().getBytes("UTF-8"));
                outputStream.flush();
                Log.i("128",jsonObject.toString()+"上传的数据");
            }
        }catch (Exception e){
            Log.i("128",e.getMessage()+"上传出错");
        }finally {
            if (outputStream != null){
                try {
                     outputStream.close();
                }catch (Exception e){
                      Log.i("128",e.getMessage()+"关闭出错");
                }
            }
            if(socket != null){
                try{
                    socket.close();
                }catch (Exception e){
                    Log.i("128",e.getMessage()+"关闭出错");
                }
            }
        }


    }
}
