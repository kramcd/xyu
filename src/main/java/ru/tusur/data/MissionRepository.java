package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Mission;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer>{

    List<Mission> findByEmployees_Id(int id);

}
