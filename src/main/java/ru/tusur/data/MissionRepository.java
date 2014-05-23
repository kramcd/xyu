package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Mission;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Integer>{
}
