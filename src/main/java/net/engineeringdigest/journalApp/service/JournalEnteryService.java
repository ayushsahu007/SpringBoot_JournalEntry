package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEnteryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEnteryService {

    @Autowired
    private JournalEnteryRepository journalEnteryRepository;

    public JournalEntry saveEntry(JournalEntry journalEntry){
        return journalEnteryRepository.save(journalEntry);
    }

    public List<JournalEntry> findAll(){
        return journalEnteryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEnteryRepository.findById(id);
    }

     public void deleteById(ObjectId id){
        journalEnteryRepository.deleteById(id);
     }




}
