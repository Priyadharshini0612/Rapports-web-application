//package com.intern.demo.Repository;
//
//public class NotificationRepository {
//}
package com.intern.demo.Repository;
import java.util.List;

//import com.intern.demo.Controller.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;

import com.intern.demo.Model.Report;
public interface ReportRepository extends JpaRepository<Report, Integer>{
//    static Notification save(Notification emailnotification) {
//    }

    @Query("select coalesce(max(a.report_id), 0) from Report a")
    public Integer findMaxId();
}

