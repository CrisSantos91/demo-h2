package com.example.jwt.repository;

import com.example.jwt.entity.Usuario;
import com.example.jwt.model.CardsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select u from users u")
    List<Usuario> devolveCaree();

//    @Query(value = "select u from users u where rownum() < 21")
//    List<Usuario> findFirstTwenty();
//    Usuario findByCaree(String career);


    Usuario getById(Long id);

    @Query(value = "select u from users u left join cards c on c.user = u")
    List<Usuario> findAll();

    @Transactional
    @Modifying
    @Query(value = " insert into  users (first_name, last_name, career) " +
            "values (:first_name, :last_name, :career)", nativeQuery = true )
    void createUser (@Param("first_name") String first_name, @Param("last_name") String last_name, @Param("career") String career);

    @Transactional
    @Modifying
    @Query(value = " insert into  cards (type, category, user_id) values " +
            "(:type, :category, :userId)", nativeQuery = true )
    void createCard(@Param("type") String type, @Param("category") String category, @Param("userId") int userId);
}
