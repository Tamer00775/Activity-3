package kz.sdu.sadp.Activity3.resource;

import kz.sdu.sadp.Activity3.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestResource {
    private final TestService testService;

    @GetMapping
    public ResponseEntity<List<String>> helloWorld() {
        return ResponseEntity.ok(testService.helloWorldText());
    }

}
