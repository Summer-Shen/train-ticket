package messagequeue.controller;

import messagequeue.entity.NotifyInfo;
import messagequeue.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yunfei Shen
 */
@RestController
@RequestMapping("/api/v1/mqservice")
public class MessageQueueController {

    private final NotificationServiceImpl service;

    @Autowired
    public MessageQueueController(NotificationServiceImpl notificationService) {
        this.service = notificationService;
    }

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ Message Queue Service ] !";
    }

    @PostMapping(value = "/notify/send_cancel_message")
    public boolean send_cancel_message(@RequestBody NotifyInfo info, @RequestHeader HttpHeaders headers) {
        return service.sendNotification(info, headers, "cancel");
    }

    @PostMapping(value = "/notify/send_preserve_message")
    public boolean send_preserve_message(@RequestBody NotifyInfo info, @RequestHeader HttpHeaders headers) {
        return service.sendNotification(info, headers, "preserve");
    }

    @PostMapping(value = "/notify/send_preserve_other_message")
    public boolean send_preserve_other_message(@RequestBody NotifyInfo info, @RequestHeader HttpHeaders headers) {
        return service.sendNotification(info, headers, "preserve_other");
    }

}
