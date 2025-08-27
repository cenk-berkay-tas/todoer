# todoer
Basic REST API for a personal task manager.
# API doc
## todos
- GET `/api/v1/todos?text=` (get all todos, with optional text filtering)
- GET `/api/v1/todos/{id}` (get todo with specific id)
- POST `/api/v1/todos` (insert new todo)
- DELETE `/api/v1/todos` (erase all todos)
- DELETE `/api/v1/todos/{id}` (erase todo with id)
- PUT `/api/v1/todos/{id}` (change todo with id)
- PATCH `/api/v1/todos/{id}` (partially change todo with id)
- OPTIONS `/api/v1` (get help)
## todo template
```json
{
  "id": 6,
  "text": "buy groceries",
  "createdAt": "2012-04-23T18:25:43.511Z",
  "lastUpdatedAt": "2012-04-23T18:25:43.511Z",
  "status": "DONE"
}
```
## Options for status
- TODO
- DONE
- IN PROGRESS
- ARCHIVED
# TODO list
- [ ] add DELETE, PUT and OPTIONS
