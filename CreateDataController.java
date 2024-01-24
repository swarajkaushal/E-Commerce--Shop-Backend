package com.java.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.Repository.UserLocationRepository;
import com.java.entity.UserLocation;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
public class CreateDataController {
	@Autowired
	private UserLocationRepository userLocationRepository;


    @PostMapping("/create_data")
    public ResponseEntity<String> createData(@RequestBody UserLocation userLocation) {
        userLocationRepository.save(userLocation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Data created successfully");
    }
    
    
    @PatchMapping("/update_data/{id}")
    public ResponseEntity<String> updateData(@PathVariable Long id, @RequestBody UserLocation updatedData) {
        Optional<UserLocation> existingData = userLocationRepository.getById(id);
        if (existingData.) {
            UserLocation dataToUpdate = existingData.get();
            // Update fields as needed
            if (updatedData.getLatitude() != 0) {
                dataToUpdate.setLatitude(updatedData.getLatitude());
            }
            if (updatedData.getLongitude() != 0) {
                dataToUpdate.setLongitude(updatedData.getLongitude());
            }
            if (updatedData.isExcluded()) {
                dataToUpdate.setExcluded(true);
            }
            userLocationRepository.save(dataToUpdate);
            return ResponseEntity.ok("Data updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/get_users/{n}")
    public ResponseEntity<List<UserLocation>> getNearestUsers(@PathVariable int n) {
        List<UserLocation> allUsers = userLocationRepository.findByExcludedFalse();
        // Implement logic to find nearest users from (0, 0)
        List<UserLocation> nearestUsers = allUsers.stream()
                .sorted(Comparator.comparingDouble(user -> Math.sqrt(user.getLatitude() * user.getLatitude()
                        + user.getLongitude() * user.getLongitude())))
                .limit(n)
                .collect(Collectors.toList());
        return ResponseEntity.ok(nearestUsers);
    }
    
}


