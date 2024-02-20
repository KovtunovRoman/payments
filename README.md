# CRUD operations

Для запуска приложения используйте сервис income-service в модуле income-container.

## Postman
Для тестирования функционала вы можете использовать Postman.

### Create
- Method: POST
- URL: http\://localhost:8080/api/v1/income/notification/create или createAll
- Body (Json):  
```json
  {
  "notificationNumber": "2",
  "status": "AGREED"
  }
```

### Read
- Method: GET
- URL: http\://localhost:8080/api/v1/income/notification/read или readAll
- Param (String id) тип UUID:
  http\://localhost:8080/api/v1/income/notification/read?id=bcf414a4-c5d1-4ea3-937f-0b09161c165a


### Update
- Method: PUT
- URL: http\://localhost:8080/api/v1/income/notification/update или updateAll
- Param (String id) тип UUID + Body (Json)

### Delete
- Method: DELETE
- URL: http\://localhost:8080/api/v1/income/notification/delete или deleteAll
- Param (String id) тип UUID