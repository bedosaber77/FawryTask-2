# Test Cases

### Test Case 1: Adding Books to Inventory
Purpose: Verify that different types of books can be successfully added to the inventory.
Test Steps:

1. Create instances of PaperBook, EBook, and Demo
2. Add each book to the bookstore inventory
3. Display current inventory

Expected Result: All three books should be added successfully with confirmation messages.
![image](https://github.com/user-attachments/assets/fbc1ffd5-721a-4621-8d4d-6b2e6f29cc84)
### Test Case 2: Purchasing Books Successfully
Purpose: Test successful purchase of both paper books and ebooks.
Test Steps:

1. Purchase 2 copies of a paper book (ISBN: 978-1234567890)
2. Purchase 1 copy of an ebook (ISBN: 978-0987654321)
3. Verify correct cost calculation and service calls

Expected Result:
Paper book: $31.98 (2 × $15.99), stock reduced to 8, shipping service called
EBook: $9.99, email service called
![image](https://github.com/user-attachments/assets/da0a865f-3c2c-4ddb-80df-505a4ed88913)
### Test Case 3: Attempting to Buy Demo Books
Purpose: Verify that demo books cannot be purchased.
Test Steps:

. Attempt to buy a demo book (ISBN: 978-1111111111)
2. Verify appropriate error handling

Expected Result: IllegalArgumentException with message "Demo books are not for sale"
![image](https://github.com/user-attachments/assets/dcaea00a-9384-42ac-9c46-d8b24de1ed44)
### Test Case 4: Buying Non-Existent Books
Purpose: Test error handling when attempting to buy books not in inventory.
Test Steps:

1. Attempt to buy a book with non-existent ISBN (978-9999999999)
2. Verify appropriate error message

Expected Result: IllegalArgumentException with message "Book with ISBN 978-9999999999 not found"
![image](https://github.com/user-attachments/assets/53ad0091-215b-4bfb-93e2-b3b449180dd9)
### Test Case 5: Adding Duplicate Books
Purpose: Test system behavior when adding books with duplicate ISBNs.
Test Steps:

1. Add a book with the same ISBN as an existing book
2. Display inventory to show both copies

Expected Result: System throw Error Message "Expected error: Book already exists" 
![image](https://github.com/user-attachments/assets/de81420b-6654-486b-b477-dbb6f7804afd)

### Test Case 6: Removing Outdated Books
Purpose: Test automatic removal of books older than specified years.
Test Steps:

1. Add an old book from 1990
2. Call removeOutdatedBook(30) to remove books older than 30 years
3. Display updated inventory
![image](https://github.com/user-attachments/assets/41b15a81-b62b-4743-ac22-7516ea3a5991)
### Test Case 7: Stock Limitation Validation
Purpose: Test that purchases cannot exceed available stock.
Test Steps:

1. Attempt to buy 20 copies of a paper book with only 8 remaining in stock
2. Verify stock validation error

Expected Result: IllegalArgumentException with message "Quantum book store: quantity exceeds stock"
![image](https://github.com/user-attachments/assets/e89b2bfa-e936-4e31-873d-fe70a10dc28c)

Assumptions
======
1. Duplicate ISBNs: The system allows multiple books with the same ISBN to exist in inventory (e.g., multiple copies or different editions)
2. ISBN Format: ISBN is treated as a simple string identifier without validation of actual ISBN format
3. Service Integration: ShippingService and MailService are external services with simple method signatures
4. Currency: All prices are assumed to be in a single currency (no currency conversion)


