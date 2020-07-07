package codegym.service.staff;

import codegym.models.Rank;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RankService {
    Iterable<Rank> showRanks();


}
