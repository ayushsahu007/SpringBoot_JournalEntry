package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEnteryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEnteryService journalEnteryService;
    private Map<Long,JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEnteryService.findAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        return journalEnteryService.saveEntry(myEntry);
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEnteryService.findById(myId).orElse(null);
    }

       @DeleteMapping("id/{myId}")
    public Boolean deleteJournalEnteryById(@PathVariable ObjectId myId){
           journalEnteryService.deleteById(myId);
           return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
       JournalEntry old = journalEnteryService.findById(id).orElse(null);
       if (old != null){
           old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
           old.setContent(newEntry.getContent() != null &&  !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
       }
       journalEnteryService.saveEntry(old);
        return old;
    }

}

