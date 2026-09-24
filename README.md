# PSPJ-PROJECT-RESTAURANT-MANAGEMENT
Project Title: Restaurant Order, Kitchen and Billing System
Team No: KLH/PSPJAVA/S<7>/T<15>
<!-- Example format from the norms doc: KLH_CSE_PSPJAVA_T12_CLMS -->
Team Member Names with ID Numbers:
2620090050 – V.Yuvaraj
2620030103 – G.Rishika
2620030509 – P.Sai Tejaswitha
Supervisor's Name: <G.MAMATHA>
Abstract:
The Restaurant Management System is a console-based Java application designed to digitize the core day-to-day operations of a restaurant — table booking, food ordering, kitchen order tracking, and billing. The system allows a user to select one or more available tables from a 32-table layout, place a food order from a fixed menu, and automatically generate an itemized bill inclusive of CGST and SGST. Each order is assigned a unique, randomly generated order number and stored as a structured record — capturing the tables booked, items ordered, total amount, and current status (Pending/Done) — enabling kitchen staff to view a live order queue and mark orders as completed once prepared.
The system is built entirely using core Java constructs — variables, operators, conditional statements, loops (while, do-while), switch-case menus, arrays, and user-defined methods — without relying on external libraries, frameworks, or databases, in line with the current stage of the curriculum. Data is managed in-memory using parallel arrays indexed by a shared order position, demonstrating how structured records can be modeled and manipulated using fundamental array operations and modular method design.
Project Structure:

Restaurant-Order-Kitchen-Billing-System (under this folder)
|— README.md
|— src
    └── RestaurantManagement.java
|— docs
|— data
|— results
|— reports
Execution Instructions:

> javac RestaurantManagement.java
> java RestaurantManagement
