# Student Register App

Welcome to the Student Register app! This simple Android application is designed to help you learn and practice Room Database in Android development. The app allows you to manage student registrations by providing functionalities to save, update, and delete student records.

## Features

- **Save Student:** Add new students to the database by entering their name and email.

- **Update Student:** Modify the details of an existing student.

- **Delete Student:** Remove a student from the database.

## Getting Started

To get started with this app, follow these steps:

1. **Clone the Repository:**
   Clone the repository to your local machine using the following command:
   ```
   git clone https://github.com/iampranshu2003/StudentRegister.git
   ```

2. **Open in Android Studio:**
   Open the project in Android Studio to explore the code and run the app.

3. **Run the App:**
   Run the app on an Android emulator or a physical Android device to see it in action.

## Code Overview

The main components of the app include:

- **MainActivity:** The main entry point of the app, responsible for handling user interactions and managing the UI.

- **StudentViewModel:** A ViewModel class that provides data to the UI and handles user interactions. It interacts with the Room Database through the Data Access Object (DAO).

- **StudentRecyclerViewAdapter:** An adapter for the RecyclerView in the app, responsible for displaying the list of students.

- **StudentDatabase:** The Room Database instance for storing student records.

## How to Use

- **Add New Student:**
  Enter the student's name and email, then click the "Save" button.

- **Update Student:**
  Click on an existing student in the list, modify the details, and click the "Update" button.

- **Delete Student:**
  Click on an existing student in the list and click the "Delete" button.

- **Clear Fields:**
  Use the "Clear" button to reset the input fields.

## Learnings

This app is a great resource for learning about:

- Room Database implementation in Android.
- ViewModel and LiveData usage.
- RecyclerView setup and interaction.

Feel free to explore the code, make modifications, and experiment with additional features. Happy coding!
