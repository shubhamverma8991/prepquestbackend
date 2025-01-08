package com.prepquest.prepquest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepquest.prepquest.model.RoadMap;
import com.prepquest.prepquest.repository.RoadMapRepository;

@Service
public class RoadMapService {
    
    @Autowired
    public RoadMapRepository roadmaprepository;

    // Save Indiviual RoadMap
    public RoadMap saveRoadMap(RoadMap roadmap) {
        return roadmaprepository.save(roadmap);
    }

    // Get All RoadMap
    public List<RoadMap> getAllRoadMap() {
        return roadmaprepository.findAll();
    }
}
