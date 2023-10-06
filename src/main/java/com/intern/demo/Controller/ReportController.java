
package com.intern.demo.Controller;
//import com.rapports.demo.exception.ResourceNotFoundException;

import com.intern.demo.Model.Notification;
import com.intern.demo.exception.ResourceNotFoundException;
import com.intern.demo.Model.Report;
import com.intern.demo.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/Report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/getReport")
    public List<Report> getAllReport() {
        try{
            var a =  reportRepository.findAll();
            return a ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
return null;
    }

    // build create employee REST API
//    @PostMapping("/addReport")
//    public Report createReport(@RequestBody Report report) {
//        try {
//            return reportRepository.save(report);
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @PostMapping("/addReport")
    public Report createReport(@RequestBody Report report) {
        report.setReport_id(reportRepository.findMaxId()+1);
        return reportRepository.save(report);
    }


    @GetMapping("{id}")
    public ResponseEntity<Report> getReportById(@PathVariable int id) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not exist with id:" + id));
        return ResponseEntity.ok(report);
    }

    @PutMapping("/PutReport/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable int id,@RequestBody Report adminDetails) {
        Report updateReport = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not exist with id: " + id));

        updateReport.setUser_id(adminDetails.getUser_id());
        updateReport.setPost_id(adminDetails.getPost_id());
        updateReport.setContent_id(adminDetails.getContent_id());
        updateReport.setTimestamp(adminDetails.getTimestamp());
        reportRepository.save(updateReport);

        return ResponseEntity.ok(updateReport);
    }

}