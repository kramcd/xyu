package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Career;
import ru.tusur.domain.Employees;
import ru.tusur.domain.Post;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer>{

    Career findById(int id);

    List<Career> findByEmployees_Id(int id);

   // Career findByPost(Post post);

}
