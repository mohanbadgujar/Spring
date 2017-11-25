package com.bridgelabz.services;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.dao.NoteDao;
import com.bridgelabz.model.Note;
import com.bridgelabz.model.User;

public class NoteService {
	
	@Autowired
	private NoteDao noteDao;

	@Transactional
	public void createNote(Note note, User user) {
		
		note.setUser(user);
		Date createDate = new Date();
		note.setCreatedAt(createDate);
		note.setModifiedAt(createDate);
		
		noteDao.createNote(note);
	}

	@Transactional
	public boolean updateNote(Note note, User user) {
		Note oldNote = noteDao.getNoteById(note.getNoteId());
		
		if (user.getId() == oldNote.getUser().getId()) {
			
			Date modified = new Date();
			oldNote.setModifiedAt(modified);
			oldNote.setTitle(note.getTitle());
			oldNote.setDescription(note.getDescription());
			
			noteDao.updateNote(oldNote);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public void deleteNote(int noteId) {
		Note note = new Note();
		note.setNoteId(noteId);
		noteDao.deleteNote(note);
	}

	public Set<Note> getNotes(int id) {
		
		return noteDao.getNotes(id);
	}

}
