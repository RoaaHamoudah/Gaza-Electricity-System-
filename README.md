# Gaza-Electricity-System

## Project Overview
This project focuses on developing an Electricity Data Management System with a user-friendly interface. 
Using a combined sorted linked list, it handles daily electricity records sourced from a CSV file. Users can add, update, delete, and search records. 
Statistical insights are available, and the system allows for easy saving of modified data.

## Features
1. **File Screen**
- load CSV File
   - Use a file chooser to select the electricity data file and load it into the application.
<br>

2. **Management Screen**
- Insert a New Record
- Update or Delete electricity record
- Search for a Record by Date
<br>

3. **Statistics Screen**
- Daily Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given day across all months and years.
     
- Monthly Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given month across all days and years.
     
- Yearly Electricity Data
   - View specific electricity statistics (e.g., total, average, maximum, minimum) for a given year across all days and months.
     
- Total Statistics for All Data
   - Maximum, Minimum: For Israeli_Lines_MWs, Gaza_Power_Plant_MWs, and Egyptian_Lines_MWs.
   - Total, Maximum, Minimum, Average: For Total_daily_Supply_available_in_MWs, Overall_demand_in_MWs, Power_Cuts_hours_day_400mg, and Temp.
<br>

4. **Save Screen**
- Save the updated linked lists back to a new CSV file in the same format, separated by commas (,).
- Use a file chooser to select the folder where the file will be saved.
<br>

## Project Structure 
- Data Structure: Combined sorted linked lists to manage and process electricity data.
- Input Data: A CSV file containing daily electricity records, including the following fields:
   - Date
   - Israeli_Lines_MWs
   - Gaza_Power_Plant_MWs
   - Egyptian_Lines_MWs
   - Total_daily_Supply_available_in_MWs
   - Overall_demand_in_MWs
   - Power_Cuts_hours_day_400mg
   - Temp
- GUI: JavaFX-based interface for choosing the CSV file, managing records, viewing statistics, and saving data. 
