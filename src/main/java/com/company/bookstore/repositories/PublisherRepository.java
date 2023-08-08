
package com.company.bookstore.repositories;

import com.company.bookstore.controllers.PublisherController;
import com.company.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
