# Flutter & Kotlin Inter-App Communication via ContentProvider

## Overview
This project consists of two apps (one in Flutter and one in Kotlin) that communicate securely using a ContentProvider. The Kotlin app manages user data, and the Flutter app retrieves and displays this data.

## App 1: Native Android (Kotlin)
### Features:
- Stores and manages user data (Name, Email) in an SQLite database.
- Exposes data securely using a ContentProvider.
- Restricts access to a specific package (Flutter app) with **READ_PERMISSION** and **WRITE_PERMISSION**.
- Provides a UI to add new users and display them in a RecyclerView.

**Kotlin App Repository:** [https://github.com/4ayyappadasks/Resolutekotlinapp]

## App 2: Flutter
### Features:
- Retrieves the user list from the Kotlin app's ContentProvider.
- Displays users in a ListView UI.
- Handles permission issues and gracefully shows an error if access is denied.

## Technical Details
- Uses **MethodChannels** to communicate with native Android code.
- Fetches data securely from the Kotlin app's **ContentProvider**.
- Implements error handling for cases like **provider not found** or **permission denied**.

## Evaluation Criteria
- ✅ Correct implementation of **ContentProvider**
- ✅ Secure **inter-app communication** (permission-based access)
- ✅ Efficient **SQLite operations** in Kotlin
- ✅ Proper use of **MethodChannels** in Flutter
- ✅ Robust **error handling** & **UI/UX considerations**

https://github.com/4ayyappadasks/Resoluteflutterapp/blob/5b2bcfbc0081bb580431c8fa83c397575e82fb08/Screenshot_20250321_135908.png

## How to Run
1. **Install and run the Kotlin app first** to populate the database.
2. **Install and run the Flutter app** to retrieve and display the stored user data.
3. **Ensure both apps have the necessary permissions** for smooth communication.

For the Kotlin app source code, visit: [https://github.com/4ayyappadasks/Resolutekotlinapp]
