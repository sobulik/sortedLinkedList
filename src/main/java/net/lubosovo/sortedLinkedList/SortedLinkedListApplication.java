package net.lubosovo.sortedLinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SortedLinkedListApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortedLinkedListApplication.class, args);
    }

    @Bean
    SortedLinkedList<Integer> i() {
        return new SortedLinkedList<>();
    }

    @Bean
    SortedLinkedList<String> s() {
        return new SortedLinkedList<>();
    }
}
