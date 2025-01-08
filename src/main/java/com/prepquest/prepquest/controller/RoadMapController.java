package com.prepquest.prepquest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prepquest.prepquest.model.RoadMap;
import com.prepquest.prepquest.service.RoadMapService;

@RestController
@RequestMapping("/api/roadmap")
public class RoadMapController {
    

    @Autowired
    public RoadMapService roadMapService;

    // Get All RoadMap
    @GetMapping("/all")
    public ResponseEntity<?> getAllRoadMap() {
        List<RoadMap> roadmap = roadMapService.getAllRoadMap();
        if (roadmap.isEmpty()) {
            return ResponseEntity.ok(Map.of("message", "No Road Map Present"));
        }
        return ResponseEntity.ok(roadmap);
    }

    // Add RoadMap
    @PostMapping("/addroadmap")
    public ResponseEntity<?> addRoadMap (@RequestBody RoadMap roadmap){
        try {
            roadMapService.saveRoadMap(roadmap);
            System.out.println("Course " + roadmap);
            return ResponseEntity.ok(Map.of("message", "Course Added"));
        } catch (Exception e) {
            // Log the exception (you can use a logger here)
            e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "An error occurred: " + e.getMessage()));
        }
    }
}
