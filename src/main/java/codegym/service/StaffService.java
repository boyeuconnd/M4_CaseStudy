package codegym.service;

import codegym.models.Staff;
import codegym.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {


    Page<Staff> findAll(Pageable pageable);

    Staff findOne(Long id);

    Staff save (Staff staff);

    Staff delete(Long id);
}

