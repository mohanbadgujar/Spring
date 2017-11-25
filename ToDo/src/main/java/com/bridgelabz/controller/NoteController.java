package com.bridgelabz.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.jsonResponse.Response;
import com.bridgelabz.model.Note;
import com.bridgelabz.model.User;
import com.bridgelabz.services.NoteService;

@RestController
@RequestMapping(value = "/user")
public class NoteController {

	@Autowired
	private NoteService noteService;

	Response response = new Response();

	@RequestMapping(value = "/createnote", method = RequestMethod.POST)
	public ResponseEntity<Response> createNote(@RequestBody Note note, @RequestAttribute("loggedInUser") User user) {
		try {
			noteService.createNote(note, user);
			response.setStatus(1);
			response.setMsg("Note saved");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(-1);
			response.setMsg("Note could not be saved");
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/updatenote", method = RequestMethod.PUT)
	public ResponseEntity<Response> updateNote(@RequestBody Note note, @RequestAttribute("loggedInUser") User user) {
		try {
			noteService.updateNote(note, user);
			response.setStatus(1);
			response.setMsg("Note Updated");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(-1);
			response.setMsg("Note could not be updated");
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/deletenote/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteNote(@PathVariable("id") int id,
			@RequestAttribute("loggedInUser") User user) {
		try {

			noteService.deleteNote(id);
			response.setStatus(1);
			response.setMsg("Note deleted");
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			response.setStatus(-1);
			response.setMsg("Note could not be saved");
			return new ResponseEntity<Response>(response, HttpStatus.CONFLICT);

		}
	}

	@RequestMapping(value = "/allnotes", method = RequestMethod.GET)
	public ResponseEntity<Set<Note>> getNotes(@RequestAttribute("loggedInUser") User user) {

		if (user != null) {
			Set<Note> notes = noteService.getNotes(user.getId());
			return ResponseEntity.ok(notes);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}
}
