package com.learn.springboot.springbootprojectone.repositories;

import com.learn.springboot.springbootprojectone.domain.*;
import org.springframework.data.repository.*;

public interface BookRepository extends CrudRepository<Book, Long> {
}
