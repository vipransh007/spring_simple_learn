package org.example.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@RestController
public class getAllTheStudentMapping {

    List<String> StudentName = new ArrayList<>(
            List.of("Sneha", "Vipransh", "Lets", "go")
    );

    @GetMapping("/students")
    public List<String> getAllStudents() {
        return StudentName;
    }

    @GetMapping("students/{studentId}")
    public String getStudentById(@PathVariable String studentId) {
        int IndexValue = Integer.parseInt(studentId) - 1;
        System.out.println(IndexValue);
        if (IndexValue < 0) {
            return "Error : You dumb bastard";
        }

        if (IndexValue >= StudentName.size()) {
            return "Error : are you for real you dumb bitch";
        }
        return StudentName.get(Integer.valueOf(IndexValue));
    }

    @GetMapping(value = "/catswow/{statusCode}", produces = "image/*")
    public byte[] getCatswow(@PathVariable String statusCode) {
        String url = "https://http.cat/" + statusCode;
        return RestClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .retrieve()
                .body(byte[].class);
    }
}