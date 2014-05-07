package ru.tusur.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tusur.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

    Country findByCode (String code);
}
