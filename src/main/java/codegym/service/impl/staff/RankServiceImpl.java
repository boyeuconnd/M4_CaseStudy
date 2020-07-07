package codegym.service.impl.staff;

import codegym.models.Rank;
import codegym.repositories.RankRepository;
import codegym.service.staff.RankService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RankServiceImpl implements RankService {
    @Autowired
    private RankRepository rankRepository;

    @Override
    public Iterable<Rank> showRanks() {
        return rankRepository.findAll();
    }
}
