package com.web.websocket;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public class ChatServer {
    // 存放 Client 端的 session 物件
    private static CopyOnWriteArraySet<Session> sessions;
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client 進入: " + session.getId());
        if(sessions == null) {
            sessions = new CopyOnWriteArraySet<>();
        }
        sessions.add(session);
        System.out.println("歡迎 " + session.getId() + " 加入");
    }
    
}
