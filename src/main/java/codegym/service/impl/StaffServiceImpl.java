package codegym.service.impl;

import codegym.models.Staff;
import codegym.repositories.StaffRepository;
import codegym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;


    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff findOne(Long id) {
        return staffRepository.findOne(id);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff delete(Long id) {
        Staff staff = staffRepository.findOne(id);
        staffRepository.delete(id);
        return staff;
    }
}
