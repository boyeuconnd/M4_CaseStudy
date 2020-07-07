package codegym.service.impl.staff;

import codegym.models.Status;
import codegym.repositories.StatusRepository;
import codegym.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Iterable<Status> showStatus() {
        return statusRepository.findAll();
    }
}
