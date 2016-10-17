/**
 * @brief Main package for the application
 * 
 * This is the main package for the application developped
 * during "Agile" long-term project in 4th year of INSA Lyon,
 * Computer Engineering department.
 * 
 * This package will only contain the subpackages of the application,
 * which will themselves contain the Java code.
 * 
 * 
 * @authors Thibaut FERNANDEZ
 * @authors Pierre-Louis LEFEBVRE
 * @authors Fadwa MESSAOUDI
 * @authors Joachim DOREL
 * @authors Victor CAPELLE
 * @authors Victoire CHAPELLE
 * @authors Eric JORDAN
 *
 */
package fr.insalyon.if4.h4203.pldagile;

/** @mainpage PLD Agile - INSA Lyon 4IF H4203
 * 
 * @section intro Presentation
 * 
 * This is the Doxygen documentation for the application
 * created during long-term project "PLD AGILE" during 4th year at INSA Lyon,
 * Computer Engineering Department.
 * 
 * The goal of this project is to give students experience
 * in using agile development methods. To reach this goal,
 * students had to develop a delivery drive optimization software.
 * 
 * This documentation covers the software and code made by the group number H4203.
 * 
 * @section dev Development
 * 
 * This software and its accompanying documentation has been developed with the following tools:
 * 
 * @li Eclipse Neon IDE for Java developers
 * @li Java 8 JDK
 * @li Github
 * @li Doxygen
 * @li MiKTeX
 * @li Google Docs
 * @li StarUML
 * @li Balsamiq Mockup
 * 
 * @section usage Usage
 * 
 * @subsection start Starting the program
 * 
 * You will need Java JRE 8 to run the program.
 * 
 * On Windows, download it at
 * <a href="http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html">
 * http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html</a>.
 * 
 * On Linux, install the package <tt>openjdk-8-jre</tt> instead.
 * 
 * Once you have Java installed, start the application.
 * Double-click the main JAR file from your file explorer,
 * or run the following command:
 * 
 * <tt>javaw -jar pldagile.jar</tt>
 * 
 * The file has its own graphical interface, it is better to use @c javaw instead of @c java.
 * It cannot be run in pure command line.
 * 
 * @subsection step1 Loading a map file
 * 
 * When the program starts, it will ask you for an XML file.
 * You must provide a street map file that will be read to generate the map.
 * 
 * Once this map is generated, it will be displayed in the main window.
 * 
 * @subsection step2 Loading a delivery order
 * 
 * To load the delivery order, click on the button "Load delivery order".
 * Alternatively, you can input another street map by clicking "Load street map".
 * 
 * The program will prompt you for an XML file. Select the delivery order file.
 * 
 * Once the file has been read, the position of the warehouse and deliveries
 * ill be highlighted on the map.
 * 
 * @subsection step3 Computing a delivery round
 * 
 * Once you have loaded both a street map and a delivery order,
 * start computing the optimized delivery round by clicking
 * "Compute delivery round".
 * 
 * Alternately, you can load another street map or delivery order
 * by clicking the appropriate buttons.
 * 
 */