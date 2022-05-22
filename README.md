# BitlyInternChallenge

## Dependencies 
JDK 18.0.1 </br> (link to install: https://www.oracle.com/java/technologies/downloads/#jdk18-windows) </br>
Git </br> (link to install: https://git-scm.com/downloads) </br>
Gradle 7.4.2 </br> (link to install: https://gradle.org/install/) </br>

*If you do not already have gradle installed, make sure to follow all the instructions on that page - it will walk you through how to update the Environment Variable.*
## Instructions
Open the command prompt in the desired folder and enter the following commands: </br>
```
git clone https://github.com/maddieannison/BitlyInternChallenge.git 
cd BitlyInternChallenge 
gradle build 
gradle run 
```

## Design Decisions
I wrote this program using Java as it is the language I am most comfortable in. </br> </br>
Walking through how the program works, I created Object classes for the Encode and Decode objects. These classes had getters 
and setters for the desired information (and could thus be updated to include other information if the needs of the program were to change).
I then created "readers" to read from the CSV and JSON files, using some 3rd party libraries to ease the process. For 
the CSV file, I used Apache commons CSV library to extract the information from the columns, using that 
information to create an ArrayList of all the Encode objects. In a similar method, I used the JSON Simple library to find my desired information
(in this case, the bitlink and the timestamp) to create Decode objects, and added those to an ArrayList. 
</br></br> Once those array lists were made, I created a reader manager that would deal with information handling and the comparative logic
(done using nested for loops). I also had a class file for Outputs, which represented the JSONobjects that were to be displayed to the console.
Once the comparative logic was complete, I used the necessary information to create Output objects, and add those to an ArrayList. This 
ArrayList was then sorted by click count and converted to a JSONArray, which was then printed to the console.
</br></br> I will be honest and say that this is my first time using JSON and CSV files, 
and so the output is not what I was hoping for - if possible, I would love some feedback on how to improve! I ran into some issues that I was unable to resolve on my own
regarding the output and counts for some of the bitlinks. 
</br></br> Thank you to Sharon & Deana, who I have spoken to so far, as well as the rest of the Bitly team for giving me this opportunity! As a student, I still have a lot to learn, and I would be honored 
do that with a great team such as the one you all have.
