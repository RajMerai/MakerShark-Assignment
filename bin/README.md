# MarkSharks_Assignment
Makersharks is building a search page where buyers can search for manufacturers based on their customised requirements. We're building a proof of concept for the search API.

**API Endpoints**:

1. /api/supplier/query [ POST ]

**Requirement:**

1. Retrieve a list of X number of manufacturer(s) in a given location, with a specific nature of business, and the capability to perform a specific manufacturing process.
2. Example Query: Fetch a list of small_scale manufacturers onboarded on Makersharks, located in India, and having the capability to perform 3d_printing.
3. Expected Response: The API should return a list of manufacturers matching the given criteria, including their supplier_id, company_name, website, location, nature_of_business, and manufacturing_processes.

CURL:
curl --location --request GET 'http://localhost:8080/api/supplier/query?location=India&natureOfBusiness=SMALL_SCALE&process=THREE_D_PRINTING&size=5' \
--header 'Content-Type: application/json' \
--data '{
        "companyName": "GOAT",
        "website": "www.goat.com",
        "location": "India",
        "natureOfBusiness": "MEDIUM_SCALE",
        "manufacturingProcesses": [
            "THREE_D_PRINTING"
        ]
}'

1. Rate Limiting: Implement rate limiting to avoid abuse of the API - **Pagination Support Added**
2. Input Sanitization: Ensure that all input is sanitized to prevent SQL injection and other attacks - **Optimized SQL query created**
3. Authentication/Authorization: Implement JWT-based authentication to protect sensitive data - **TO DO**
4. Error Handling: Avoid exposing stack traces in production by customizing error responses - **Centralized Exception Handlers Support Added**
