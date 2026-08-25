package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.entity.Staff;
import com.mavenproject.springboot.demo.mycoolapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StaffRestController {

    private final StaffService staffService;
    private final JsonMapper jsonMapper;

    @Autowired
    public StaffRestController(StaffService staffService, JsonMapper jsonMapper) {
        this.staffService = staffService;
        this.jsonMapper = jsonMapper;
    }

    // get all staff
    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffService.findAll();
    }

    // get staff by Id
    @GetMapping("/staffs/{staffId}")
    public Staff getStaff(@PathVariable int staffId) {
        return staffService.findById(staffId);
    }

    // add new staff
    @PostMapping("/staffs")
    public Staff addStaff(@RequestBody Staff theStaff) {

        theStaff.setId(0);

        return staffService.save(theStaff);
    }

    // add list of staff
    @PostMapping("/staffs/batch")
    public List<Staff> addStaffs(@RequestBody List<Staff> theStaffs) {

        // ensure staff is added
        for (Staff staff : theStaffs) {
            staff.setId(0);
        }

        return staffService.saveAll(theStaffs);
    }

    // update staff
    @PutMapping("/staffs")
    public Staff updateEmployee(@RequestBody Staff theStaff) {
        return staffService.save(theStaff);
    }

    // patch staff
    @PatchMapping("/staffs/{staffId}")
    public Staff patchStaff(@PathVariable int staffId, @RequestBody Map<String, Object> patchPayload) {

        Staff tempStaff = staffService.findById(staffId);

        // throw exception if null
        if (tempStaff == null) {
            throw new RuntimeException("Staff Id not found - " + staffId);
        }

        // throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Staff Id not allowed in request body - " + staffId);
        }

        Staff patchedStaff = jsonMapper.updateValue(tempStaff, patchPayload);

        return staffService.save(patchedStaff);
    }


    // delete staff
    @DeleteMapping("/staffs/{staffId}")
    public String deleteStaff(@PathVariable int staffId) {

        staffService.deleteById(staffId);

        return "Deleted staff id - " + staffId;
    }

}
