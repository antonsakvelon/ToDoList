# ToDoList
This is a simple app for managing to-dos. The following functions are supported:
- adding todos (you can choose the todo's name, descripton and date)
- displaying all of them or only the daily ones in a list (with a possibility to delete them, mark as done/not done, open details to edit)
- choosing to display either all of the daily todos or only the ones that are not done yet

# Implementation steps
- created the app's project (in three modules: app, domain and data which represent corresponding layers of the app), also added the base classes
- designed the entities and the local database scheme, implemented domain and data layers
- implemented the app's UI
- added tests for the app's screens

# Issues faced (with resolutions steps)
- Working with date was hard, I had to sit down with the documentation for the Date and Calendar classes and look for the fuctions that I needed (settings/getting date, operations with the parts of the date)
- Espresso tests won't launch because of Android Studio trying to execute them with JUnit. Fixed by googling the solution and finding a corresponding StackOverflow question
- I forgot almost everything that I knew about the UI tests and particularly Espresso, so had to learn this all again. Took a Google's codelab on UI testing, watched a bit of Google I/O videos
- Multiple minor issues, that I've resolved really quick

# What could be done better to improve the app's quality
- add some DESIGN to the app (for now it's absolutely awful): views, Toolbar's title, colors, etc.
- add custom styles for the text views to prevent duplicate code in layout files
- improve code quality regarding the operations with date, add the ability to select time for the todo (it may be later used for notifications)
- redesign the app's navigation system (Navigation component is not needed for such simple navigation, only used it because I had a thumbnail of BottomNavigationBar with NavigationComponent)
- refactor the code to remove the duplicates and spaghetti blocks; for example, there is no need to have both TodayFragment and AllFragment
- implement unit tests and more UI tests
