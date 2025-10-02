[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

# SOFE3650 Assignment 2 – Architectural MVC Patterns and Frameworks
**Group 12**
+ Drew Glover - 100914229
+ Reid Hillis - 100915844
+ Ebubechukwu Agwagah - 100937022

**Question 1:**

Swing framework is a toolkit made for Java based applications that allows you to build graphical user interfaces. It lets you create interactive programs by adding features such as buttons, tables, labels, and checkboxes. It is also a lightweight toolkit since all of its components are entirely written in Java, allowing it to render faster than heavyweight toolkits. Swing can also be used across different hardware and operating systems, and supports the MVC design pattern.

<img width="806" height="371" alt="SwingClassDiagram drawio" src="https://github.com/user-attachments/assets/f837d5f4-5c88-406f-8f28-0277e36ae16a" />

<br>**Question 2:**

This example implements the MVC pattern with the model, view, and controller classes. The model class is simply used to store first and last name data. The view class is where all of the Swing UI components are handled. This is where information is displayed to the user. Finally, the controller class connects the model and view. It initializes the view data, then listens for user actions in the UI. Whenever the user saves the names, the controller updates the model, and whenever the user interacts with the UI, the controller updates the view.
