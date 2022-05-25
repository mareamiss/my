package com.myapp.chat.OnlineServer.Adapter;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class ChatApplication extends Application {

    private io.socket.client.Socket mSocket;
    {

            try {
                mSocket = IO.socket("http://192.168.1.113:3000");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }


    }

    public Socket getSocket() {
        return mSocket;
    }




}
