# StarSeeker

StarSeeker is an Android application designed to help you explore the Star Wars universe by providing detailed information about characters, planets, species, and films from the franchise.

## Introduction

StarSeeker leverages modern Android development practices, including Jetpack libraries and Hilt for dependency injection, to deliver a seamless user experience.

## Features

- *Search Characters:* Look up your favorite Star Wars characters using the search functionality.
- *View Character Details:* Dive deeper into character details, including their home planet, species, and featured films.

## Project Structure

The project consists of four modules:

- *Network:* Contains networking-related code, including Retrofit setup and API service interfaces.
- *Feature:* Houses the main functionalities of the app, including the Search and Detail features.
- *Design:* Contains resources related to UI design, including layouts, styles, and drawables.
- *App Layer:* The main app module that integrates all other modules and defines the app's entry point.
- *buildSrc:* The project utilizes the buildSrc module for managing project dependencies.

Within the Feature module, there are two features:

- *Search:* Allows users to search for Star Wars characters.
- *Detail:* Displays detailed information about a selected character.

Each feature follows the Clean Architecture, comprising three layers:

- *Presenter:* Manages UI logic and interaction, including ViewModels for each feature.
- *Domain:* Contains business logic and data models representing entities relevant to the feature.
- *Data:* Handles data retrieval and manipulation, including repositories and use cases.

Dependency injection is utilized for building the source, with Hilt being the chosen framework.

## Current Status

This project, developed within three working days, requires improvement in UI and implementation of various states. Additionally in the future, I plan to incorporate UI testing using Jetpack Compose UI testing frameworks. Currently, the project is in version 1.0.0.

## Technologies Used

- *Jetpack Libraries:* Utilize ViewModel and StateFlow for managing UI-related data, lifecycle, and interactions within the Model-View-Intent (MVI) architecture pattern.
- *Hilt:* Employed for dependency injection, ensuring modular and testable code.
- *Retrofit:* Networking library for making API requests to retrieve Star Wars data.
- *Gson:* JSON serialization/deserialization library integrated with Retrofit for parsing API responses.
- *Coroutines:* Manage asynchronous programming tasks, enhancing app responsiveness.
- *AndroidX Libraries:* Core KTX, Lifecycle Runtime, Activity Compose, Espresso
- *Testing Frameworks:* JUnit, Mockito-Kotlin, MockK, Coroutines Test

We utilize the Model-View-Intent (MVI) architecture pattern for managing UI state and interactions

## Getting Started

To run StarSeeker on your device:

1. Clone the repository from https://github.com/LeilaYaghoobi70/StarSeeker.
2. Open the project in Android Studio.
3. Build and run the app on your preferred device or emulator.

## Contributing

Contributions to StarSeeker are welcome! If you have any ideas for features, bug fixes, or improvements, feel free to submit a pull request.


