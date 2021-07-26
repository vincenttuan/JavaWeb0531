package com.web.websocket;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/chat")
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
        sendAll("歡迎 " + session.getId() + " 加入");
    }
    
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("id=" + session.getId() + " 說:" + message);
        sendAll(message);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("id=" + session.getId() + " 離開");
        if(sessions != null) {
            sessions.remove(session);
            sendAll(session.getId() + "離開了");
        }
    }
    
    private void sendAll(String message) {
        if(sessions != null) {
            for(Session session : sessions) {
                session.getAsyncRemote().sendText(message);
            }
        }
    }
    
}
