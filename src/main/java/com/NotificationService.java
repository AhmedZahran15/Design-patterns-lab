package com;

import java.util.HashMap;
import java.util.Map;

public class NotificationService {
    private Map<String, User> userNotifications = new HashMap<>();
    
    public void registerForNotification(String title, User user) {
        userNotifications.put(title, user);
    }
    
    public void notifyBookAvailable(String title) {
        if (userNotifications.containsKey(title)) {
            User user = userNotifications.get(title);
            System.out.println("Notification: " + title + " is now available for " + user.getName());
            userNotifications.remove(title);
        }
    }
    
    public boolean hasNotificationsFor(String title) {
        return userNotifications.containsKey(title);
    }
}
