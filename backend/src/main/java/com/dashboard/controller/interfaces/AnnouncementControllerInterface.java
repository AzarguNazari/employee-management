package com.dashboard.controller.interfaces;

import com.dashboard.model.Announcement;
import com.dashboard.model.Employee;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AnnouncementControllerInterface {

    @PostMapping
    @ApiResponses(value = {@ApiResponse(description = "Successfully created a new announcement",
            responseCode = "201",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> createAnnouncement(@RequestBody Announcement announcement);

    @GetMapping
    @ApiResponses(value = {@ApiResponse(description = "Get all announcements",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getAllEmployees();

    @GetMapping("/{announcementID}")
    @ApiResponses(value = {@ApiResponse(description = "Get an attendance with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> getEmployeeById(@PathVariable Integer announcementID);

    @DeleteMapping("/{announcementID}")
    @ApiResponses(value = {@ApiResponse(description = "Delete an announcement with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> deleteEmployeeById(@PathVariable Integer announcementID);

    @PutMapping("/{announcementID}")
    @ApiResponses(value = {@ApiResponse(description = "Update an announcement with specific ID",
            responseCode = "200",
            content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
    ResponseEntity<?> updateEmployee(@PathVariable Integer announcementID, @RequestBody Announcement announcement);
}
