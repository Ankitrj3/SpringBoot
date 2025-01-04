

To interact with MongoDB using Postman and perform operations like GET, POST, PUT, and DELETE on a Spring Boot application connected to MongoDB, here’s a detailed guide:

---

### **Step 1: Install MongoDB Locally**
1. **Download MongoDB** from [here](https://www.mongodb.com/try/download/community).
2. Configure Spring Boot to connect to MongoDB by adding the following properties in your `application.properties`:
   ```properties
   spring.data.mongodb.host=localhost
   spring.data.mongodb.port=27017
   spring.data.mongodb.database=yourDatabaseName
   spring.data.mongodb.auto-index=true
   ```

---

### **Step 2: MongoDB Basics**
- **SQL Equivalent Terms in MongoDB**:
  - Rows → Documents
  - Columns → Fields
  - Tables → Collections
- **Commands to get started**:
  1. `show dbs` - Lists all databases.
  2. `use databaseName` - Switch to a specific database or create one.
  3. `show collections` - Lists collections in the database.
  4. `db.collectionName.find()` - Fetches documents in a collection.
  5. `db.dropDatabase();` - Drops the current database.

---

### **Step 3: Spring Boot Application Setup**
1. Create REST endpoints in your Spring Boot application for CRUD operations:
   - **GET**: Fetch data from MongoDB.
   - **POST**: Add new data to MongoDB.
   - **PUT**: Update existing data in MongoDB.
   - **DELETE**: Remove data from MongoDB.

2. Example `application.properties` for **MongoDB Atlas**:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<databaseName>?retryWrites=true&w=majority
   ```

---

### **Step 4: Test API with Postman**
1. **Setup Postman**:
   - Install Postman from [here](https://www.postman.com/downloads/).
   - Open Postman and create a new collection for your API testing.

2. **Perform Operations**:
   - **GET**:
     - Method: `GET`
     - URL: `http://localhost:8080/endpoint`
   - **POST**:
     - Method: `POST`
     - URL: `http://localhost:8080/endpoint`
     - Body: Use `raw` and select `JSON` to send data, e.g.:
       ```json
       {
         "field1": "value1",
         "field2": "value2"
       }
       ```
   - **PUT**:
     - Method: `PUT`
     - URL: `http://localhost:8080/endpoint/{id}`
     - Body: Update data in JSON format.
   - **DELETE**:
     - Method: `DELETE`
     - URL: `http://localhost:8080/endpoint/{id}`

3. Send requests and verify responses from your Spring Boot application.

---

### **Step 5: Notes on Transactions**
When using the `@Transactional` annotation in Spring Boot:
- It ensures atomicity for operations involving MongoDB.
- MongoDB Atlas must be used with replica sets for full transaction support.

---
