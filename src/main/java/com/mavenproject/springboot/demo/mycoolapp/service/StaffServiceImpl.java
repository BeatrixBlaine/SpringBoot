package com.mavenproject.springboot.demo.mycoolapp.service;

import com.mavenproject.springboot.demo.mycoolapp.dao.StaffRepository;
import com.mavenproject.springboot.demo.mycoolapp.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }


    @Override
    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public Staff findById(int id) {

        Optional<Staff> result = staffRepository.findById(id);

        Staff theStaff = null;

        if (result.isPresent()) {
            theStaff = result.get();
        } else {
            throw new RuntimeException("Staff Id not found - " + id);
        }

        return theStaff;
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteById(int id) {
        findById(id);
        staffRepository.deleteById(id);
    }

    @Override
    public List<Staff> saveAll(List<Staff> staffList) {
        return staffRepository.saveAll(staffList);
    }
}
