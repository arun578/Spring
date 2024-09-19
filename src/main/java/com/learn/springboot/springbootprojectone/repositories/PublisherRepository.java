package com.learn.springboot.springbootprojectone.repositories;

import com.learn.springboot.springbootprojectone.domain.*;
import org.springframework.data.repository.*;

public interface PublisherRepository  extends CrudRepository<Publisher, Long> {
}
