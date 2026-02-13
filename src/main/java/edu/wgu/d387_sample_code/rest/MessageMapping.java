package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/messages")
public class MessageMapping {

    @RequestMapping(path = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showWelcomeMessages() throws InterruptedException {

        final String[] messages = new String[2];

        Thread enThread = new Thread(() -> {
            ResourceBundle rb = ResourceBundle.getBundle("welcome", Locale.US);
            messages[0] = rb.getString("hello") + " " + rb.getString("welcome");
        });

        Thread frThread = new Thread(() -> {
            ResourceBundle rb = ResourceBundle.getBundle("welcome", Locale.CANADA_FRENCH);
            messages[1] = rb.getString("hello") + " " + rb.getString("welcome");
        });

        enThread.start();
        frThread.start();

        enThread.join();
        frThread.join();

        return messages;
    }
}
