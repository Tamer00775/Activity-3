package kz.sdu.sadp.Activity3.service;

import kz.sdu.sadp.Activity3.entity.TestEntity;
import kz.sdu.sadp.Activity3.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<String> helloWorldText() {
        return testRepository.findAll().stream().map(TestEntity::getText).collect(Collectors.toList());
    }
}
