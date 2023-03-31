package net.lubosovo.sortedLinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortedLinkedListController {

    @Autowired
    SortedLinkedListService sortedLinkedListService;

    @GetMapping("/int/{index}")
    public Integer getInt(@PathVariable int index) {
        return sortedLinkedListService.getInt(index);
    }

    @PostMapping("/int")
    public void postInt(@RequestBody Integer integer) {
        sortedLinkedListService.addInt(integer);
    }

    @DeleteMapping("/int/{index}")
    public Integer deleteInt(@PathVariable int index) {
        return sortedLinkedListService.removeInt(index);
    }

    @GetMapping("/string/{index}")
    public String getString(@PathVariable int index) {
        return sortedLinkedListService.getString(index);
    }

    @PostMapping("/string")
    public void postString(@RequestBody String string) {
        sortedLinkedListService.addString(string);
    }

    @DeleteMapping("/string/{index}")
    public String deleteString(@PathVariable int index) {
        return sortedLinkedListService.removeString(index);
    }
}
