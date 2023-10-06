//package com.intern.demo.Repository;
//
//public class NotificationRepository {
//}
package com.intern.demo.Repository;
import java.util.List;

//import com.intern.demo.Controller.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;

import com.intern.demo.Model.Notification;
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

    @Query("select coalesce(max(a.notification_id), 0) from Notification a")
    public Integer findMaxId();
}

