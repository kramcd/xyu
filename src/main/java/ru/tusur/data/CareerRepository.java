package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer>{
    Career findById(int id);
}