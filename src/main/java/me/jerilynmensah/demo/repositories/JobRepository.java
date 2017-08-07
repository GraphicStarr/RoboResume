package me.jerilynmensah.demo.repositories;

import me.jerilynmensah.demo.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository <Job, Long> {
}
