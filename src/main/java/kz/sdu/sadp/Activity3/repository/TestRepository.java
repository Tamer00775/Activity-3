package kz.sdu.sadp.Activity3.repository;

import kz.sdu.sadp.Activity3.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
