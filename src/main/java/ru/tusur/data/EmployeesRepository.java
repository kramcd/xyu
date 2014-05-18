package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Employees findByCode(String code);
}
