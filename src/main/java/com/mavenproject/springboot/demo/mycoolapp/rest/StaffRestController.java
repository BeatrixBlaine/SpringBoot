package com.mavenproject.springboot.demo.mycoolapp.rest;

import com.mavenproject.springboot.demo.mycoolapp.entity.Employee;
import com.mavenproject.springboot.demo.mycoolapp.entity.Staff;
import com.mavenproject.springboot.demo.mycoolapp.service.StaffService;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaffRestController {

    private final StaffService staffService;
    private final JsonMapper jsonMapper;

    public StaffRestController(StaffService staffService, JsonMapper jsonMapper) {
        this.staffService = staffService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/staffs")
    public List<Staff> getAllStaff() {
        return staffService.findAll();
    }

    @PostMapping("/staffs")
    public Staff addStaff(@RequestBody Staff theStaff) {

        theStaff.setId(0);

        return theStaff;
    }

    @PostMapping("/staffs/batch")
    public List<Staff> addStaffs(@RequestBody List<Staff> theStaffs) {

        // saving list of employees
        for(Staff staffs : theStaffs){
            staffService.save(staffs);
        }

        return theStaffs;
    }

}
