//package com.intern.demo.Controller;
//
//public class NotificationController {
//}
package com.intern.demo.Controller;
//import com.rapports.demo.exception.ResourceNotFoundException;

import com.intern.demo.exception.ResourceNotFoundException;
import com.intern.demo.Model.Notification;
import com.intern.demo.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/emailnotification")
public class NotificationController {

    @Autowired
    private NotificationRepository emailnotificationRepository;

    @GetMapping("/getNotification")
    public List<Notification> getAllNotification() {
        return emailnotificationRepository.findAll();
    }

    // build create employee REST API
    @PostMapping("/addemailnotification")
    public Notification createNotification(@RequestBody Notification emailnotification) {
        try {
            emailnotification.setnotification_id(emailnotificationRepository.findMaxId() + 1);
            return emailnotificationRepository.save(emailnotification);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable int id) {
        Notification emailnotification = emailnotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not exist with id:" + id));
        return ResponseEntity.ok(emailnotification);
    }

    @PutMapping("/PutNotification/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable int id,@RequestBody Notification emailnotificationDetails) {
        Notification updateNotification = emailnotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not exist with id: " + id));


        updateNotification.setTimestamb(emailnotificationDetails.getTimestamb());
        updateNotification.setUser_id(emailnotificationDetails.getUser_id());
        emailnotificationRepository.save(updateNotification);

        return ResponseEntity.ok(updateNotification);
    }

    @DeleteMapping("/DeleteNotification/{id}")
    public ResponseEntity<HttpStatus> deleteNotification(@PathVariable int id){

        Notification emailnotification = emailnotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        emailnotificationRepository.delete(emailnotification);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}