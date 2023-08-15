# API Test Tool with JavaFX
<img width="422" alt="Screenshot 2023-05-31 121434" src="https://github.com/Naveenad2/API-Test-Tool-with-JavaFX/blob/main/src/main/resources/com/apitool/apitool/Screenshot%202023-08-15%20212407.png">

Welcome to the API Test Tool with JavaFX! This is a powerful yet user-friendly JavaFX application designed to simplify API testing and response analysis. Whether you're a developer, QA engineer, or someone interested in understanding APIs better, this tool can be an asset in your toolkit.

## Introduction

The API Test Tool is built with JavaFX and provides a simple yet effective interface for sending HTTP requests and examining the corresponding responses. It's designed to help you thoroughly test APIs without the need for complex setups or external tools. This tool promotes efficient testing, streamlines your workflow, and aids in identifying potential issues in API interactions.

## Features

The API Test Tool currently includes:

- **Request Methods:** Send GET, POST, PUT, and DELETE requests to API endpoints.
- **Request Headers:** Customize headers to simulate real-world scenarios and explore various use cases.
- **Request Body:** For POST and PUT methods, include JSON or other data in the request body.
- **Response Analysis:** View API responses in a well-organized format for easy understanding.
- **Modular Design:** The tool uses an interface-based approach for response handling, ensuring flexibility for future expansion.
- **User-Friendly Interface:** Built using JavaFX, the UI provides an intuitive experience, making interactions smooth and productive.

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/api-test-tool.git

2. **Open and Build with Maven:**
Open a terminal in the project directory and build the project using Maven:
    ```bash
    cd api-test-tool
    mvn clean package

3.**Run the Application:**
After building the project, run the JavaFX application using Maven:
    ```bash
    mvn javafx:run
    
4.**Send Your First Request:**

 - Enter the API endpoint URL in the designated field.
 - Choose the appropriate request method (GET, POST, PUT, DELETE).
 - Add any necessary request headers.
 - If applicable, enter the request body content.
 - Click the "Send Request" button to initiate the API request.

5.**Analyze the Response:**
Once the response is received, the tool will display it in the response text area. Examine the status code, headers, and response body to evaluate the outcome of your request.

## Prerequisites
Before getting started, make sure you have the following:

- Java Development Kit (JDK) 8 or later
- JavaFX libraries (included in most modern JDK distributions)
- Apache Maven (for building and running the project)

## Contributions
Contributions to this project are greatly appreciated. If you have ideas for new features, improvements, or bug fixes, feel free to fork the repository, make your changes, and submit a pull request.

## Contact
For questions or feedback, you can reach out to me at naveenad260@gmail.com. We'd love to hear from you!
