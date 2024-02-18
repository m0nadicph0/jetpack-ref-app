# Jetpack Compose Supabase App

This is a Jetpack Compose app with Supabase as the backend. The app includes features like user authentication, a dashboard, and contacts management.

## Features

- User authentication (Sign In, Sign Up) using Supabase.
- Dashboard screen.
- Contacts management (List, View, Add, Edit, Delete).
- Profile screen displaying user details.

## Getting Started

### Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/your-repo.git
cd your-repo
```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or a physical device.

## Supabase Setup

1. Create an account on [Supabase](https://supabase.io/).
2. Set up a new project and obtain the API URL and key from your Supabase dashboard.
3. Replace the placeholders in your project with the Supabase credentials.


## Usage

The app is structured following the MVVM architecture. Navigate through the screens using Jetpack Compose's `NavHost` and `NavController`. User authentication state is managed using SharedPreferences.

