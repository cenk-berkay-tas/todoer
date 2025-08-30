# todoer
Basic REST API for a personal task manager backend.
## API doc
### todos API
- GET `/api/v1/todos` (get all todos)
- GET `/api/v1/todos/{id}` (get a specific todo)
- POST `/api/v1/todos` (insert new todo)
- POST `/api/v1/todos/batch` (batch add a list of todos at once)
- DELETE `/api/v1/todos` (erase all todos)
- DELETE `/api/v1/todos/{id}` (erase a specific todo)
- PATCH `/api/v1/todos/{id}` (update todo status)
### todo request template
```json
{
  "text": "buy groceries"
}
```
### todo response template
```json
{
  "id": 6,
  "text": "buy groceries",
  "createdAt": "2012-04-23T18:25:43.511Z",
  "lastUpdatedAt": "2012-04-23T18:25:43.511Z",
  "status": "TODO"
}
```
### status update request template
```json
{
  "status": "DONE"
}
```
### Options for status
- `TODO`
- `DONE`
- `IN_PROGRESS`
- `ARCHIVED`
