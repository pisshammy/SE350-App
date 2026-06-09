# SE350-App

## Final Submission README

This program is a stat tracker and analyzer for [Kovaaks Aim Trainer](https://store.steampowered.com/app/824270/KovaaKs/). Aim training is an important part for many competitive gamers so knowing progression over time is important.

In KovaaK's, scenarios are typically 1-minute-long maps created by the community to practice certain aiming techniques. Aim Trainers are typically played by competitive gamers who strive to increase their aiming within shooter games. Scenarios can be made with many differents including different enemy types, user and enemy movement types, speeds, and location, as well and different guns with different shooting speed, different ammo capacities, and reload times.

When fnishing a Kovaaks scenario/map, the game automatically exports static .csv files containing the user's performance data for each run the user completes. 
The static files contain a ton of complex data that can matter at a high level of play. Aim is a crucial skill in competitive gaming, analyzing the performance data helps players identify areas for improvement.

## Some of the possible data present in the csv files that could be tracked and analyzed include:

- the date the run of a scenario was completed
- scenario name
- run duration or time remaining if the user dies
- total accuracy within the run
- weapon name, type, and stats such as fire rate, reload time, and ammo capacity
- sensitivity and DPI (dots per inch) in settings of the player
= average FPS (frames per second) of the run and max FPS set in config
- screen resolution, resolution scale, and FOV (field of view),
- crosshair name, color, and scale
- game version
- distance traveled, fight time, deaths, and overshots
- scenario user pause count and duration

## App UML diagram

![UML DIAGRAM](<UML SE350 Final App Hammy.png>)

### Issues & Resolutions

- **Git Configuration:** Some commits were accidentally made under the username `BamhamYT` instead of my primary account `hammyo-o`. I lated switched my github name to `pisshammy`, so the project has been completed by me, hammy, alone. 

- **Observer Pattern:** I initially planned to implement the Observer pattern to allow updates to the GUI. But, as no GUI was ever developed, I did not implement the Observer pattern as I intended. I made a resolution to this by creating new simulated runs every 2 seconds that updated the metrics and printed them to the console, demonstrating how the Observer pattern would work in a real-time scenario.

## PreviouslyPlanned Libraries

- **GUI:** JavaFX. Never implemented, but planned to use for the user interface to display metrics and  visualizations of the data with graphs. 
- **JUnit:** For unit testing metric calculations. Did not implement/was not required for the current implementation, but planned to use it testing the accuracy and reliability of the metric calculations when the data tracking was more advanced.

## Implemented Libraries
- **OpenCSV:** For parsing the .csv files. Implemented in `OpenCsvAdapter.java`.
 

### How to Run

This project uses Maven for dependency management and execution. Do not compile manually.

To clean, compile, and run the application, execute the following commands in the root directory:

```bash
mvn clean compile
mvn exec:java "-Dexec.mainClass=Main"
