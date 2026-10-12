# Weather App

A desktop weather application built with **Java** and **JavaFX**. Enter a city name and the app fetches a **7-day forecast** from the [OpenWeatherMap API](https://openweathermap.org/api), showing temperature, conditions, and wind details. You can open multiple tabs to track several cities side by side.

> This was my first Java project, built as a course project in the Department of CSE, SUST.

---

## Features

- **City search** – look up weather for over 74,000 cities by name (matched to OpenWeatherMap city IDs via a bundled lookup file).
- **7-day forecast** – today's weather plus the next six days.
- **Detailed conditions** for each day:
  - Day temperature, max and min (°C)
  - Weather description with icon
  - Cloud cover, pressure, and humidity
  - Wind speed and wind direction (degrees + compass point, e.g. `225° SW`)
- **Multi-city tabs** – open a new tab for each city you want to follow.
- **Refresh** – re-fetch the latest data for any city.
- **Error handling** – friendly dialogs for "City Not Found" and "No Internet Connection".
- **About** window with project and author info.

## Tech Stack

| Component | Technology |
|-----------|------------|
| Language | Java (source/target 1.7) |
| UI | JavaFX with FXML layouts and CSS styling |
| Build | Maven |
| JSON parsing | [`org.json`](https://github.com/stleary/JSON-java) (20151123) |
| Data source | OpenWeatherMap API (`/data/2.5/forecast/daily`) |
| IDE | NetBeans (project files included) |

## Project Structure

```
Weather-App/
└── Weather_App/
    ├── pom.xml                         # Maven build configuration
    ├── nbactions.xml                   # NetBeans run/debug actions
    └── src/main/
        ├── java/
        │   ├── weather/app/
        │   │   └── WeatherApp.java     # Entry point; loads city → ID map
        │   ├── FXML/
        │   │   ├── Scene1Controller.java        # Home screen: city search
        │   │   ├── Scene2Controller.java        # Forecast view with tabs
        │   │   ├── CustomScene1Controller.java  # City search inside a new tab
        │   │   ├── Untitled2Controller.java     # Forecast view for added tabs
        │   │   ├── Reset2Controller.java        # Refresh/reload logic
        │   │   └── Scene4Controller.java        # About window
        │   └── Icon/                   # Weather condition icons
        └── resources/FXML/
            ├── *.fxml                  # UI layouts
            ├── style.css, style2.css   # Stylesheets
            ├── country_code.txt        # City name → OpenWeatherMap ID lookup
            └── *.jpg / *.png           # Background images
```

## Getting Started

### Prerequisites

- **JDK 8 with JavaFX bundled** (e.g. Oracle JDK 8, or Azul Zulu / Liberica "FX" builds of JDK 8). The build references `jfxrt.jar` and `javafxpackager` from the JDK, so newer JDKs without JavaFX will not work out of the box.
- **Maven 3.x**
- An **OpenWeatherMap API key** (see [OpenWeatherMap API](https://openweathermap.org/api)).
- An internet connection.

### Clone

```bash
git clone https://github.com/mahirsust/Weather-App.git
cd Weather-App/Weather_App
```

### Build and Run (command line)

```bash
mvn clean package
java -jar target/Weather_App-1.0-SNAPSHOT.jar
```

### Run with NetBeans

1. Open NetBeans and choose **File → Open Project**.
2. Select the `Weather_App` folder.
3. Click **Run** — the included `nbactions.xml` handles packaging and launching.

## Configuration

The API key is currently hard-coded in the controllers. Replace it with your own key in each of the following places:

- `Scene1Controller.java`
- `Scene2Controller.java`
- `Untitled2Controller.java`
- `Reset2Controller.java`

Look for a line like:

```java
String default2 = "&units=metric&cnt=7&APPID=YOUR_API_KEY";
```

You can get a key by signing up at [openweathermap.org](https://home.openweathermap.org/users/sign_up).

## Usage

1. Launch the app.
2. Type a city name (e.g. `dhaka`, `london`, `moscow`) and press **Enter**.
3. Browse the forecast for today and the next six days.
4. Click **New Tab** to add another city, or **Refresh** to update the data.
5. Click **About** for project information.

> **Tip:** City names are matched case-insensitively against `country_code.txt`. Multi-word city names are stored without spaces (e.g. `newyork`), so type them the same way.

## Known Limitations

- **API endpoint availability:** the app uses OpenWeatherMap's `forecast/daily` endpoint, which is no longer available on the free plan. You may need a paid subscription, or update the code to use the free `/data/2.5/forecast` (5-day / 3-hour) or One Call API.
- **Hard-coded API keys** are committed in the source; they should be moved to a config file or environment variable and revoked.
- Requires an older JavaFX-bundled JDK (Java 7/8 era build setup).
- The `target/` build directory is checked into the repository.
- Window size is fixed at 800×600.

## Possible Improvements

- Load the API key from an environment variable or properties file.
- Migrate to a current OpenWeatherMap endpoint.
- Upgrade to a modern JDK with OpenJFX via Maven dependencies.
- Reduce duplicated parsing code across controllers.
- Add a °C/°F toggle and search suggestions.

## Author

**Muhammad Mahir Hasan Chowdhury**
CSE '13 Batch, Shahjalal University of Science and Technology (SUST)
📧 mahirhasancse@gmail.com

**Supervisor:** Md. Eamin Rahman, Assistant Professor, Dept. of CSE, SUST

## Acknowledgements

- Weather data and icons from [OpenWeatherMap](https://openweathermap.org/).
- JSON parsing by [JSON-java (org.json)](https://github.com/stleary/JSON-java).
