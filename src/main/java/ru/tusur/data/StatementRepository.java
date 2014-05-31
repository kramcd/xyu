package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Statement;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer>{

    List<Statement> findByEmployees_Id(int id);

}
